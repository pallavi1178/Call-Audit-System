package com.telesoftlabs.testCases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddExtension;
import com.telesoftlabs.pageObjects.Import_Export_Extensions;
import com.telesoftlabs.pageObjects.Update_Delete_Extension;

public class Tc_ImportExtension extends BaseClass {
	public static final Logger logger = Logger.getLogger(Tc_ImportExtension.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	AddExtension add;
	WebDriverWait wait;
	Update_Delete_Extension update;
	Import_Export_Extensions importExt;
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
	public void importExtensions()
	{
		add = new AddExtension(driver);
		update = new Update_Delete_Extension(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		importExt = new Import_Export_Extensions(driver);
		try {
			logger.info("****** Started Importing the Extensions ******");
			add.getExtensionPage().click();
			wait.until(ExpectedConditions.visibilityOf(importExt.getImportButton()));
			int beforeCount = getTotalExtensionsCount();
			logger.info("Count of Extensions before Import is: "+ beforeCount);
			importExt.getImportButton().click();
			String filePath = new File("").getAbsolutePath();
			logger.info("Application Path is: "+ filePath);

			String directoryPath = filePath+"\\ImportFiles\\Extension";
			logger.info("Directory Path is: "+ directoryPath);
			File directory = new File(directoryPath);
			if (directory.exists() && directory.isDirectory()) 
			{
				File[] filesInDirectory = directory.listFiles();
				if (filesInDirectory != null && filesInDirectory.length > 0) 
				{
					Random random = new Random();
					int randomIndex = random.nextInt(filesInDirectory.length);
					File selectedFile = filesInDirectory[randomIndex];
					logger.info("Selected Extension file is: "+selectedFile);

					StringSelection stringSelection = new StringSelection(selectedFile.getAbsolutePath());
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
					Thread.sleep(2000);
					RobotHelper();
					wait.until(ExpectedConditions.visibilityOf(importExt.getConfirmation()));
					importExt.getConfirmation().click();
					wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
					int successCount = getSuccessCount(add.getSnackBar().getText());
					logger.info("Count of Extensions Imported is: "+ successCount);
					WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
					dismiss.click();
					logger.info("Clicked on Close button");
					int afterCount = getTotalExtensionsCount();
					logger.info("Count of Extensions After Import is: "+ afterCount);
					logger.info("Extensions Imported Successfully....");
					softAssert.assertEquals(afterCount, beforeCount + successCount,"Extension count mismatch after import");
					assertURL();
				}
			}
			else {
				logger.warning("Unable to import Extensions");
			}
		} catch (Exception e) {
			logger.severe("Failed to Import Extensions.......:( "+e.getMessage());
			softAssert.fail("Exception occurred: " + e.getMessage());
		}finally {
			softAssert.assertAll();
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

	private void RobotHelper()
	{
		try {
			Robot robot = new Robot();
			// Paste file path from clipboard
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(500);
			// Press Enter to select the file
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			logger.severe("Exception is: "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	/*
	 Regex Explanation (1-10 of 10)
	Part	Matches
	.*		1-10
	of		of
	\\s*	space
	(\\d+)	25
	.*		(nothing)
	$1		captured group 1
	*/
	public int getTotalExtensionsCount() {
	    String text = importExt.getTotalExtensions().getText();
	    String total = text.replaceAll(".*of\\s*(\\d+).*", "$1");
	    return Integer.parseInt(total);
	}
	
	/*
	 Regex Explanation (Import completed. Success: 0, Duplicate Extension: 1)
	Part	Matches
	\\s*	space
	(\\d+)	0
	*/
	public int getSuccessCount(String message) {
	    Pattern pattern = Pattern.compile("Success:\\s*(\\d+)");
	    Matcher matcher = pattern.matcher(message);

	    if (matcher.find()) {
	        return Integer.parseInt(matcher.group(1));
	    } else {
	        throw new RuntimeException("Success count not found in message: " + message);
	    }
	}
}
