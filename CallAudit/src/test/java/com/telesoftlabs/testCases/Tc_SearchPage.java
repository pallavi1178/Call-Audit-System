package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.SearchPage;

public class Tc_SearchPage extends BaseClass{
	String expandButtonStatus;

	public static final Logger logger = Logger.getLogger(Tc_SearchPage.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	SoftAssert softAssert = new SoftAssert();
	WebDriverWait wait;

	@Test(priority = 1)
	public void login()
	{
		logger.info("===== START: Login Test =====");
		try{
			logger.info("Attempting to login with username: " + username);
			Tc_Login login = new Tc_Login();
			login.login(username, password);
			logger.info("Login successful");
		} catch (Exception e){
			logger.severe("Failed to login...... "+ e.getClass() +" "+ e.getMessage());
		}
		logger.info("===== END: Login Test =====");
	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void verifySearchFunctionality() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		logger.info("===== START: Search Functionality Test =====");
		SearchPage searchPage = new SearchPage(driver);
		logger.info("Navigating to Search Page");
		searchPage.getSearchPage().click();
		wait.until(ExpectedConditions.invisibilityOf(searchPage.getSpinner()));
		wait.until(ExpectedConditions.visibilityOf(searchPage.getFilterAlt()));
		wait.until(ExpectedConditions.elementToBeClickable(searchPage.getFilterAlt()));
		expandButtonStatus=searchPage.getFilterAlt().getText();
		logger.info("Expand Button Status is: "+expandButtonStatus);
		if (expandButtonStatus.toLowerCase().contains("off".toLowerCase())) {
			searchPage.getFilterAltOff().click();
			logger.info("Clicked on filter button..........");
		}
		else {
			logger.info("Filters are visible......:) ");
		}

		logger.info("Applying search filters");
		// Apply filters
		searchPage.applyFilters(
				searchLocation,
				searchDirection,
				searchDuration,
				searchCallType,
				searchExtension,
				searchTrunk,
				searchDialedNumber
				);
		logger.info("Clicking on Search button using JavaScriptExecutor");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", searchPage.getSearchButton());
		logger.info("Search triggered, validating results...");
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfAllElements(searchPage.getResultRows()),
				ExpectedConditions.visibilityOf(searchPage.getRecordsNotAvailable())
				));
		if (searchPage.isRecordsDisplayed()) {
			logger.info("Records are displayed in search results");
			softAssert.assertTrue(true);
			validateFirstRow(
					searchLocation,
					searchDirection,
					searchDuration,
					searchCallType,
					searchExtension,
					searchTrunk,
					searchDialedNumber
					);
		} else if (searchPage.isNoRecordsMessageDisplayed()) {
			logger.warning("No records found for given filters");
			softAssert.assertTrue(true);
		} else {
			logger.severe("Neither results nor 'No Records' message displayed");
			softAssert.fail("Neither results nor 'No Records' message displayed");
		}
		logger.info("===== END: Search Functionality Test =====");
	}

	public boolean validateFirstRow(String location, String direction, String durationVal, String callTypeVal,String ext, String trunkVal, String dialNum) 
	{
		SearchPage searchPage = new SearchPage(driver);
		SoftAssert softAssert = new SoftAssert();

		try {
			logger.info("Validating first row data with applied filters");

			// First row
			WebElement firstRow = searchPage.getResultRows().get(0);

			// Columns
			List<WebElement> columns = firstRow.findElements(By.tagName("td"));

			String resLocation = columns.get(6).getText();
			logger.info("Location present in Search result is: "+resLocation);
			String resDirection = columns.get(4).getText();
			logger.info("Direction present in Search result is: "+resDirection);
			String resDuration = columns.get(1).getText();
			logger.info("Duration present in Search result is: "+resDuration);
			String resCallType = columns.get(5).getText();
			logger.info("Call Type present in Search result is: "+resCallType);
			String resExtension = columns.get(2).getText();
			logger.info("Extension present in Search result is: "+resExtension);
			String resTrunk = columns.get(9).getText();
			logger.info("Trunk present in Search result is: "+resTrunk);
			String resDialNum = columns.get(3).getText();
			logger.info("Dialed Number present in Search result is: "+resDialNum);

			// Validation (skip if null/empty)

			if (location != null && !location.isEmpty() && !location.equalsIgnoreCase("all")) {
				logger.info("Validating Location...");
				softAssert.assertTrue(resLocation.contains(location),
						"Location mismatch. Expected: " + location + " Found: " + resLocation);
			}

			if (direction != null && !direction.isEmpty()) {
				logger.info("Validating Call Direction...");
				softAssert.assertTrue(resDirection.contains(direction),
						"Direction mismatch. Expected: " + direction + " Found: " + resDirection);
			}

			if (durationVal != null && !durationVal.isEmpty() && !durationVal.equalsIgnoreCase("any")) {
				logger.info("Validating Duration...");
				softAssert.assertTrue(resDuration.contains(durationVal),
						"Duration mismatch. Expected: " + durationVal + " Found: " + resDuration);
			}

			if (callTypeVal != null && !callTypeVal.isEmpty() && !callTypeVal.equalsIgnoreCase("all")) {
				logger.info("Validating Call Type...");
				softAssert.assertTrue(resCallType.contains(callTypeVal),
						"Call Type mismatch. Expected: " + callTypeVal + " Found: " + resCallType);
			}

			if (ext != null && !ext.isEmpty()) {
				logger.info("Validating Extension...");
				softAssert.assertTrue(resExtension.contains(ext),
						"Extension mismatch. Expected: " + ext + " Found: " + resExtension);
			}

			if (trunkVal != null && !trunkVal.isEmpty()) {
				logger.info("Validating Trunk...");
				softAssert.assertTrue(resTrunk.contains(trunkVal),
						"Trunk mismatch. Expected: " + trunkVal + " Found: " + resTrunk);
			}

			if (dialNum != null && !dialNum.isEmpty()) {
				logger.info("Validating Dialed Number...");
				softAssert.assertTrue(resDialNum.contains(dialNum),
						"Dialed Number mismatch. Expected: " + dialNum + " Found: " + resDialNum);
			}

			// This will throw if any assertion failed
			softAssert.assertAll();

			logger.info(" First row validation successful");
			return true;

		} catch (AssertionError ae) {
			logger.severe("Validation failed: " + ae.getMessage());
			return false;

		} catch (Exception e) {
			logger.severe("Error while validating first row: " + e.getMessage());
			return false;
		}
	}
}