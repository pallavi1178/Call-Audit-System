package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddUser;

public class Tc_AddUser extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_AddUser.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
    AddUser add;
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
	public void addUser()
	{
		add = new AddUser(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** Started Adding User *****");
			add.getUsersPage().click();
			addUser(user);
			wait.until(ExpectedConditions.visibilityOf(add.getConfirmation()));
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			assertURL();
			logger.info("User Created Successfully....");
		} catch (Exception e) {
			logger.severe("Failed to add Users...... "+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void addUser(String userName)
	{
		add = new AddUser(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getAddUsersButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getUsername()));
			add.getUsername().sendKeys(userName);
			logger.info("Created User name is: "+userName);
			add.getDisplayName().sendKeys(displayName);
			logger.info("Display name is: "+displayName);
			add.getPassword().sendKeys(userPassword);
			logger.info("Added Password is: "+userPassword);
			add.getEmail().sendKeys(userEmail);
			logger.info("Added Email is: "+userEmail);
			selectRandomRole();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(add.getLocationDropdown()));
			add.getLocationDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAllLocation()));
			add.getAllLocation().click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", add.getsaveButton());
		} catch (Exception e) {
			logger.severe("Failed to add User with the name "+userName+" "+e.getMessage());
		}
	}
	
	private void selectRandomRole()
	{
		add = new AddUser(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			// Selects Random Role from the Dropdown
			add.getSelectRoleDropdown().click();
			List<WebElement> dropdownRoleOptions = add.getAllRoles();
			if (dropdownRoleOptions == null || dropdownRoleOptions.isEmpty()) {
				logger.info("No Roles are available in the dropdown.");
				return;
			}
			String[] roles = new String[dropdownRoleOptions.size()];
			for (int i = 0; i < dropdownRoleOptions.size(); i++) {
				roles[i] = dropdownRoleOptions.get(i).getText().trim();				
			}
			logger.info("Roles available in dropdown: " + Arrays.toString(roles));
			rolesSelected = false;
			for(int j =0; j < roles.length; j++)
			{
				Random random = new Random();
				int randomIndex = random.nextInt(roles.length);
				String selectedRole = roles[randomIndex];
				logger.info("Selected Role is: "+selectedRole);
				String role=add.OptionRole(driver, selectedRole).getText();
				if (!add.OptionRole(driver, selectedRole).getAttribute("aria-disabled").equalsIgnoreCase("true")) {            	
					add.OptionRole(driver, selectedRole).click();
					logger.info("Selected Role is: "+ role);
					break;
				} else {
					logger.info(role + " Role is disabled, trying the next roles.");
				}
			}
		} catch (Exception e) {
			logger.severe("Failed to select the random Role from the dropdown......:(  "+ e.getMessage());	
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
			String expectedSnackbar = addUsersSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding Users is: "+actualSnackbar);
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
