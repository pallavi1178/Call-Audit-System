package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class UpdateLocationProperties extends BaseClass{
	public UpdateLocationProperties(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	public WebElement getUpdateButton(String locationName)
	{
	 WebElement a =driver.findElement(By.xpath("//mat-cell[contains(text(),'"+locationName+"')]/following-sibling::mat-cell/button/span/following-sibling::mat-icon[contains(text(),'edit')]"));
	 return a;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]/span/following-sibling::span[contains(text(),'Update')]")
	WebElement updateButton;
	
	public WebElement getUpdateButton()
	{
		return updateButton;
	}
	
	@FindBy(xpath = "(//button[contains(@class,'no-btn')]/following-sibling::button[contains(@class,'yes-btn')]/span/following-sibling::span[contains(text(),'Yes')])[1]")
	WebElement confirmation;
	
	public WebElement getConfirmation()
	{
		return confirmation;
	}
}
