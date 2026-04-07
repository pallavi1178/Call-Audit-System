package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddRegion_BillingClass_BillingException;

public class Tc_AddRegion extends BaseClass {

	public static final Logger logger = Logger.getLogger(Tc_AddRegion.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	AddRegion_BillingClass_BillingException add;
	WebDriverWait wait;

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
	public void addRegion()
	{
		try {
			add = new AddRegion_BillingClass_BillingException(driver);
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
			addRegion(countryName,countryCode,IDD,NDD,areacode,fixedLineStartDigits,mobileStartDigits,serviceProviderName,networkStartDigits);
			add.getConfirmation().click();
			logger.info("Region Added Successfully");
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();			
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			duplicateRegion();
		} catch (Exception e) {
			logger.severe("Failed to add Region......"+e.getMessage());
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
			String expectedSnackbar = addRegionSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding region is: "+actualSnackbar);
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
	
	//@Test(priority = 3, dependsOnMethods = "addRegion")
	public void duplicateRegion()
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		try {
			logger.info("***** started Adding Duplicate Region *****");
			addRegion(countryName,countryCode,IDD,NDD,areacode,fixedLineStartDigits,mobileStartDigits,serviceProviderName,networkStartDigits);
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicateRegion()));
			assertDuplicateRegion();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate Region testcase failed..... "+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void addRegion(String countryName, String countryCode, String IDD, String NDD, String areacode, String fixedLineStartDigits, String mobileStartDigits, String serviceProviderName, String networkStartDigits)
	{
		add = new AddRegion_BillingClass_BillingException(driver);
		wait  = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		try {
			wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
			add.getAddButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getCountryName()));
			add.getCountryName().sendKeys(countryName);
			logger.info("Country name is: "+countryName);
			add.getCountryCode().sendKeys(countryCode);
			logger.info("Country code is: "+countryCode);
			add.getIDD().sendKeys(IDD);
			logger.info("IDD is: "+ IDD);
			add.getNDD().sendKeys(NDD);
			logger.info("NDD is: "+NDD);
			add.getAreaCode().sendKeys(areacode);
			logger .info("Area code is: "+areacode);
			add.getFixedLineStartDigits().sendKeys(fixedLineStartDigits);
			logger.info("Fixed Line Start Digits is: "+fixedLineStartDigits);
			add.getMobileStartDigits().sendKeys(mobileStartDigits);
			logger.info("Mobile Start Digits is: "+mobileStartDigits);
			add.getServiceProviderName().sendKeys(serviceProviderName);
			logger.info("Service Provider is: "+serviceProviderName);
			add.getNetworkStartDigits().sendKeys(networkStartDigits);
			logger.info("Network Start Digits is: "+networkStartDigits);
			add.getSaveButton().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.severe("Failed while adding the inputs to the fields..... "+ e.getMessage());
		}		
	}
	
	private void assertDuplicateRegion()
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
			logger.severe("Failed to Assert Heading Duplicate Region..... "+e.getMessage());
		}
	}
}
