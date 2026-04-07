package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddExtension;

public class Tc_AddExtension extends BaseClass{

	public static final Logger logger = Logger.getLogger(Tc_AddExtension.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	AddExtension add;
	WebDriverWait wait;
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
	public void addExtension()
	{
		add = new AddExtension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Adding Extension ******");
			add.getExtensionPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
			add.getAddButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getLocationDropdown()));
			add.getLocationDropdown().click();
			selectRandomLocation();
			wait.until(ExpectedConditions.invisibilityOfAllElements(add.getOptionsLocation()));
			add.getFromExtension().sendKeys(fromExtension);
			logger.info("Adding Extensions from: "+fromExtension);
			if (toExtension !=null && !toExtension.isEmpty()) {
				add.getToExtension().click();
				add.getToExtension().clear();
				add.getToExtension().sendKeys(toExtension);
				logger.info("Adding Extensions to: "+toExtension);
			} else {
				add.getToExtension().sendKeys(toExtension);
				logger.info("Adding Extensions to: "+toExtension);
			}		
			add.getBillingClassDropdown().click();
			selectRandomBillingClass();
			wait.until(ExpectedConditions.invisibilityOfAllElements(add.getOptionsBillingClass()));
			add.getExtensionUsername().sendKeys(extensionUsername);
			logger.info("Adding Extension User name is: "+extensionUsername);
			add.getTrunkName().sendKeys(trunkName);
			logger.info("Adding Trunk Name is: "+trunkName);
			add.getSaveButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getConfirmation()));
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			assertURL();
			logger.info("Extension Created Successfully....");
		} catch (Exception e) {
			logger.severe("Failed to add Extension......:( "+ e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	private void selectRandomLocation() {
	    add = new AddExtension(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    try {
	        logger.info("*** Started Randomly Selecting the Location ***");
	        List<WebElement> locations = add.getOptionsLocation();
	        int locationCount = locations.size();
	        logger.info("Total Locations: " + locationCount);
	        if (locationCount <= 0) {
	            logger.warning("No valid locations available to select.");
	            return;
	        }
	        Random random = new Random();
	        // Skip index 0 ----- start from 1
	        int randomIndex = random.nextInt(locationCount);
	        WebElement selectedLocation = locations.get(randomIndex);
	        logger.info("Selecting Location: " + selectedLocation.getText());
	        wait.until(ExpectedConditions.elementToBeClickable(selectedLocation));
	        selectedLocation.click();
	    } catch (Exception e) {
	        logger.severe("Failed to select Random Location...:( " + e.getMessage());
	    }
	}
	
	private void selectRandomBillingClass() {
	    add = new AddExtension(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    try {
	        logger.info("*** Started Randomly Selecting the Billing Class ***");
	        List<WebElement> billingClasses = add.getOptionsBillingClass();
	        int billingClassCount = billingClasses.size();
	        logger.info("Total Billing Class: " + billingClassCount);
	        if (billingClassCount <= 1) {
	            logger.warning("No valid Billing Class available to select.");
	            return;
	        }
	        Random random = new Random();
	        // Skip index 0 ----- start from 1
	        int randomIndex = random.nextInt(billingClassCount - 1) + 1;
	        WebElement selectedBillingClass = billingClasses.get(randomIndex);
	        logger.info("Selecting Billing Class: " + selectedBillingClass.getText());
	        wait.until(ExpectedConditions.elementToBeClickable(selectedBillingClass));
	        selectedBillingClass.click();
	    } catch (Exception e) {
	        logger.severe("Failed to select Random BillingClass...:( " + e.getMessage());
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

	private void assertSnackbar()
	{
		add = new AddExtension(driver);
		try {
			String expectedSnackbar = addExtensionSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding Extension is: "+actualSnackbar);
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
