package com.telesoftlabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRoles {
   public AddRoles(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath = "//a[contains(@href,'/roles')]")
   WebElement rolesPage;
   
   public WebElement getRolesPage()
   {
	   return rolesPage;
   }
   
   @FindBy(xpath = "//mat-icon[contains(text(),'add')]")
   WebElement addButton;
   
   public WebElement getAddButton()
   {
	   return addButton;
   }
   
   @FindBy(xpath = "//input[contains(@formcontrolname,'roleName')]")
   WebElement roleName;
   
   public WebElement getRoleName()
   {
	   return roleName;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Dashboard')]")
   WebElement dashboardPagePermission;
   
   public WebElement getDashboardPagePermission()
   {
	   return dashboardPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Search')]")
   WebElement searchPagePermission;
   
   public WebElement getSearchPagePermission()
   {
	   return searchPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Reports')]")
   WebElement reportsPagePermission;
   
   public WebElement getReportsPagePermission()
   {
	   return reportsPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Extension')]")
   WebElement extensionPagePermission;
   
   public WebElement getExtensionPagePermission()
   {
	   return extensionPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Latest CDR')]")
   WebElement latestCDRPagePermission;
   
   public WebElement getLatestCDRPagePermission()
   {
	   return latestCDRPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Region')]")
   WebElement regionPagePermission;
   
   public WebElement getRegionPagePermission()
   {
	   return regionPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Call Rates')]")
   WebElement callRatesPagePermission;
   
   public WebElement getCallRatesPagePermission()
   {
	 return callRatesPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Billing Class')]")
   WebElement billingClassPagePermission;
   
   public WebElement getBillingClassPagePermission()
   {
	   return billingClassPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Billing Exception')]")
   WebElement billingExceptionPagePermission;
   
   public WebElement getBillingExceptionPagePermission()
   {
	   return billingExceptionPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'PBX')]")
   WebElement PBXPagePermission;
   
   public WebElement getPBXPagePermission()
   {
	   return PBXPagePermission;
   }
   
   @FindBy(xpath = "//label[contains(text(),'Location Properties')]")
   WebElement locationPropertiesPagePermission;
   
   public WebElement getLocationPropertiesPagePermission()
   {
	   return locationPropertiesPagePermission;
   }
   
   @FindBy(xpath = "//button[contains(@class,'yes-btn')]")
   WebElement saveButton;
   
   public WebElement getSaveButton()
   {
	   return saveButton;
   }
   
   @FindBy(xpath = "//span[contains(text(),' Yes ')]")
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
	
	@FindBy(xpath = "//button[contains(@class,'no-btn')]")
	WebElement cancelButton;
	
	public WebElement getCancelButton()
	{
		return cancelButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement OkButton;
	
	public WebElement getOkButton()
	{
		return OkButton;
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Duplicate')]")
	WebElement duplicateRole;
	
	public WebElement getDuplicateRole()
	{
		return duplicateRole;
	}
}
