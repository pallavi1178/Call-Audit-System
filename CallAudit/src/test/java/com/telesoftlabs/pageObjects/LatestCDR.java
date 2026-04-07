package com.telesoftlabs.pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LatestCDR {

	public LatestCDR(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'/latestcdr')]")
	WebElement latestCdrPage;
	
	public WebElement getLatestCdrPage()
	{
		return latestCdrPage;
	}
	
	@FindBy(xpath = "//mat-label[contains(text(),'Location')]/parent::label/following-sibling::mat-select")
	WebElement locationDropdown;
	
	public WebElement getLocationDropdown()
	{
		return locationDropdown;
	}
	
	@FindBy(xpath = "//mat-option")
	List<WebElement> optionsLocation;
	
	public List<WebElement> getOptionsLocation()
	{
		return optionsLocation;
	}
	
	@FindBy(xpath = "//button[contains(@class,'refresh-btn')]")
	WebElement refreshButton;
	
	public WebElement getRefreshButton()
	{
		return refreshButton;
	}
	
	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> tableRow;
	
	public List<WebElement> getTableRow()
	{
		return tableRow;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Records not available')]")
	WebElement recordsNotAvailable;
	
	public WebElement getRecordsNotAvailable()
	{
		return recordsNotAvailable;
	}
	
	@FindBy(xpath = "//div[contains(text(),'of')]")
	WebElement paginationElement;
	
	public WebElement getPaginationElement()
	{
		return paginationElement;
	}
}
