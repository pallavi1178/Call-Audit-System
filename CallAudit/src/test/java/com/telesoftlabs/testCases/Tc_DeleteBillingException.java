package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddRegion_BillingClass_BillingException;
import com.telesoftlabs.pageObjects.DeleteRegion_BillingClass_BillingException;

public class Tc_DeleteBillingException extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_DeleteBillingException.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	AddRegion_BillingClass_BillingException add;
	DeleteRegion_BillingClass_BillingException delete;
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


	@Test(priority = 2, dependsOnMethods = "login")
	public void deleteBillingException()
	{
		try {
			add = new AddRegion_BillingClass_BillingException(driver);
			delete = new DeleteRegion_BillingClass_BillingException(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			logger.info("***** started Deleting Billing Exception *****");
			try {
				if (add.getSubMenu().isDisplayed()) {
				 logger.info("Displaying sub Menu....");
				}
			} catch (Exception e) {
				logger.info("Sub Menu not found.......");
				add.getSetupPage().click();
			}
			js.executeScript("arguments[0].click();", delete.getCallBillingPage());
			add.getBillingExceptionPage().click();
		    delete.getDeleteBillingExceptionButton(tollFreeNumber).click();
		    wait.until(ExpectedConditions.visibilityOf(delete.getConfirmation()));
		 	delete.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();			
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
            logger.info("Billing Exception Deleted Successfully......");
		} catch (Exception e) {
			logger.severe("Failed to delete Billing Class......"+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void assertURL()
	{
		try {
			String expectedURL = baseurl+callBillingPageURL;
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

	private void assertSnackbar()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		try {
			String expectedSnackbar = deleteBillingExceptionSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for deleting Billing Exception is: "+actualSnackbar);
			boolean contains = actualSnackbar.toLowerCase().contains(expectedSnackbar.toLowerCase());
			softAssert.assertTrue(contains, "Snackbar mismatch expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			if (!contains) {
				logger.severe("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
				extentTest.fail("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to assert Snackbar..... "+ e.getMessage());
		}
	}
}
