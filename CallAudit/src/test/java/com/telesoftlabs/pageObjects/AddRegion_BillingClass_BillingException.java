package com.telesoftlabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRegion_BillingClass_BillingException {
	
	public AddRegion_BillingClass_BillingException(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/setup')]")
	WebElement setupPage;
	
	public WebElement getSetupPage()
	{
		return setupPage;
	}
	
	@FindBy(xpath = "//button[contains(@class,'add-icon')]")
	WebElement addButton;
	
	public WebElement getAddButton()
	{
		return addButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'save')]")
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
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////Region Page 
	
	@FindBy(xpath = "//input[contains(@name,'countryName')]")
	WebElement countryName;
	
	public WebElement getCountryName()
	{
		return countryName;
	}
	
	@FindBy(xpath = "//input[contains(@name,'countryCode')]")
	WebElement countryCode;
	
	public WebElement getCountryCode()
	{
		return countryCode;
	}
	
	@FindBy(xpath = "//input[contains(@name,'idd')]")
	WebElement IDD;
	
	public WebElement getIDD()
	{
		return IDD;
	}
	
	@FindBy(xpath = "//input[contains(@name,'ndd')]")
	WebElement NDD;
	
	public WebElement getNDD()
	{
		return NDD;
	}
	
	@FindBy(xpath = "//input[contains(@name,'areaCode')]")
	WebElement areaCode;
	
	public WebElement getAreaCode()
	{
		return areaCode;
	}
	
	@FindBy(xpath = "//input[contains(@name,'fixedLineStartDigits')]")
	WebElement fixedLineStartDigits;
	
	public WebElement getFixedLineStartDigits()
	{
		return fixedLineStartDigits;
	}
	
	@FindBy(xpath = "//input[contains(@name,'mobileStartDigit')]")
    WebElement mobileStartDigits;
	
	public WebElement getMobileStartDigits()
	{
		return mobileStartDigits;
	}
	
	@FindBy(xpath = "//input[contains(@name,'serviceProviderName')]")
	WebElement serviceProviderName;
	
	public WebElement getServiceProviderName()
	{
		return serviceProviderName;
	}
	
	@FindBy(xpath = "//input[contains(@name,'networkStartDigit')]")
	WebElement networkStartDigits;
	
	public WebElement getNetworkStartDigits()
	{
		return networkStartDigits;
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Duplicate Entry')]")
	WebElement duplicateRegion;
	
	public WebElement getDuplicateRegion()
	{
		return duplicateRegion;
	}
	
    //////////////////////////////////////////////////////////////////////////////////////////////////////Billing Class
    
	@FindBy(xpath = "//span[contains(text(),'Billing Class')]")
	WebElement billingClassPage;
	
	public WebElement getBillingClassPage()
	{
		return billingClassPage;
	}
	
	@FindBy(xpath = "//input[contains(@name,'billingClassName')]")
	WebElement billingClassName;
	
	public WebElement getBillingClassName()
	{
		return billingClassName;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'callType')]")
	WebElement callTypeDropdown;
	
	public WebElement getCallTypeDropdown()
	{
		return callTypeDropdown;
	}
	
	@FindBy(xpath = "//mat-option[contains(@value,'Local')]")
	WebElement callTypeLocal;
	
	public WebElement getCallTypeLocal()
	{
		return callTypeLocal;
	}
	
	@FindBy(xpath = "//input[contains(@name,'gracePeriod')]")
	WebElement gracePeriod;
	
	public WebElement getGracePeriod()
	{
		return gracePeriod;
	}
	
	@FindBy(xpath = "//input[contains(@name,'pulseInSecond')]")
	WebElement pulseInSeconds;
	
	public WebElement getPulseInSeconds()
	{
		return pulseInSeconds;
	}
	
	@FindBy(xpath = "//input[contains(@name,'chargePerPulse')]")
	WebElement chargePerPulse;
	
	public WebElement getChargePerPulse()
	{
		return chargePerPulse;
	}
	
	@FindBy(xpath = "//input[contains(@name,'markupPercentage')]")
	WebElement markupPercentage;
	
	public WebElement getMarkupPercentage()
	{
		return markupPercentage;
	}
	
	@FindBy(xpath = "//input[contains(@name,'surcharge')]")
	WebElement surCharge;
	
	public WebElement getSurCharge()
	{
		return surCharge;
	}
	
	 //////////////////////////////////////////////////////////////////////////////////////////////////////Billing Exception
	
	@FindBy(xpath = "//span[contains(text(),'Billing Exception')]")
	WebElement billingExceptionPage;
	
	public WebElement getBillingExceptionPage()
	{
		return billingExceptionPage;
	}
	
	@FindBy(xpath = "//input[contains(@id,'tollFreeNumber')]")
	WebElement tollFreeNumber;
	
	public WebElement getTollFreeNumber()
	{
		return tollFreeNumber;
	}
	
	@FindBy(xpath = "//input[contains(@id,'description')]")
	WebElement description;
	
	public WebElement getdesccription()
	{
		return description;
	}
}
