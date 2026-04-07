package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class UpdateRoles extends BaseClass{
	
	public UpdateRoles(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateRoleButton(String roleName)
	{
		WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+roleName+"')]/following-sibling::td/button/span/following-sibling::mat-icon[contains(text(),'edit')]"));
		return a;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement updateButton;
	
	public WebElement getUpdateButton()
	{
		return updateButton;
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
}
