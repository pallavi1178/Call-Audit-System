package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddExtension;
import com.telesoftlabs.pageObjects.Import_Export_Extensions;
import com.telesoftlabs.pageObjects.Update_Delete_Extension;

public class Tc_ExportExtensions extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_ImportExtension.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	AddExtension add;
	WebDriverWait wait;
	Update_Delete_Extension update;
	Import_Export_Extensions importExt;
	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1)
	public void login()
	{
		try{
			Tc_Login login = new Tc_Login();
			login.login(username, password);
		} catch (Exception e){
			logger.severe("Failed to login...... "+ e.getClass() +" "+ e.getMessage());
			softAssert.fail("Failed while Login.... "+e.getMessage());
		}
	}
	
	@Test(priority = 2, dependsOnMethods = "login")
	public void exportExtensions()
	{
		add = new AddExtension(driver);
		update = new Update_Delete_Extension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		importExt = new Import_Export_Extensions(driver);
		try {
			logger.info("****** Started Exporting the Extensions ******");
			add.getExtensionPage().click();
			wait.until(ExpectedConditions.visibilityOf(importExt.getExportButton()));
			importExt.getExportButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			String snackbar = add.getSnackBar().getText();
			logger.info("Obtained Snackbar is: "+snackbar);
			assertSnackbar(snackbar);
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			assertURL();
		} catch (Exception e) {
			logger.severe("Failed to Export Extensions.......:( "+e.getMessage());
			softAssert.fail("Exception occurred: " + e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	public void assertSnackbar(String snackbar)
	{
		add = new AddExtension(driver);
		try {
			if (snackbar.toLowerCase().contains("successful")) {
				logger.info("Export completed successfully");
			    softAssert.assertTrue(true, "Export success message validated");
			}else if (snackbar.toLowerCase().contains("extensions available")) {
				 logger.warning("No data available for export");
				    // Validate table empty message
				    WebElement noRecordMsg = importExt.getRecordsNotAvailableMessage();				    
				    softAssert.assertTrue(noRecordMsg.isDisplayed(), "'Records Not Available' message NOT displayed in table");
			}else {
				 softAssert.fail("Unexpected snackbar message: " + snackbar);
			}
		} catch (Exception e) {
			logger.severe("Failed While Asserting the Snackbar.....:( "+e.getMessage());
			softAssert.fail("Failed While Asserting the Snackbar.....:( "+e.getMessage());
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
