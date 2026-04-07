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

public class Tc_AddRoles extends BaseClass
{
	public static final Logger logger = Logger.getLogger(Tc_AddRoles.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	SoftAssert softAssert = new SoftAssert();
    AddRoles add;
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
	public void addRoles()
	{
		add = new AddRoles(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Starting Adding Roles ******");
			add.getRolesPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddButton()));
			addRoles(roleName.toUpperCase());
			wait.until(ExpectedConditions.visibilityOf(add.getConfirmation()));
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertURL();
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			logger.info("Role Added Successfully.....");
			duplicateRoles();
		} catch (Exception e) {
			logger.severe("Failed to add Roles...... "+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	public void addRoles(String roleName)
	{
		add = new AddRoles(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getAddButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getRoleName()));
			add.getRoleName().sendKeys(roleName);
			add.getDashboardPagePermission().click();
			logger.info("permission "+add.getDashboardPagePermission().getText()+ " given Successfully...");
			add.getSearchPagePermission().click();
			logger.info("permission "+add.getSearchPagePermission().getText()+ " given Successfully...");
			add.getReportsPagePermission().click();
			logger.info("permission "+add.getReportsPagePermission().getText()+ " given Successfully...");
			add.getExtensionPagePermission().click();
			logger.info("permission "+add.getExtensionPagePermission().getText()+ " given Successfully...");
			add.getLatestCDRPagePermission().click();
			logger.info("permission "+add.getLatestCDRPagePermission().getText()+ " given Successfully...");
			add.getRegionPagePermission().click();
			logger.info("permission "+add.getRegionPagePermission().getText()+ " given Successfully...");
			add.getCallRatesPagePermission().click();
			logger.info("permission "+add.getCallRatesPagePermission().getText()+ " given Successfully...");
			add.getBillingClassPagePermission().click();
			logger.info("permission "+add.getBillingClassPagePermission().getText()+ " given Successfully...");
			add.getBillingExceptionPagePermission().click();
			logger.info("permission "+add.getBillingExceptionPagePermission().getText()+ " given Successfully...");
			add.getPBXPagePermission().click();
			logger.info("permission "+add.getPBXPagePermission().getText()+ " given Successfully...");
			add.getLocationPropertiesPagePermission().click();
			logger.info("permission "+add.getLocationPropertiesPagePermission().getText()+ " given Successfully...");
			add.getSaveButton().click();
		} catch (Exception e) {
			logger.severe("Failes to add Role with the name "+roleName+" "+e.getMessage());
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
		 add = new AddRoles(driver);
		try {
			String expectedSnackbar = addRolesSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding Roles is: "+actualSnackbar);
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
	
	private void duplicateRoles()
	{
		add = new AddRoles(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Starting Adding Duplicate Roles ******");
			addRoles(roleName.toUpperCase());
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicateRole()));
			assertDuplicateRole();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate Roles testcase failed..... "+e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	private void assertDuplicateRole()
	{
		add = new AddRoles(driver);
		try {
			String expectedHeading = "Duplicate Role";
			String actualHeading = add.getDuplicateRole().getText();
			logger.info("Actual Heading obtaining for adding region is: "+actualHeading);
			boolean contains = actualHeading.toLowerCase().contains(expectedHeading.toLowerCase());
			softAssert.assertTrue(contains, "Heading mismatch expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			if (!contains) {
				logger.severe("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
				extentTest.fail("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to Assert Heading Duplicate Role..... "+e.getMessage());
		}
	}
}
