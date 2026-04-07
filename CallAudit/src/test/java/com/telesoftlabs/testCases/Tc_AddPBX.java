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

public class Tc_AddPBX extends BaseClass 
{	
	public static final Logger logger = Logger.getLogger(Tc_AddPBX.class.getName());
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
	public void addPBX()
	{
		AddPBX add = new AddPBX(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Adding PBX ******");
			try {
				if (add.getSubMenu().isDisplayed()) {
				 logger.info("Displaying sub Menu....");
				}
			} catch (Exception e) {
				logger.info("Sub Menu not found.......");
				add.getSetupPage().click();
			}
			//add.getSetupPage().click();
			wait.until(ExpectedConditions.visibilityOf(add.getPBX_Page()));
			add.getPBX_Page().click();
			wait.until(ExpectedConditions.visibilityOf(add.getAddPBX()));
			addPBX(pbxName);
			add.getYesButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertURL();
			assertSnackbar();
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
			logger.info("PBX Added Successfully.....");
			duplicatePBX();
		} catch (Exception e) {
			logger.severe("Failed to Add PBX.........:( "+e.getMessage());
		}
	}

	public void addPBX(String pbxName)
	{
		AddPBX add = new AddPBX(driver);
		try {
			add.getAddPBX().click();
			add.getPbxName().sendKeys(pbxName);
			logger.info("Added PBX name is: "+pbxName);
			add.getExtensionStartPosition().sendKeys(extensionStartPosition);
			logger.info("Added Extension Start Position: "+extensionStartPosition);
			add.getExtensionWidth().sendKeys(extensionWidth);
			logger.info("Added Extension Width is: "+extensionWidth);
			add.getExtensionFormat().sendKeys(extensionFormat);
			logger.info("Added Extension Format is: "+extensionFormat);
			add.getDateAndTimeStartPosition().sendKeys(dateAndTimeStartPosition);
			logger.info("Added Date & Time start position is: "+dateAndTimeStartPosition);
			add.getDateAndTimeWidth().sendKeys(dateAndTimeWidth);
			logger.info("Added Date & Time Width is: "+dateAndTimeWidth);
			add.getDateAndTimeFormat().sendKeys(dateAndTimeFormat);
			logger.info("Added Date & Time Format is: "+dateAndTimeFormat);
			add.getDurationStartPosition().sendKeys(durationStartPosition);
			logger.info("Added duration Start Position is: "+durationStartPosition);
			add.getDurationWidth().sendKeys(durationWidth);
			logger.info("Added Duration Width is: "+durationWidth);
			add.getDurationFormat().sendKeys(durationFormat);
			logger.info("Added Duration Format is: "+durationFormat);
			add.getTrunkStartPosition().sendKeys(trunkStartPosition);
			logger.info("Added Trunk Start Position is: "+trunkStartPosition);
			add.getTrunkWidth().sendKeys(trunkWidth);
			logger.info("Added Trunk Width is: "+trunkWidth);
			add.getTrunkFormat().sendKeys(trunkFormat);
			logger.info("Added Trunk Format is: "+trunkFormat);
			add.getCallDirectionStartPosition().sendKeys(callDirectionStartPosition);
			logger.info("Added Call Direction Start Position is: "+callDirectionStartPosition);
			add.getCallDirectionWidth().sendKeys(callDirectionwidth);
			logger.info("Added Call Direction Width is: "+callDirectionwidth);
			add.getCallDirectionFormat().sendKeys(callDirectionFormat);
			logger.info("Added Call Direction Format is: "+callDirectionFormat);
			add.getDialedNumberStartPosition().sendKeys(dialedNumberStartPosition);
			logger.info("Added Dialed Number Start Position is: "+dialedNumberStartPosition);
			add.getDialedNumberWidth().sendKeys(dialedNumberWidth);
			logger.info("Added Dialed Number Width is: "+dialedNumberWidth);
			add.getDialedNumberFormat().sendKeys(dialedNumberFormat);
			logger.info("Added Dialed Number Format is: "+dialedNumberFormat);
			add.getPulsesStartPosition().sendKeys(pulsesStartPosition);
			logger.info("Added Pulses Start Position is: "+pulsesStartPosition);
			add.getPulsesWidth().sendKeys(pulsesWidth);
			logger.info("Added Pulses width is: "+pulsesWidth);
			add.getPulsesFormat().sendKeys(pulsesFormat);
			logger.info("Added Pulses Format is: "+pulsesFormat);
			add.getRecordSeperatorStartPosition().sendKeys(recordSeperatorStartPosition);
			logger.info("Added Record Seperator Start position is: "+recordSeperatorStartPosition);
			add.getRecordSeperatorWidth().sendKeys(recordSeperatorWidth);
			logger.info("Added Record Seperator Width is: "+recordSeperatorWidth);
			add.getRecordSeperatorFormat().sendKeys(recordSeperatorFormat);
			logger.info("Added Record Seperator Format is: "+recordSeperatorFormat);
			add.getAccountCodeStartPosition().sendKeys(accountCodeStartPosition);
			logger.info("Added Account Code Start Position is: "+accountCodeStartPosition);
			add.getAccountCodeWidth().sendKeys(accountCodeWidth);
			logger.info("Added Account Code Width is: "+accountCodeWidth);
			add.getAccountCodeFormat().sendKeys(accountCodeFormat);
			logger.info("Added Account Code Format is: "+accountCodeFormat);
			add.getCLIStartPosition().sendKeys(CLIStartPosition);
			logger.info("Added CLI Start Position is: "+CLIStartPosition);
			add.getCLIWidth().sendKeys(CLIWidth);
			logger.info("Added CLI Width is: "+CLIWidth);
			add.getCLIFormat().sendKeys(CLIFormat);
			logger.info("Added CLI Format is: "+CLIFormat);
			add.getSwapExtOrCLIForIncomingCallStartPosition().sendKeys(swapExtOrCLIForIncomingCallStartPosition);
			logger.info("Added Swap Ext/CLI for Incoming Call Start Position is: "+swapExtOrCLIForIncomingCallStartPosition);
			add.getSwapExtOrCLIForIncomingCallWidth().sendKeys(swapExtOrCLIForIncomingCallWidth);
			logger.info("Added Swap Ext/CLI for Incoming Call Width is: "+swapExtOrCLIForIncomingCallWidth);
			add.getSwapExtOrCLIForIncomingCallFormat().sendKeys(swapExtOrCLIForIncomingCallFormat);
			logger.info("Added Swap Ext/CLI for Incoming Call Format is: "+swapExtOrCLIForIncomingCallFormat);
			add.getColumnDelimiterStartPosition().sendKeys(columnDelimiterStartPosition);
			logger.info("Added Column Delimiter Start Position is: "+columnDelimiterStartPosition);
			add.getColumnDelimiterWidth().sendKeys(columnDelimiterWidth);
			logger.info("Added Column Delimiter Width is: "+columnDelimiterWidth);
			add.getColumnDelimiterFormat().sendKeys(columnDelimiterFormat);
			logger.info("Added Column Delimiter Format is: "+columnDelimiterFormat);
			add.getSaveButton().click();
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.severe("Failed tp add the PBX with the name: "+pbxName+" "+e.getMessage());
		}
	}
	
	public void duplicatePBX()
	{
		AddPBX add = new AddPBX(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** started Adding Duplicate PBX *****");
			addPBX(pbxName);
			add.getYesButton().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicatePBX()));
			assertDuplicatePBX();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate PBX testcase failed..... "+e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	private void assertDuplicatePBX()
	{
		AddPBX add = new AddPBX(driver);
		try {
			String expectedHeading = "Duplicate PBX";
			String actualHeading = add.getDuplicatePBX().getText();
			logger.info("Actual Heading obtaining for adding region is: "+actualHeading);
			boolean contains = actualHeading.toLowerCase().contains(expectedHeading.toLowerCase());
			softAssert.assertTrue(contains, "Heading mismatch expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			if (!contains) {
				logger.severe("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
				extentTest.fail("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to Assert Heading Duplicate PBX..... "+e.getMessage());
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
			String expectedSnackbar = addPbxSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding PBX is: "+actualSnackbar);
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