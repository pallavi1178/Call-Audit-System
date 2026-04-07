package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddLocationProperties;
import com.telesoftlabs.pageObjects.DeleteLocationProperties;

public class Tc_DeleteLocationProperties extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_DeleteLocationProperties.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	AddLocationProperties add;
	WebDriverWait wait;
	DeleteLocationProperties delete;
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

	@Test(priority = 2)
	public void deleteLocationProperties()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		delete = new DeleteLocationProperties(driver);
		try {
			logger.info("****** Started Deleting Location Properties ******");
			try {
				if (add.getSubMenu().isDisplayed()) {
					logger.info("Sub Menu Displayed.........");
				}
			} catch (Exception e) {
				logger.info("Sub Menu Not Displayed, clicking on the Setup button.........");
				add.getSetupPage().click();
			}
			wait.until(ExpectedConditions.visibilityOf(add.getLocationPropertiesPage()));
			add.getLocationPropertiesPage().click();
			delete.getDeleteButton(locationName).click();
			wait.until(ExpectedConditions.visibilityOf(delete.getConfirmation()));
			delete.getConfirmation().click();
			logger.info("Location Property deleted Successfully....");
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();
		} catch (Exception e) {
			logger.severe("Failed to delete Location Properties.........:( "+e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	private void assertSnackbar()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			String expectedSnackbar = deleteLocationPropertiesSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for deleting Location Properties is: "+actualSnackbar);
			boolean contains = actualSnackbar.toLowerCase().contains(expectedSnackbar.toLowerCase());
			softAssert.assertTrue(contains, "Snackbar mismatch expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			if (!contains) {
				logger.severe("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
				extentTest.fail("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			}
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
		} catch (Exception e) {
			logger.severe("Failed to assert Snackbar..... "+ e.getMessage());
		}
	}

	private void assertURL()
	{
		try {
			String expectedURL = baseurl+locationPropertiesPageURL;
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
