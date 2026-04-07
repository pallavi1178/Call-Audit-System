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

public class Tc_AddBillingClass extends BaseClass{

	public static final Logger logger = Logger.getLogger(Tc_AddBillingClass.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	AddRegion_BillingClass_BillingException add;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	/*
	@BeforeClass
	public void initPageObjects() {
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	}
	*/
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
	public void addBillingClass()
	{
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		add = new AddRegion_BillingClass_BillingException(driver);
		try {
			logger.info("***** started Adding Billing Class *****");
			try {
				if (add.getSubMenu().isDisplayed()) {
				 logger.info("Displaying sub Menu....");
				}
			} catch (Exception e) {
				logger.info("Sub Menu not found.......");
				add.getSetupPage().click();
			}
			//add.getSetupPage().click();
			addBillingClass(billingClass);
			logger.info("Billing Class Added Successfully......");
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();
			//duplicateBillingClass();
		} catch (Exception e) {
			logger.severe("Failed to Add Billing class....."+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void addBillingClass(String billingClassName)
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
			try {
				add.getBillingClassPage().click();
				wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
				add.getAddButton().click();
				wait.until(ExpectedConditions.visibilityOf(add.getBillingClassName()));
				add.getBillingClassName().sendKeys(billingClassName);
				logger.info("Added Billing Class name is: "+billingClassName);
				add.getCallTypeDropdown().click();
				add.getCallTypeLocal().click();
				add.getGracePeriod().clear();
				add.getGracePeriod().sendKeys(gracePeriod);
				logger.info("Added Grace Period is: "+ gracePeriod);
				add.getPulseInSeconds().clear();
				add.getPulseInSeconds().sendKeys(pulseInSeconds);
				logger.info("Added Pulse In Seconds is: "+pulseInSeconds);
				add.getChargePerPulse().clear();
				add.getChargePerPulse().sendKeys(chargePerPulse);
				logger.info("Added Charge per Pulse is: "+chargePerPulse);
				add.getMarkupPercentage().clear();
				add.getMarkupPercentage().sendKeys(markupPercentage);
				logger.info("Added Markup percentage: "+markupPercentage);
				add.getSurCharge().clear();
				add.getSurCharge().sendKeys(surcharge);
				logger.info("Added Surcharge is: "+surcharge);				
				wait.until(ExpectedConditions.elementToBeClickable(add.getSaveButton()));
				add.getSaveButton().click();
			} catch (Exception e) {
				logger.severe("Failed to Add Billing Class "+e.getMessage());
			}
	}
	
	private void assertSnackbar()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		try {
			String expectedSnackbar = addBillingClassSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding region is: "+actualSnackbar);
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
	
	//@Test(priority = 3, dependsOnMethods = "addBillingClass")
	private void duplicateBillingClass()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** started Adding Duplicate Billing Class *****");
			addBillingClass(billingClass);
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicateRegion()));
			assertDuplicateBillingClass();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate Billing Class Testcase Failed...........:(");
		}
	}
	
	private void assertDuplicateBillingClass()
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
			logger.severe("Failed to Assert Heading Duplicate Billing Class..... "+e.getMessage());
		}
	}
}
