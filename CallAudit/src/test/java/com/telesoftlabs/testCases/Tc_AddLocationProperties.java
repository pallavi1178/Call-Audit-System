package com.telesoftlabs.testCases;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddLocationProperties;

public class Tc_AddLocationProperties extends BaseClass {

	public static final Logger logger = Logger.getLogger(Tc_AddLocationProperties.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	AddLocationProperties add;
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

	@Test(priority = 2)
	public void addLocationProperties()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("****** Started Adding Location Properties ******");
			try {
				if (add.getSubMenu().isDisplayed()) {
					logger.info("Sub Menu Displayed.........");
				}
			} catch (Exception e) {
				logger.info("Sub Menu Not Displayed, clicking on the Setup button.........");
				add.getSetupPage().click();
			}
			wait.until(ExpectedConditions.visibilityOf(add.getLocationPropertiesPage()));
			add.getLocationPropertiesPage().click();
			addLocationProperties(locationName);	       
			add.getConfirmation().click();
			logger.info("Location Property Saved Successfully....");
			wait.until(ExpectedConditions.visibilityOf(add.getSnackBar()));
			assertSnackbar();
			assertURL();
			duplicateLocationProperty();
		} catch (Exception e) {
			logger.severe("Failed to add Location Properties.........:( "+e.getMessage());
		}finally {
			softAssert.assertAll();
		}
	}

	private void addLocationProperties(String locationName)
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getAddButton().click();
			add.getLocationName().sendKeys(locationName);
			add.getPbxDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getPbxFromDropdown()));
			String selectedPBX = add.getPbxFromDropdown().getText();
			add.getPbxFromDropdown().click();			
			logger.info("Selected PBX from the dropdown is: "+selectedPBX);
			wait.until(ExpectedConditions.invisibilityOf(add.getPbxFromDropdown()));		
			wait.until(ExpectedConditions.elementToBeClickable(add.getRegionDropdown()));
			add.getRegionDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getRegionFromDropdown()));
			String selectedRegion = add.getRegionFromDropdown().getText();
			add.getRegionFromDropdown().click();			
			logger.info("Selected Region from the dropdown is: "+selectedRegion);
			wait.until(ExpectedConditions.invisibilityOf(add.getRegionFromDropdown()));		
			wait.until(ExpectedConditions.elementToBeClickable(add.getBillingClassDropdown()));
			add.getBillingClassDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getBillingClassFromDropdown()));
			String selectedBillingClass = add.getBillingClassFromDropdown().getText();
			add.getBillingClassFromDropdown().click();			
			logger.info("Selected Billing class from the dropdown is: "+selectedBillingClass);			
			wait.until(ExpectedConditions.elementToBeClickable(add.getCallRateDropdown()));
			add.getCallRateDropdown().click();
			wait.until(ExpectedConditions.visibilityOf(add.getSelectAllCallRate()));
			String selecetedCallRate = add.getSelectAllCallRate().getText();
			add.getSelectAllCallRate().click();			
			logger.info("Selected Call Rate is: "+selecetedCallRate);
			wait.until(ExpectedConditions.elementToBeClickable(add.getCommunicationModeDropdown()));
			add.getCommunicationModeDropdown().click();
			selectCommunicationMode(communicationMode);	
			add.getSaveButton().click();
		} catch (Exception e) {
			logger.severe("Failed to add Location Property. "+locationName+ " "+ e.getMessage());
		}
	}

	private void assertSnackbar()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			String expectedSnackbar = addLocationPropertiesSnackbar;
			String actualSnackbar = add.getSnackBar().getText();
			logger.info("Actual snackbar obtaining for adding Location Properties is: "+actualSnackbar);
			boolean contains = actualSnackbar.toLowerCase().contains(expectedSnackbar.toLowerCase());
			softAssert.assertTrue(contains, "Snackbar mismatch expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			if (!contains) {
				logger.severe("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
				extentTest.fail("Mismatch in the Snackbar expected ["+expectedSnackbar+"] but found ["+actualSnackbar+"]");
			}
			WebElement dismiss = driver.findElement(By.xpath("//span[contains(text(),' Close ')]"));
			dismiss.click();
			logger.info("Clicked on Close button");
		} catch (Exception e) {
			logger.severe("Failed to assert Snackbar..... "+ e.getMessage());
		}
	}

	private void assertURL()
	{
		try {
			String expectedURL = baseurl+locationPropertiesPageURL;
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

	//@Test(priority = 3, dependsOnMethods = "addBillingException")
	private void duplicateLocationProperty()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			logger.info("***** started Adding Duplicate Location Properties *****");
			addLocationProperties(locationName);
			add.getConfirmation().click();
			wait.until(ExpectedConditions.visibilityOf(add.getDuplicateLocationProperties()));
			assertDuplicateLocationProperty();
			add.getOkButton().click();
			add.getCancelButton().click();
		} catch (Exception e) {
			logger.severe("Duplicate LocationProperties Testcase Failed...........:(");
		}finally {
			softAssert.assertAll();
		}
	}

	private void assertDuplicateLocationProperty()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			String expectedHeading = "Duplicate Location";
			String actualHeading = add.getDuplicateLocationProperties().getText();
			logger.info("Actual Heading obtaining for adding region is: "+actualHeading);
			boolean contains = actualHeading.toLowerCase().contains(expectedHeading.toLowerCase());
			softAssert.assertTrue(contains, "Heading mismatch expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			if (!contains) {
				logger.severe("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
				extentTest.fail("Mismatch in the Heading expected ["+expectedHeading+"] but found ["+actualHeading+"]");
			}
		} catch (Exception e) {
			logger.severe("Failed to Assert Heading Duplicate Location Properties..... "+e.getMessage());
		}
	}

	private void selectCommunicationMode(String communicationMode)
	{
		if (communicationMode.equalsIgnoreCase("File")) {
			logger.info("Selected Communication Mode is: File.");
			fileCommunicationMode();
		}
		else if (communicationMode.equalsIgnoreCase("TCP/IP")) {
			logger.info("Selected Communication Mode is: TCP/IP.");
			tcpCommunicationMode();
		}
		else if (communicationMode.equalsIgnoreCase("Serial")) {
			logger.info("Selected Communication Mode is: Serial.");
			serialCommunicationMode();
		}
		else {
			logger.warning("Invalid Communication Mode Selected......");
		}
	}

	private void fileCommunicationMode()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getFileCommunication().click();
			add.getCdrFilePath().sendKeys(cdrFilePath);
			logger.info("Added CDR File Path is: "+cdrFilePath);
			add.getCdrFileExtension().sendKeys(cdrFileExtension);
			logger.info("Added CDR File Extension is: "+cdrFileExtension);
			add.getCdrDumpPath().sendKeys(cdrDumpFilePath);
			logger.info("Added CDR Dump File Path is: "+cdrDumpFilePath);
		} catch (Exception e) {
			logger.severe("Failed while addinng the File Communication Mode. "+ e.getMessage());
		}
	}

	private void tcpCommunicationMode()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getTcpCommunicationMode().click();
			Thread.sleep(500);
			add.getConnectionModeDropdown().click();
			Thread.sleep(500);
			if (connectionMode.equalsIgnoreCase("server")) {
				logger.info("Selected Connection Mode is: SERVER");
				add.getServerConnectionMode().click();
				add.getIpPort().sendKeys(ipPort);
				logger.info("Added Ip Port is: "+ipPort);
				add.getRetryInterval().sendKeys(retryInterval.trim());
				logger.info("Added Retry Interval is: "+retryInterval);
			}
			else if (connectionMode.equalsIgnoreCase("client")) {
				logger.info("Selected Connection Mode is: CLIENT");
				add.getClientCommunicationMode().click();
				add.getIpAddress().sendKeys(ipAddress);
				logger.info("Added Ip Address is: "+ipAddress);
				add.getIpPort().sendKeys(ipPort);
				logger.info("Added Ip Port is: "+ipPort);
				add.getRetryInterval().sendKeys(retryInterval.trim());
				logger.info("Added Retry Interval is: "+retryInterval);
			}
			else {
				logger.warning("Connection Mode not selected...:(");
			}

		} catch (Exception e) {
			logger.severe("Failed while addinng the TCP/IP Communication Mode. "+ e.getMessage());
		}
	}

	private void serialCommunicationMode()
	{
		add = new AddLocationProperties(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			add.getSerialCommunicationMode().click();
			add.getComPort().sendKeys(comPort);
			logger.info("Added Com Port is: "+comPort);
			add.getBaudRate().sendKeys(baudRate);
			logger.info("Added Baud Rate is: "+baudRate);
			add.getParity().sendKeys(parity);
			logger.info("Added parity is: "+parity);
			add.getDataBit().sendKeys(dataBit);
			logger.info("Added Data Bit is: "+dataBit);
			add.getStopBit().sendKeys(stopBit);
			logger.info("Added Stop Bit is: "+stopBit);
		} catch (Exception e) {
			logger.severe("Failed while addinng the Serial Communication Mode. "+ e.getMessage());
		}
	}
}
