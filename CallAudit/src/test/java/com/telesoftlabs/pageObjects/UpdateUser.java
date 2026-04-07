package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class UpdateUser extends BaseClass{

	public UpdateUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement updateButton;
	
	public WebElement getUpdateButton()
	{
		return updateButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement confirmation;
	
	public WebElement getConfirmation()
	{
		return confirmation;
	}
	
	public WebElement getUpdateButton(String username)
	{
		WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+username+"')]/following-sibling::td/button/mat-icon[contains(text(),'edit')]"));
		return a;
	}
}
