package com.telesoftlabs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class DeleteRegion_BillingClass_BillingException extends BaseClass{
     public DeleteRegion_BillingClass_BillingException(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public WebElement getDeleteRegionButton(String countryName)
     {
    	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+countryName+"')]/following-sibling::td/button/mat-icon[contains(text(),'delete')]"));
    	 return a;
     }
     
     @FindBy(xpath = "//button[contains(@class,'yes-btn')]")
     WebElement confirmation;
     
     public WebElement getConfirmation()
     {
    	 return confirmation;
     }
     
     public WebElement getDeleteBillingClassButton(String billingClass)
     {
    	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+billingClass+"')]/following-sibling::td/button/mat-icon[contains(text(),'delete')]"));
    	 return a;
     }
     
     public WebElement getDeleteBillingExceptionButton(String billingException)
     {
    	 WebElement a = driver.findElement(By.xpath("//td[contains(text(),'"+billingException+"')]/following-sibling::td/button/mat-icon[contains(text(),'delete')]"));
    	 return a;
     }
     
     @FindBy(xpath = "//a[contains(@href,'/cas/setup/call')]")
     WebElement callBillingPage;
     
     public WebElement getCallBillingPage()
     {
    	 return callBillingPage;
     }
}
