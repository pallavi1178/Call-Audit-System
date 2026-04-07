package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class DeleteUser extends BaseClass{
    public DeleteUser(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public WebElement getDeleteUserButton(String username)
    {
    	WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+username+"')]/following-sibling::td/button/mat-icon[contains(text(),'delete')]"));
    	return a;
    }
    
    @FindBy(xpath = "//button[contains(@class,'yes-btn')]")
    WebElement confirmation;
    
    public WebElement getConfirmation()
    {
    	return confirmation;
    }
}
