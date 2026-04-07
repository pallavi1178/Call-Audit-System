package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddPBX;
import com.telesoftlabs.pageObjects.DeletePBX;
import com.telesoftlabs.pageObjects.UpdatePBX;

public class Tc_UpdatePBX extends BaseClass{
	public static final Logger logger = Logger.getLogger(Tc_UpdatePBX.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
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
	public void updatePBX()
	{
		AddPBX add = new AddPBX(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		UpdatePBX update = new UpdatePBX(driver);
		DeletePBX delete = new DeletePBX(driver);
		try {
			logger.info("****** Started Updating PBX ******");
			try {
				if (add.getSubMenu().isDisplayed()) {
				 logger.info("Displaying sub Menu.....");
				}
			} catch (Exception e) {
				logger.info("Sub Menu not found.......");
				add.getSetupPage().click();
			}
			wait.until(ExpectedConditions.visibilityOf(add.getPBX_Page()));
			add.getPBX_Page().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddPBX()));
			update.getUpdatePBX(pbxName).click();
			wait.until(ExpectedConditions.visibilityOf(update.getUpdateButton()));
			update.getUpdateButton().click();
			wait.until(ExpectedConditions.visibilityOf(delete.getConfirmation()));
			delete.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertURL();
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			logger.info("PBX Updated Successfully");
		} catch (Exception e) {
			logger.severe("Failed to Update PBX.........:( "+e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}
	
	private void assertURL()
	{
		try {
			String expectedURL = baseurl+pbxMasterPageURL;
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
		AddPBX add = new AddPBX(driver);
		try {
			String expectedSnackbar = updatePbxSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for Updating PBX is: "+actualSnackbar);
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
