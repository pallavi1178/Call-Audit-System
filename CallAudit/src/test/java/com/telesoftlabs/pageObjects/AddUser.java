package com.telesoftlabs.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser {
	public AddUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/user')]")
	WebElement usersPage;

	public WebElement getUsersPage()
	{
		return usersPage;
	}

	@FindBy(xpath = "//button[contains(@class,'add-btn')]")
	WebElement addUsersButton;

	public WebElement getAddUsersButton()
	{
		return addUsersButton;
	}

	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement username;

	public WebElement getUsername()
	{
		return username;
	}

	@FindBy(xpath = "//input[contains(@name,'displayName')]")
	WebElement displayName;

	public WebElement getDisplayName()
	{
		return displayName;
	}

	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement password;

	public WebElement getPassword()
	{
		return password;
	}

	@FindBy(xpath = "//input[contains(@name,'email')]")
	WebElement email;

	public WebElement getEmail()
	{
		return email;
	}

	@FindBy(xpath = "//span[contains(text(),'Select Role')]")
	WebElement selectRoleDropdown;

	public WebElement getSelectRoleDropdown()
	{
		return selectRoleDropdown;
	}

	@FindBy(xpath = "//span[contains(text(),'Select Department')]")
	WebElement selectDepartmentDropdown;

	public WebElement getSelectDepartmentDropdown()
	{
		return selectDepartmentDropdown;
	}
	
	@FindBy(xpath = "//mat-select[contains(@name,'locationIds')]")
	WebElement locationDropdown;
	
	public WebElement getLocationDropdown()
	{
		return locationDropdown;
	}
	
	@FindBy(xpath = "//strong[contains(text(),'All')]")
	WebElement allLocation;
	
	public WebElement getAllLocation()
	{
		return allLocation;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement saveButton;
	
	public WebElement getsaveButton()
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
	
	@FindBy(xpath = "//mat-option")
	List<WebElement> allRoles;
	
	public List<WebElement> getAllRoles()
	{
		return allRoles;
	}
	
	// Method to locate the element with a dynamic value(role)
    public WebElement OptionRole(WebDriver driver, String role) 
    {
        String xpathExpression = "//span[contains(text(),'" + role + "')]/parent::mat-option";
        WebElement a=driver.findElement(By.xpath(xpathExpression));
		return a;
    }
}

