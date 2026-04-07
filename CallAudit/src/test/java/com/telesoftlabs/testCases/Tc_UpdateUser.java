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

import com.telesoftlabs.pageObjects.AddUser;
import com.telesoftlabs.pageObjects.UpdateUser;

public class Tc_UpdateUser extends BaseClass {
	public static final Logger logger = Logger.getLogger(Tc_UpdateUser.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
    AddUser add;
    UpdateUser update;
	WebDriverWait wait;
	boolean rolesSelected;

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
	public void updateUser()
	{
		add = new AddUser(driver);
		update = new UpdateUser(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** Started Updating the User *****");
			add.getUsersPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddUsersButton()));
			update.getUpdateButton(user).click();
			wait.until(ExpectedConditions.visibilityOf(update.getUpdateButton()));
			/*
			add.getLocationDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAllLocation()));
			add.getAllLocation().click();
			*/
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", update.getUpdateButton());
			wait.until(ExpectedConditions.visibilityOf(update.getConfirmation()));
			update.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			assertURL();
			logger.info("User Updated Successfully....");
		} catch (Exception e) {
			logger.severe("Failed to Update the User....."+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void assertURL()
	{
		try {
			String expectedURL = baseurl+usersPageURL;
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
		add = new AddUser(driver);
		try {
			String expectedSnackbar = updateUserSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for Updating Users is: "+actualSnackbar);
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
