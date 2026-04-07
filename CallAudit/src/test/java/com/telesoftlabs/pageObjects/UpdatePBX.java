package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class UpdatePBX extends BaseClass{
	
	public UpdatePBX(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdatePBX(String pbxName)
	{
		WebElement a = driver.findElement(By.xpath("//mat-cell[contains(text(),'"+pbxName+"')]/following-sibling::mat-cell/button/span/following-sibling::mat-icon[contains(text(),'edit')]"));
		return a;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement updateButton;
	
	public WebElement getUpdateButton()
	{
		return updateButton;
	}
}
