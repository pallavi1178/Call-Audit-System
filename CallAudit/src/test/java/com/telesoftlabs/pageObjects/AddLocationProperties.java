package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class AddLocationProperties extends BaseClass{
	
	public AddLocationProperties(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/setup/locationproperties')]")
	WebElement locationPropertiesPage;
	
	public WebElement getLocationPropertiesPage()
	{
		return locationPropertiesPage;
	}
	
	@FindBy(xpath = "//a[contains(@href,'/cas/setup')]")
	WebElement setupPage;
	
	public WebElement getSetupPage()
	{
		return setupPage;
	}
	
	@FindBy(xpath = "//button[contains(@class,'add')]")
	WebElement addButton;
	
	public WebElement getAddButton()
	{
		return addButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement saveButton;
	
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement confirmation;
	
	public WebElement getConfirmation()
	{
		return confirmation;
	}
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement OkButton;
	
	public WebElement getOkButton()
	{
		return OkButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'no-btn')]")
	WebElement cancelButton;
	
	public WebElement getCancelButton()
	{
		return cancelButton;
	}
	
	@FindBy(xpath = "//div[contains(@class,'mat-mdc-snack-bar-label mdc-snackbar__label')]")
	WebElement snackBar;
	
	public WebElement getSnackBar()
	{
		return snackBar;
	}
	
	@FindBy(xpath = "//div[contains(@class,'sub-menu')]")
	WebElement subMenu;
	
	public WebElement getSubMenu()
	{
		return subMenu;
	}
	
	@FindBy(xpath = "//input[contains(@name,'locationName')]")
	WebElement locationName;
	
	public WebElement getLocationName()
	{
		return locationName;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'pbxId')]")
	WebElement pbxDropdown;
	
	public WebElement getPbxDropdown()
	{
		return pbxDropdown;
	}
	
	public WebElement getPbxFromDropdown()
	{
		WebElement a = driver.findElement(By.xpath("//span[contains(text(),'"+pbxName+"')]/parent::mat-option"));
		return a;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'regionId')]")
	WebElement regionDropdown;
	
	public WebElement getRegionDropdown()
	{
		return regionDropdown;
	}
	
	public WebElement getRegionFromDropdown()
	{
		WebElement a = driver.findElement(By.xpath("//span[contains(text(),'"+countryName+"')]/parent::mat-option"));
		return a;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Billing Class')]/parent::label/following-sibling::input")
	WebElement billingClassDropdown;
	
	public WebElement getBillingClassDropdown()
	{
		return billingClassDropdown;
	}
	
	public WebElement getBillingClassFromDropdown()
	{
		WebElement a = driver.findElement(By.xpath("//label[contains(text(),'"+billingClass+"')]"));
		return a;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Call Rate')]/parent::label/following-sibling::input")
	WebElement callRateDropdown;
	
	public WebElement getCallRateDropdown()
	{
		return callRateDropdown;
	}
	
	@FindBy(xpath = "//label[contains(text(),'Select All')]")
	WebElement selectAllCallRate;
	
	public WebElement getSelectAllCallRate()
	{
		return selectAllCallRate;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Billing Exception')]/parent::label/following-sibling::input")
	WebElement billingExceptionDropdown;
	
	public WebElement getBillingExceptionDropdown()
	{
		return billingExceptionDropdown;
	}
	
	public WebElement getBillingExceptionFromDropdown()
	{
		WebElement a = driver.findElement(By.xpath("//label[contains(text(),'"+tollFreeNumber+"')]"));
		return a;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'communicationMode')]")
	WebElement communicationModeDropdown;
	
	public WebElement getCommunicationModeDropdown()
	{
		return communicationModeDropdown;		
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'FILE')]")
	WebElement fileCommunication;
	
	public WebElement getFileCommunication()
	{
		return fileCommunication;
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'TCP')]")
	WebElement tcpCommunicationMode;
	
	public WebElement getTcpCommunicationMode()
	{
		return tcpCommunicationMode;
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'SERIAL')]")
	WebElement serialCommunicationMode;
	
	public WebElement getSerialCommunicationMode()
	{
		return serialCommunicationMode;
	}
	
	@FindBy(xpath = "//input[contains(@name,'cdrFilePath')]")
	WebElement cdrFilePath;
	
	public WebElement getCdrFilePath()
	{
		return cdrFilePath;
	}
	
	@FindBy(xpath = "//input[contains(@name,'cdrFileExtension')]")
	WebElement cdrFileExtension;
	
	public WebElement getCdrFileExtension()
	{
		return cdrFileExtension;
	}
	
	@FindBy(xpath = "//input[contains(@name,'dumpFolderPath')]")
	WebElement cdrDumpPath;
	
	public WebElement getCdrDumpPath()
	{
		return cdrDumpPath;
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Duplicate Location')]")
	WebElement duplicateLocationProperties;
	
	public WebElement getDuplicateLocationProperties()
	{
		return duplicateLocationProperties;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'connectMode')]")
	WebElement connectionModeDropdown;
	
	public WebElement getConnectionModeDropdown()
	{
		return connectionModeDropdown;
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'SERVER')]")
	WebElement serverConnectionMode;
	
	public WebElement getServerConnectionMode()
	{
		return serverConnectionMode;
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'CLIENT')]")
	WebElement clientCommunicationMode;
	
	public WebElement getClientCommunicationMode()
	{
		return clientCommunicationMode;
	}
	
	@FindBy(xpath = "//input[contains(@name,'ipAddress')]")
	WebElement ipAddress;
	
	public WebElement getIpAddress()
	{
		return ipAddress;
	}
	
	@FindBy(xpath = "//input[contains(@name,'ipPort')]")
	WebElement ipPort;
	
	public WebElement getIpPort()
	{
		return ipPort;
	}
	
	@FindBy(xpath = "//input[contains(@name,'retryInterval')]")
	WebElement retryInterval;
	
	public WebElement getRetryInterval()
	{
		return retryInterval;
	}
	
	@FindBy(xpath = "//input[contains(@name,'comPort')]")
	WebElement comPort;
	
	public WebElement getComPort()
	{
		return comPort;
	}
	
	@FindBy(xpath = "//input[contains(@name,'baudRate')]")
	WebElement baudRate;
	
	public WebElement getBaudRate()
	{
		return baudRate;
	}
	
	@FindBy(xpath = "//input[contains(@name,'parity')]")
	WebElement parity;
	
	public WebElement getParity()
	{
		return parity;
	}
	
	@FindBy(xpath = "//input[contains(@name,'dataBit')]")
	WebElement dataBit;
	
	public WebElement getDataBit()
	{
		return dataBit;
	}
	
	@FindBy(xpath = "//input[contains(@name,'stopBit')]")
	WebElement stopBit;
	
	public WebElement getStopBit()
	{
		return stopBit;
	}
	
}
