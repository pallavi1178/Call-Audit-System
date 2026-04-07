package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddRegion_BillingClass_BillingException;

public class Tc_AddBillingException extends BaseClass{

	public static final Logger logger = Logger.getLogger(Tc_AddBillingException.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	AddRegion_BillingClass_BillingException add;
	WebDriverWait wait;

	@BeforeClass
	public void initPageObjects() {
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	}


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
	public void addBillingException()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** started Adding Region *****");
			try {
				if (add.getSubMenu().isDisplayed()) {
				 logger.info("Displaying sub Menu....");
				}
			} catch (Exception e) {
				logger.info("Sub Menu not found.......");
				add.getSetupPage().click();
			}
			//add.getSetupPage().click();
			addBillingException(tollFreeNumber);
			add.getConfirmation().click();
			logger.info("Billing Exception Added Successfully.....");
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();
			duplicateBillingException();
		} catch (Exception e) {
			logger.severe("Failed to Add Billing Exception........:( "+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	public void addBillingException(String tollFreeNumber)
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getBillingExceptionPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
			add.getAddButton().click();
			add.getTollFreeNumber().sendKeys(tollFreeNumber);
			logger.info("Toll-Free Number is: "+tollFreeNumber);
			add.getdesccription().sendKeys(description);
			logger.info("Added Description is: "+description);
			add.getPulseInSeconds().clear();
			add.getPulseInSeconds().sendKeys(pulseInSeconds);
			logger.info("Added Pulse in Seconds is: "+pulseInSeconds);
			add.getChargePerPulse().clear();
			add.getChargePerPulse().sendKeys(chargePerPulse);
			logger.info("Added Charge per Pulse is: "+chargePerPulse);
			add.getGracePeriod().clear();
			add.getGracePeriod().sendKeys(gracePeriod);
			logger.info("Added Grace Period is: "+gracePeriod);
			wait.until(ExpectedConditions.elementToBeClickable(add.getSaveButton()));
			add.getSaveButton().click();
		} catch (Exception e) {
			logger.severe("Failed to Add Billing Exception. "+e.getMessage());
		}
	}
	
	private void assertSnackbar()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		try {
			String expectedSnackbar = addBillingExceptionSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding Billing exception is: "+actualSnackbar);
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
	
	//@Test(priority = 3, dependsOnMethods = "addBillingException")
	private void duplicateBillingException()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** started Adding Duplicate Billing Exception *****");
			addBillingException(tollFreeNumber);
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicateRegion()));
			assertDuplicateBillingException();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate Billing Exception Testcase Failed...........:(");
		}finally {
			softAssert.assertAll();
		}
	}
	
	private void assertDuplicateBillingException()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		try {
			String expectedHeading = "Duplicate Entry";
			String actualHeading = add.getDuplicateRegion().getText();
			logger.info("Actual Heading obtaining for adding region is: "+actualHeading);
			boolean contains = actualHeading.toLowerCase().contains(expectedHeading.toLowerCase());
			softAssert.assertTrue(contains, "Heading mismatch expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			if (!contains) {
				logger.severe("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
				extentTest.fail("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to Assert Heading Duplicate Billing Exception..... "+e.getMessage());
		}
	}
}
