package com.telesoftlabs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage1 {
	public ReportsPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'/report')]")
	WebElement reportsPage;
	
	public WebElement getReportsPage()
	{
		return reportsPage;
	}
	
	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'reportType')]")
	WebElement reportTypeDropdown;
	
	public WebElement getReportTypeDropdown()
	{
		return reportTypeDropdown;
	}
	
	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'locationId')]")
	WebElement locationDropdown;
	
	public WebElement getLocationDropdown()
	{
		return locationDropdown;
	}
	
	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'reportName')]")
	WebElement reportNameDropdown;
	
	public WebElement getReportNameDropdown()
	{
		return reportNameDropdown;
	}
	
	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'billingClass')]")
	WebElement billingExceptionDropdown;
	
	public WebElement getBillingExceptionDropdown()
	{
		return billingExceptionDropdown;
	}
	
	@FindBy(xpath = "//button[contains(@class,'showreportbtn')]")
	WebElement showReportButton;
	
	public WebElement getShowReportButton()
	{
		return showReportButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement okButton;
	
	public WebElement getOkButton()
	{
		return okButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'resetbtn')]")
	WebElement resetButton;
	
	public WebElement getResetButton()
	{
		return resetButton;
	}
	
	@FindBy(xpath = "//mat-option")
	List<WebElement> optionsLocation;
	
	public List<WebElement> getOptionsLocation()
	{
		return optionsLocation;
	}
}
