package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddExtension;
import com.telesoftlabs.pageObjects.Update_Delete_Extension;

public class Tc_UpdateExtension extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_UpdateExtension.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	AddExtension add;
	WebDriverWait wait;
	Update_Delete_Extension update;
	SoftAssert softAssert = new SoftAssert();

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
	public void searchAndUpdateExtension()
	{
		add = new AddExtension(driver);
		update = new Update_Delete_Extension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			searchExtension();
			updateExtension();
			assertURL();
		} catch (Exception e) {
			logger.severe("Failed to Search/Update Extension......:( "+e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	public boolean isNoRecordsFound() {
		try {
			// wait.until(ExpectedConditions.visibilityOf(update.getRecordsNotAvailable()));
			return update.getRecordsNotAvailable().isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public int getRowCountSafe() {
		update = new Update_Delete_Extension(driver);
		List<WebElement> tableRows = update.getTableRows();
		if (isNoRecordsFound()) {
			return 0;
		}
		return tableRows.size();
	}

	public void updateExtension()
	{
		add = new AddExtension(driver);
		update = new Update_Delete_Extension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			logger.info("****** Started Updating the Extension ******");
			// Wait for either table OR no records message
			wait.until(driver -> update.getTableRows().size() > 1 || isNoRecordsFound());
			if (isNoRecordsFound()) {
				logger.warning("No records found for given range: " + fromExtension + " - " + toExtension);
			} else {
				logger.info("No, 'Records Not Available' Message Found, continuing update extension process...");
				int count = getRowCountSafe();
				logger.info("Total Records Found: " + count);

				//Continue normal flow
				update.getEditButton().click();
				String updatedName = "Ext_" + System.currentTimeMillis();
				add.getExtensionUsername().clear();
				add.getExtensionUsername().sendKeys(updatedName);
				logger.info("Updated Extension Username: "+updatedName);
				update.getUpdateButton().click();
				wait.until(ExpectedConditions.visibilityOf(update.getConfirmation()));
				update.getConfirmation().click();

				wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
				String msg = add.getSnackBar().getText();
				logger.info("Actual Snackbar found: "+msg);
				softAssert.assertTrue(msg.toLowerCase().contains("updated"), "Unexpected message: " + msg);
				WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
				dismiss.click();
				logger.info("Clicked on Close button");
				// Re-verify
				searchExtension();
				String actualName = update.getUsernameFromSearchResult().getText();
				logger.info("Expected Name: " + updatedName);
				logger.info("Actual Name from UI: " + actualName);
				softAssert.assertTrue(actualName.contains(updatedName.substring(0, 15)),"Expected: " + updatedName + " but found: " + actualName);
			}
		} catch (Exception e) {
			logger.severe("Failed to Update Extension......:( "+e.getMessage());
		}
	}

	public void searchExtension()
	{
		add = new AddExtension(driver);
		update = new Update_Delete_Extension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Searching the Extension ******");
			add.getExtensionPage().click();
			wait.until(ExpectedConditions.visibilityOf(update.getSearchExtension()));
			update.getSearchExtension().click();
			wait.until(ExpectedConditions.visibilityOf(update.getSearchButton()));
			add.getFromExtension().sendKeys(fromExtension);
			logger.info("Searching Extensions to: "+fromExtension);
			if (toExtension !=null && !toExtension.isEmpty()) {
				add.getToExtension().click();
				add.getToExtension().clear();
				add.getToExtension().sendKeys(toExtension);
				logger.info("Searching Extensions to: "+toExtension);
			} else {
				add.getToExtension().sendKeys(toExtension);
				logger.info("Searching Extensions to: "+toExtension);
			}	
			update.getSearchButton().click();
		} catch (Exception e) {
			logger.severe("Failed to Search Extension......:( "+e.getMessage());
		} 
	}
	
	private void assertURL()
	{
		try {
			String expectedURL = baseurl+extensionPageURL;
			String actualURL = driver.getCurrentUrl();
			logger.info("Actual URL of the page is: "+actualURL);
			boolean contains = actualURL.toLowerCase().contains(expectedURL.toLowerCase());
			softAssert.assertTrue(contains, "URL mismatch expected ["+expectedURL+"] but found ["+actualURL+"]");
			if (!contains) {
				logger.severe("Mismatch in the URL expected ["+expectedURL+"] but found ["+actualURL+"]");
				extentTest.fail("Mismatch in the URL expected ["+expectedURL+"] but found ["+actualURL+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to assert URL..... "+ e.getMessage());
		}
	}
}
