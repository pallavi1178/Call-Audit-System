package com.telesoftlabs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telesoftlabs.testCases.BaseClass;

public class Update_Delete_Extension extends BaseClass {
	
	public Update_Delete_Extension(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//mat-icon[contains(text(),'search')]/parent::button ")
	WebElement searchExtension;
	
	public WebElement getSearchExtension()
	{
		return searchExtension;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	WebElement searchButton;
	
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	
	@FindBy(xpath = "(//mat-icon[contains(text(),'edit')]/parent::button)[1]")
	WebElement editButton;
	
	public WebElement getEditButton()
	{
		return editButton;
	}
	
	@FindBy(xpath = "((//tr/td)[3])[1]")
	WebElement usernameFromSearchResult;
	
	public WebElement getUsernameFromSearchResult()
	{
		return usernameFromSearchResult;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Records not available')]")
	WebElement recordsNotAvailable;
	
	public WebElement getRecordsNotAvailable()
	{
		return recordsNotAvailable;
	}
	
	@FindBy(xpath = "//tr")
	List<WebElement> tableRows;
	
	public List<WebElement> getTableRows()
	{
		return tableRows;
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
	
	@FindBy(xpath = "(//mat-icon[contains(text(),'delete')]/parent::button)[1]")
	WebElement deleteButton;
	
	public WebElement getDeleteButton()
	{
		return deleteButton;
	}
}
