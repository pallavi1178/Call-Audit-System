package com.telesoftlabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddPBX {
	public AddPBX(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'/setup')]")
	WebElement setupPage;

	public WebElement getSetupPage()
	{
		return setupPage;
	}

	@FindBy(xpath = "//mat-icon[contains(text(),'devices')]")
	WebElement PBX_Page;
	
	public WebElement getPBX_Page()
	{
		return PBX_Page;
	}
	
	@FindBy(xpath = "//button[contains(@mattooltip,'Add Pbx')]")
	WebElement addPBX;
	
	public WebElement getAddPBX()
	{
		return addPBX;
	}
	
	@FindBy(xpath = "//input[contains(@id,'pbxName')]")
	WebElement pbxName;
	
	public WebElement getPbxName()
	{
		return pbxName;
	}
	
	@FindBy(xpath = "//div[contains(@class,'sub-menu')]")
	WebElement subMenu;
	
	public WebElement getSubMenu()
	{
		return subMenu;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Extension')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement extensionStartPosition;
	
	public WebElement getExtensionStartPosition()
	{
		return extensionStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Extension')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement extensionWidth;
	 
	public WebElement getExtensionWidth()
	{
		return extensionWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Extension')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement extensionFormat;
	
	public WebElement getExtensionFormat()
	{
		return extensionFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Date & Time')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement dateAndTimeStartPosition;
	
	public WebElement getDateAndTimeStartPosition()
	{
		return dateAndTimeStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Date & Time')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement dateAndTimeWidth;
	 
	public WebElement getDateAndTimeWidth()
	{
		return dateAndTimeWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Date & Time')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement dateAndTimeFormat;
	
	public WebElement getDateAndTimeFormat()
	{
		return dateAndTimeFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Duration')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement durationStartPosition;
	
	public WebElement getDurationStartPosition()
	{
		return durationStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Duration')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement durationWidth;
	
	public WebElement getDurationWidth()
	{
		return durationWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Duration')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement durationFormat;
	
	public WebElement getDurationFormat()
	{
		return durationFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Trunk')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement trunkStartPosition;
	
	public WebElement getTrunkStartPosition()
	{
		return trunkStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Trunk')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement trunkWidth;
	
	public WebElement getTrunkWidth()
	{
		return trunkWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Trunk')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement trunkFormat;
	
	public WebElement getTrunkFormat()
	{
		return trunkFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Call Direction')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement callDirectionStartPosition;
	
	public WebElement getCallDirectionStartPosition()
	{
		return callDirectionStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Call Direction')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement callDirectionWidth;
	
	public WebElement getCallDirectionWidth()
	{
		return callDirectionWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Call Direction')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement callDirectionFormat;
	
	public WebElement getCallDirectionFormat()
	{
		return callDirectionFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Dialed Number')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement dialedNumberStartPosition;
	
	public WebElement getDialedNumberStartPosition()
	{
		return dialedNumberStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Dialed Number')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement dialedNumberWidth;
	
	public WebElement getDialedNumberWidth()
	{
		return dialedNumberWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Dialed Number')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement dialedNumberFormat;
	
	public WebElement getDialedNumberFormat()
	{
		return dialedNumberFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Pulses')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement pulsesStartPosition;
	
	public WebElement getPulsesStartPosition()
	{
		return pulsesStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Pulses')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement pulsesWidth;
	
	public WebElement getPulsesWidth()
	{
		return pulsesWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Pulses')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement pulsesFormat;
	
	public WebElement getPulsesFormat()
	{
		return pulsesFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Record Separator')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement recordSeperatorStartPosition;
	
	public WebElement getRecordSeperatorStartPosition()
	{
		return recordSeperatorStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Record Separator')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement recordSeperatorWidth;
	
	public WebElement getRecordSeperatorWidth()
	{
		return recordSeperatorWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Record Separator')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement recordSeperatorFormat;
	
	public WebElement getRecordSeperatorFormat()
	{
		return recordSeperatorFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Account Code')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement accountCodeStartPosition;
	
	public WebElement getAccountCodeStartPosition()
	{
		return accountCodeStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Account Code')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement accountCodeWidth;
	
	public WebElement getAccountCodeWidth()
	{
		return accountCodeWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Account Code')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement accountCodeFormat;
	
	public WebElement getAccountCodeFormat()
	{
		return accountCodeFormat;
	}
	
	@FindBy(xpath = "(//td[contains(text(),'CLI')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')])[1]")
	WebElement CLIStartPosition;
	
	public WebElement getCLIStartPosition()
	{
		return CLIStartPosition;
	}
	
	@FindBy(xpath = "(//td[contains(text(),'CLI')]/following-sibling::td/input[contains(@formcontrolname,'width')])[1]")
	WebElement CLIWidth;
	
	public WebElement getCLIWidth()
	{
		return CLIWidth;
	}
	
	@FindBy(xpath = "(//td[contains(text(),'CLI')]/following-sibling::td/input[contains(@formcontrolname,'format')])[1]")
	WebElement CLIFormat;
	
	public WebElement getCLIFormat()
	{
		return CLIFormat;
	}	
	
	@FindBy(xpath = "//td[contains(text(),'Swap')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement swapExtOrCLIForIncomingCallStartPosition;
	
	public WebElement getSwapExtOrCLIForIncomingCallStartPosition()
	{
		return swapExtOrCLIForIncomingCallStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Swap')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement swapExtOrCLIForIncomingCallWidth;
	
	public WebElement getSwapExtOrCLIForIncomingCallWidth()
	{
		return swapExtOrCLIForIncomingCallWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Swap')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement swapExtOrCLIForIncomingCallFormat;
	
	public WebElement getSwapExtOrCLIForIncomingCallFormat()
	{
		return swapExtOrCLIForIncomingCallFormat;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Column Delimiter')]/following-sibling::td/input[contains(@formcontrolname,'startPosition')]")
	WebElement columnDelimiterStartPosition;
	
	public WebElement getColumnDelimiterStartPosition()
	{
		return columnDelimiterStartPosition;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Column Delimiter')]/following-sibling::td/input[contains(@formcontrolname,'width')]")
	WebElement columnDelimiterWidth;
	
	public WebElement getColumnDelimiterWidth()
	{
		return columnDelimiterWidth;
	}
	
	@FindBy(xpath = "//td[contains(text(),'Column Delimiter')]/following-sibling::td/input[contains(@formcontrolname,'format')]")
	WebElement columnDelimiterFormat;
	
	public WebElement getColumnDelimiterFormat()
	{
		return columnDelimiterFormat;
	}
	
	@FindBy(xpath = "//button[contains(@class,'save-button')]")
	WebElement saveButton;
	
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'cancel-button')]")
	WebElement cancelButton;
	
	public WebElement getCancelButton()
	{
		return cancelButton;
	}
	
	@FindBy(xpath = "//button[contains(@class,'yes-btn')]")
	WebElement yesButton;
	
	public WebElement getYesButton()
	{
		return yesButton;
	}
	
	@FindBy(xpath = "//div[contains(@class,'mat-mdc-snack-bar-label mdc-snackbar__label')]")
	WebElement snackBar;
	
	public WebElement getSnackBar()
	{
		return snackBar;
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Duplicate')]")
	WebElement duplicatePBX;
	
	public WebElement getDuplicatePBX()
	{
		return duplicatePBX;
	}
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement OkButton;
	
	public WebElement getOkButton()
	{
		return OkButton;
	}
}
