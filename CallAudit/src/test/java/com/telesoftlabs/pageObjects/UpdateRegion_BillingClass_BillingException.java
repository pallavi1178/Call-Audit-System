package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class UpdateRegion_BillingClass_BillingException extends BaseClass
{
    public UpdateRegion_BillingClass_BillingException(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public WebElement getUpdateRegionButton(String countryName)
    {
   	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+countryName+"')]/following-sibling::td/button/mat-icon[contains(text(),'edit')]"));
   	 return a;
    }
    
    public WebElement getUpdateBillingClassButton(String billingClass)
    {
   	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+billingClass+"')]/following-sibling::td/button/mat-icon[contains(text(),'edit')]"));
   	 return a;
    }
    
    public WebElement getUpdateBillingExceptionButton(String billingException)
    {
   	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+billingException+"')]/following-sibling::td/button/mat-icon[contains(text(),'edit')]"));
   	 return a;
    }
    
    @FindBy(xpath = "//button[contains(text(),'Update')]")
    WebElement updateButton;
    
    public WebElement getUpdateButton()
    {
    	return updateButton;
    }
}
