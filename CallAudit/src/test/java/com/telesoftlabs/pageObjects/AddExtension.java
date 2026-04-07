package com.telesoftlabs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddExtension {

	public AddExtension(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'/extension')]")
	WebElement extensionPage;
	
	public WebElement getExtensionPage()
	{
		return extensionPage;
	}
	
	@FindBy(xpath = "//mat-icon[contains(text(),'add')]")
	WebElement addButton;
	
	public WebElement getAddButton()
	{
		return addButton;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Location')]/parent::label/following-sibling::mat-select")
	WebElement locationDropdown;
	
	public WebElement getLocationDropdown()
	{
		return locationDropdown;
	}
	
	@FindBy(xpath = "//mat-option")
	List<WebElement> optionsLocation;
	
	public List<WebElement> getOptionsLocation()
	{
		return optionsLocation;
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Extension Number')]")
	WebElement fromExtension;
	
	public WebElement getFromExtension()
	{
		return fromExtension;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'To Extension')]/parent::label/following-sibling::input")
	WebElement toExtension;
	
	public WebElement getToExtension()
	{
		return toExtension;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Billing Class')]/parent::label/following-sibling::mat-select")
    WebElement billingClassDropdown;
	
	public WebElement getBillingClassDropdown()
	{
		return billingClassDropdown;
	}
	
	@FindBy(xpath = "//mat-option")
	List<WebElement> optionsBillingClass;
	
	public List<WebElement> getOptionsBillingClass()
	{
		return optionsBillingClass;
	}
	
	@FindBy(xpath = "//input[contains(@name,'extensionUserName')]")
	WebElement extensionUsername;
	
	public WebElement getExtensionUsername()
	{
		return extensionUsername;
	}
	
	@FindBy(xpath = "//input[contains(@name,'trunkName')]")
	WebElement trunkName;
	
	public WebElement getTrunkName()
	{
		return trunkName;
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
	
	@FindBy(xpath = "//div[contains(@class,'mat-mdc-snack-bar-label mdc-snackbar__label')]")
	WebElement snackBar;
	
	public WebElement getSnackBar()
	{
		return snackBar;
	}
}
