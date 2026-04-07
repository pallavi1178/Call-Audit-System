package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class DeletePBX extends BaseClass{
	public DeletePBX(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDeletePBX(String pbxName)
	{
		WebElement a = driver.findElement(By.xpath("//mat-cell[contains(text(),'"+pbxName+"')]/following-sibling::mat-cell/button/span/following-sibling::mat-icon[contains(text(),'delete')]"));
		return a;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement confirmation;
	
	public WebElement getConfirmation()
	{
		return confirmation;
	}
}
