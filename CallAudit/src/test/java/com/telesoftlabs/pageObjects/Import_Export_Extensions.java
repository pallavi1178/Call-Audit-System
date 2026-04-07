package com.telesoftlabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Import_Export_Extensions {

	public Import_Export_Extensions(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//mat-icon[contains(@class,'import')]")
	WebElement importButton;
	
	public WebElement getImportButton()
	{
		return importButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement confirmation;
	
	public WebElement getConfirmation()
	{
		return confirmation;
	}
	
	@FindBy(xpath = "//div[contains(@class,'paginator-range-label')]")
	WebElement totalExtensions;
	
	public WebElement getTotalExtensions()
	{
		return totalExtensions;
	}
	
	@FindBy(xpath = "//mat-icon[contains(@class,'export')]")
	WebElement exportButton;
	
	public WebElement getExportButton()
	{
		return exportButton;
	}
	
	@FindBy(xpath = "//div[contains(@class,'no-records')]")
	WebElement recordsNotAvailableMessage;
	
	public WebElement getRecordsNotAvailableMessage()
	{
		return recordsNotAvailableMessage;
	}
}
