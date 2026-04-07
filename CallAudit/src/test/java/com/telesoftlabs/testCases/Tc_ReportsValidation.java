package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.telesoftlabs.pageObjects.ReportsPage;
import com.telesoftlabs.pageObjects.ReportsPage1;

public class Tc_ReportsValidation extends BaseClass{

	public static final Logger logger = Logger.getLogger(Tc_ReportsValidation.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	ReportsPage1 report;
	@Test(priority = 1)
	public void login()
	{
		try{
			Tc_Login login = new Tc_Login();
			login.login(username, password);
		} catch (Exception e){
			logger.severe("Failed to login...... "+ e.getClass() +" "+ e.getMessage());
		}
	}
	@Test(priority = 2, dependsOnMethods = "login")
	public void validateAllReports() throws InterruptedException {
		ReportsPage rp = new ReportsPage(driver);
		rp.openReportsPage();
		int locationCount = rp.getLocationCount();
		for (int i = 1; i < locationCount; i++) {
			String location = rp.selectLocationByIndex(i);
			Thread.sleep(2000);
			// Summary Reports
			executeReportsFlow(rp, "Summary");
			// Detailed Reports
			executeReportsFlow(rp, "Detailed");
			logger.info("Completed for Location: " + location);
		}
	}

	// Common Flow for Report Types
	/*
	public void executeReportsFlow(ReportsPage rp, String reportType) throws InterruptedException {
		report = new ReportsPage1(driver);
		rp.selectReportType(reportType);
		Thread.sleep(2000);
		int reportCount = rp.getReportCount();

		for (int j = 0; j < reportCount; j++) {

			String reportName = rp.openReportByIndex(j);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", report.getShowReportButton());
			//report.getShowReportButton().click();
			rp.handlePopup();

			// Navigate back
			//driver.navigate().back();

			log.info("Completed Report: " + reportName);
		}
	}
	*/
		
	public void executeReportsFlow(ReportsPage rp, String reportType) throws InterruptedException {
	    report = new ReportsPage1(driver);
	    rp.selectReportType(reportType);
	    Thread.sleep(2000);
	    int reportCount = rp.getReportCount();
	    for (int j = 0; j < reportCount; j++) {
	        String reportName = rp.openReportByIndex(j);
	        String parentWindow = driver.getWindowHandle();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", report.getShowReportButton());
	        boolean isPopupDisplayed = false;
	        try {
	            // Wait briefly for "No records" popup
	            WebElement noRecords = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'No records')]")));
	            logger.warning("No records for report: " + reportName);
	            report.getOkButton().click();
	            isPopupDisplayed = true;
	        } catch (Exception e) {
	            // No popup -> Means report opened in new tab
	            isPopupDisplayed = false;
	        }
	        // If popup NOT displayed -> handle new tab
	        if (!isPopupDisplayed) {
	            try {
	                new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);
	                for (String window : driver.getWindowHandles()) {
	                    if (!window.equals(parentWindow)) {
	                        driver.switchTo().window(window);
	                        String url = driver.getCurrentUrl();
	                        logger.info("Report URL: " + url);
	                        if (url.startsWith("blob:")) {
	                        	logger.info("Report opened successfully: " + reportName);
	                        } else {
	                        	logger.warning("Unexpected URL: " + url);
	                        }
	                        driver.close();
	                        break;
	                    }
	                }
	                driver.switchTo().window(parentWindow);
	            } catch (Exception e) {
	            	logger.severe("New tab not handled for report: " + reportName+ " "+ e.getMessage());
	            }
	        }
	        logger.info("Completed Report: " + reportName);
	    }
	}
}
