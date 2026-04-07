package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddRoles;
import com.telesoftlabs.pageObjects.DeleteRoles;

public class Tc_DeleteRoles extends BaseClass {

	public static final Logger logger = Logger.getLogger(Tc_DeleteRoles.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	
	SoftAssert softAssert = new SoftAssert();
	WebDriverWait wait;
	DeleteRoles delete;
	AddRoles add;

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
	public void deleteRoles()
	{
		add = new AddRoles(driver);
		delete = new DeleteRoles(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Deleting Roles ******");
			add.getRolesPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
			delete.getDeleteRoleButton(roleName.toUpperCase()).click();
			logger.info("Role "+roleName.toUpperCase()+" Deleted");
			wait.until(ExpectedConditions.visibilityOf(delete.getConfirmation()));
			delete.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
            logger.info("Roles Deleted Successfully......");
		} catch (Exception e) {
			logger.severe("Failed to Delete Roles......:( "+ e.getMessage());
		}
	}
	
	private void assertURL()
	{
		try {
			String expectedURL = baseurl+rolesPageURL;
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
		delete = new DeleteRoles(driver);
		try {
			String expectedSnackbar = deleteRolesSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for Updating Roles is: "+actualSnackbar);
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
