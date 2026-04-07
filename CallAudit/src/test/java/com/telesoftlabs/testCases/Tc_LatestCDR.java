package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.LatestCDR;

public class Tc_LatestCDR extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_LatestCDR.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	LatestCDR latest;
	WebDriverWait wait;

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

	@Test(priority = 1, dependsOnMethods = "login")
	public void latestCdr()
	{
		latest = new LatestCDR(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Automating the LatestCDR page ******");
			latest.getLatestCdrPage().click();
			wait.until(ExpectedConditions.elementToBeClickable(latest.getLocationDropdown()));
			latest.getLocationDropdown().click();
			wait.until(ExpectedConditions.visibilityOfAllElements(latest.getOptionsLocation()));

			int locationCount = latest.getOptionsLocation().size();
			logger.info("Total Locations: " + locationCount);

			for(int i=0; i<locationCount; i++)
			{
				if (latest.getLocationDropdown().getAttribute("aria-expanded").equalsIgnoreCase("true")) {
					logger.info("Location Dropdown Expanded......");
				}else {
					logger.info("Clicking on the Location Dropdown to expand......");
					latest.getLocationDropdown().click();
				}	
				List<WebElement> locations =latest.getOptionsLocation();
				WebElement location = locations.get(i);
				String locationName = location.getText();
				logger.info("Checking Location: " + locationName);
				location.click();
				wait.until(ExpectedConditions.or(
						ExpectedConditions.visibilityOfAllElements(latest.getTableRow()),
						ExpectedConditions.visibilityOf(latest.getRecordsNotAvailable())
						));
				List<WebElement> rows = (List<WebElement>) latest.getTableRow();
				WebElement paginationElement = wait.until(ExpectedConditions.visibilityOf(latest.getPaginationElement()));
				String paginationText = paginationElement.getText();
				logger.info("Pagination: " + paginationText);
				if (rows.size() == 0) {
					logger.info("No records found for: " + locationName);
					WebElement noRecordMsg = latest.getRecordsNotAvailable();
					softAssert.assertTrue(noRecordMsg.isDisplayed(),"No Records message missing for location: " + locationName);
					softAssert.assertEquals(paginationText.trim(), "0 of 0","Pagination mismatch for empty data at location: " + locationName);
				} else {
					logger.info("Records found: " + rows.size());
					String totalCount = paginationText.split("of")[1].trim();
					int count = Integer.parseInt(totalCount);
					softAssert.assertTrue(count > 0,"Pagination count should be > 0 for location: " + locationName);
				}
			}
		} catch (Exception e) {
			logger.severe("Failed to fetch Latest CDR...... "+ e.getClass() +" "+ e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
}
