package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.Login;

public class Tc_Login extends BaseClass {
	
	Login login;
	public static final Logger logger = Logger.getLogger(Tc_Login.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
	
	@Test(dataProvider = "loginData", dataProviderClass = BaseClass.class)
	public void login(String username, String password) throws InterruptedException
	{
		try {
			login = new Login(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.get(baseurl);
			wait.until(ExpectedConditions.visibilityOf(login.getUsername()));
			login.getUsername().sendKeys(username);
			logger.info("Login Username is: "+username);
			login.getPassword().sendKeys(password);
			logger.info("Login Password is: "+password);
			login.getLoginButton().click();
			Thread.sleep(1000);
			try {
				if (login.getConfirmPreviousSessionLogout().isDisplayed()) {
					handleSessionConflict();
				}
			} catch (Exception e) {
				logger.info("Session conflict modal not found ");
			}
			if (username.isEmpty() || password.isEmpty())
			{
				logger.info("Username or password is required");			
			}
			else 
			{
				wait.until(ExpectedConditions.visibilityOf(login.getSnackBar()));
				String appTitle=driver.getTitle();  
				logger.info("Login to the application ["+appTitle+"] is successfull");
				extentTest.info("Login successfull");
				SoftAssert softAssert = new SoftAssert();
				/*****URL assertion*****/
				String expectedUrl = baseurl+dashboardPageURL;
				String actualUrl = driver.getCurrentUrl();
				logger.info("Expected URL is: "+expectedUrl);
				logger.info("Actual URL is: "+actualUrl);
				String actualSnackBar = login.getSnackBar().getText();
				if (actualSnackBar.toLowerCase().contains("success")) {
					String expectedSnackBar = loginSnackBar;
					logger.info("Actual snackbar is: "+actualSnackBar);
					boolean contains = actualSnackBar.toLowerCase().startsWith(expectedSnackBar.toLowerCase());
					softAssert.assertTrue(contains, "SnackBar mismatched for valid login");
					if (!actualUrl.toLowerCase().equals(expectedUrl.toLowerCase())) 
					{
						logger.severe("URL assertion failed Expected URL is: ["+expectedUrl+ "] But found: ["+actualUrl+"]");
						extentTest.fail("URL assertion failed");
					}
					softAssert.assertEquals(actualUrl, expectedUrl, "Url mismatched");
				} else
				{
					String expectedSnackBar = invalidUsernameOrPassword;
					logger.info("Actual snackbar is: "+actualSnackBar);
					boolean contains = actualSnackBar.toLowerCase().startsWith(expectedSnackBar.toLowerCase());
					if (!contains) {
						logger.severe("Snackbar Assertion failed, Expected snackbar is: ["+expectedSnackBar+ "] But found: ["+actualSnackBar+"]");
						extentTest.fail("Snackbar assertion failed");
					}
					softAssert.assertTrue(contains, "SnackBar mismatched for invalid login");
					logger.info("User is trying to login with invalid credentials");
				}
				WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
				dismiss.click();
				logger.info("Clicked on Close button");
			}		
			logger.info("Login successfull.......:)");
			extentTest.info("Login Successfull");
		} catch (Exception e) {
			logger.warning("Login Failed.......:("+ e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void handleSessionConflict()
	{
		login = new Login(driver);
		try {
			logger.warning("Found Session conflict modal, need to logout from the other session which is currently active.");
			login.getConfirmPreviousSessionLogout().click();
			logger.info("Clicked on confirmation(OK) button, to logout from the active session.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
