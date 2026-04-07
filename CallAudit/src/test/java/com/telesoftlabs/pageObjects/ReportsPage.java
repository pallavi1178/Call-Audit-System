package com.telesoftlabs.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telesoftlabs.testCases.LoggingSetup;

public class ReportsPage {
	WebDriver driver;
	WebDriverWait wait;
	ReportsPage1 report;
	public static final Logger log = Logger.getLogger(ReportsPage.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void openReportsPage() {
		report = new ReportsPage1(driver);
		report.getReportsPage().click();
		log.info("Navigated to Reports Page");
	}

	public int getLocationCount() {
		report = new ReportsPage1(driver);
		report.getLocationDropdown().click();
		List<WebElement> locations = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-option")));
		int count = locations.size();
		return count;
	}

	public String selectLocationByIndex(int index) {
		report = new ReportsPage1(driver);
		if (report.getLocationDropdown().getAttribute("aria-expanded").equalsIgnoreCase("true")) {
			log.info("Location Dropdown Expanded......");
		}else {
			log.info("Clicking on the Location Dropdown to expand......");
			report.getLocationDropdown().click();
		}	
		List<WebElement> locations = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-option")));
		String locationName = locations.get(index).getText();
		locations.get(index).click();
		log.info("Selected Location: " + locationName);
		return locationName;
	}

	public void selectReportType(String reportType) {
		report = new ReportsPage1(driver);
		WebElement reportTypeDropdown = report.getReportTypeDropdown();
		reportTypeDropdown.click();
		String optionXpath = "//mat-option//span[contains(text(),'" + reportType + "')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath))).click();
		log.info("Selected Report Type: " + reportType);
	}

	public int getReportCount() {
		report = new ReportsPage1(driver);
		if (report.getReportNameDropdown().getAttribute("aria-expanded").equalsIgnoreCase("true")) {
			log.info("ReportName Dropdown Expanded......");
		}else {
			log.info("Clicking on the ReportName Dropdown to expand......");
			report.getReportNameDropdown().click();
		}		
		List<WebElement> reports = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-option")));
		return reports.size();
	}

	public String openReportByIndex(int index) {
		report = new ReportsPage1(driver);
		if (report.getReportNameDropdown().getAttribute("aria-expanded").equalsIgnoreCase("true")) {
			log.info("ReportName Dropdown Expanded......");
		}else {
			log.info("Clicking on the ReportName Dropdown to expand......");
			report.getReportNameDropdown().click();
		}	
		List<WebElement> reports = driver.findElements(By.xpath("//mat-option"));
		String reportName = reports.get(index).getText();
		reports.get(index).click();
		log.info("Opened Report: " + reportName);
		return reportName;
	}

	public void handlePopup() {
		report = new ReportsPage1(driver);
		try {
			WebElement noRecords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'No records')]")));
			log.warning("No Records Found!");
			report.getOkButton().click();
		} catch (Exception e) {
			log.info("Records found...........");
		}
	}
}
