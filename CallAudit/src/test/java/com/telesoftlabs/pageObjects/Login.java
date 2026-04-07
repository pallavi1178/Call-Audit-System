package com.telesoftlabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class Login extends BaseClass{
    public Login(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[contains(@formcontrolname,'username')]")
    WebElement username;
    
    public WebElement getUsername()
    {
    	return username;
    }
    
    @FindBy(xpath = "//input[contains(@formcontrolname,'password')]")
    WebElement password;
    
    public WebElement getPassword()
    {
    	return password;
    }
    
    @FindBy(xpath = "//button[contains(text(),' Login ')]")
    WebElement loginButton;
    
    public WebElement getLoginButton()
    {
    	return loginButton;
    }    
    
    @FindBy(xpath = "//button[contains(@class,'yes-btn')]")
    WebElement confirmPreviousSessionLogout;
    
    public WebElement getConfirmPreviousSessionLogout()
    {
    	return confirmPreviousSessionLogout;
    }
    
    @FindBy(xpath = "//div[contains(@class,'mat-mdc-snack-bar-label mdc-snackbar__label')]")
	WebElement snackBar;
	
	public WebElement getSnackBar()
	{
		return snackBar;
	}
}
