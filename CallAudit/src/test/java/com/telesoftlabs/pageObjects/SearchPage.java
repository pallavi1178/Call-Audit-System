package com.telesoftlabs.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telesoftlabs.testCases.BaseClass;
import com.telesoftlabs.testCases.LoggingSetup;
import com.telesoftlabs.testCases.Tc_LatestCDR;

public class SearchPage extends BaseClass{

	public static final Logger logger = Logger.getLogger(SearchPage.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
    public SearchPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        logger.info("SearchPage initialized");
    }
    
    @FindBy(xpath = "//a[contains(@href,'/search')]")
    WebElement searchPage;
    
    public WebElement getSearchPage()
    {
    	logger.info("Accessing Search Page link");
        return searchPage;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'locationId')]")
    WebElement locationDropdown;
    
    public WebElement getLocationDropdown()
    {
    	logger.info("Accessing Location dropdown");
        return locationDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'callDirection')]")
    WebElement callDirectionDropdown;
    
    public WebElement getCallDirectionDropdown()
    {
    	logger.info("Accessing Call Direction dropdown");
        return callDirectionDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'durationOption')]")
    WebElement durationDropdown;
    
    public WebElement getDurationDropdown()
    {
    	logger.info("Accessing Duration dropdown");
        return durationDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'callType')]")
    WebElement callTypeDropdown;
    
    public WebElement getCallTypeDropdown()
    {
    	logger.info("Accessing Call Type dropdown");
        return callTypeDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'billingClass')]")
    WebElement billingClassDropdown;
    
    public WebElement getBillingClassDropdown()
    {
    	logger.info("Accessing Billing Class dropdown");
        return billingClassDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'department')]")
    WebElement departmentDropdown;
    
    public WebElement getDepartmentDropdown()
    {
    	logger.info("Accessing Department dropdown");
        return departmentDropdown;
    }
    
    @FindBy(xpath = "//mat-select[contains(@formcontrolname,'accountCode')]")
    WebElement accountCodeDropdown;
    
    public WebElement getAccountCodeDropdown()
    {
    	logger.info("Accessing Account Code dropdown");
        return accountCodeDropdown;
    }
    
    @FindBy(xpath = "//mat-label[contains(text(),'Extension')]/parent::label/following-sibling::input")
    WebElement extension;
    
    public WebElement getExtension()
    {
    	logger.info("Accessing Extension field");
        return extension;
    }
    
    @FindBy(xpath = "//mat-label[contains(text(),'Trunk')]/parent::label/following-sibling::input")
    WebElement trunk;
    
    public WebElement getTrunk()
    {
    	logger.info("Accessing Trunk field");
        return trunk;
    }
    
    @FindBy(xpath = "//mat-label[contains(text(),'Dialed Number/CLI')]/parent::label/following-sibling::input")
    WebElement dailedNumberOrCLI;
    
    public WebElement getDialedNumberOrCLI()
    {
    	logger.info("Accessing Dialed Number/CLI field");
        return dailedNumberOrCLI;
    }
    
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchButton;
    
    public WebElement getSearchButton()
    {
    	logger.info("Accessing Search button");
        return searchButton;
    }
    
    @FindBy(xpath = "//div[contains(text(),'Records not available')]")
    WebElement recordsNotAvailable;
    
    public WebElement getRecordsNotAvailable()
    {
        return recordsNotAvailable;
    }
    
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    WebElement resetButton;
    
    public WebElement getResetButton()
    {
    	logger.info("Accessing Reset button");
        return resetButton;
    }
    
    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> resultRows;
    
    public List<WebElement> getResultRows()
    {
        return resultRows;
    }
    
    // Generic method to select mat dropdown
    public void selectFromDropdown(WebElement dropdown, String value) {
    	logger.info("Selecting value: " + value + " from dropdown");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        String optionXpath = "//mat-option//span[contains(text(),'" + value + "')]";
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();
        logger.info("Selected value: " + value);
    }

    // Set filters
    public void applyFilters(String location, String direction, String durationVal, String callTypeVal,String ext, String trunkVal, String dialNum) throws InterruptedException
    {
    	logger.info("Applying filters...");
        if (location != null) {
        	logger.info("Location: " + location);
            selectFromDropdown(getLocationDropdown(), location);
        }
        Thread.sleep(100);
        if (direction != null) {
        	logger.info("Call Direction: " + direction);
            selectFromDropdown(getCallDirectionDropdown(), direction);
        }
        Thread.sleep(100);
        if (durationVal != null) {
        	logger.info("Duration: " + durationVal);
            selectFromDropdown(getDurationDropdown(), durationVal);
        }
        Thread.sleep(100);
        if (callTypeVal != null) {
        	logger.info("Call Type: " + callTypeVal);
            selectFromDropdown(getCallTypeDropdown(), callTypeVal);
        }
        Thread.sleep(100);
        if (ext != null) {
        	logger.info("Extension: " + ext);
            getExtension().sendKeys(ext);
        }
        Thread.sleep(100);
        if (trunkVal != null) {
        	logger.info("Trunk: " + trunkVal);
            getTrunk().sendKeys(trunkVal);
        }
        Thread.sleep(100);
        if (dialNum != null) {
        	logger.info("Dialed Number/CLI: " + dialNum);
            getDialedNumberOrCLI().sendKeys(dialNum);
        }
        logger.info("Filters applied successfully");
    }

    public boolean isRecordsDisplayed() {
        try {
        	logger.info("Checking if records are displayed");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfAllElements(getResultRows()));
            logger.info("Records found: " + getResultRows().size());
            return getResultRows().size() > 0;
        } catch (Exception e) {
        	logger.warning("Records not displayed");
            return false;
        }
    }

    public boolean isNoRecordsMessageDisplayed() {
        try {
        	logger.info("Checking for 'Records not available' message");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(getRecordsNotAvailable()));
            logger.info("'Records not available' message is displayed");
            return getRecordsNotAvailable().isDisplayed();
        } catch (Exception e) {
        	logger.warning("'Records not available' message not found");
            return false;
        }
    }
    
    @FindBy(xpath = "//mat-spinner")
    WebElement spinner;
    
    public WebElement getSpinner()
    {
    	return spinner;
    }
    
    @FindBy(xpath = "//mat-icon[contains(text(),'filter_alt')]")
    WebElement filterAlt;
    
    public WebElement getFilterAlt()
    {
    	return filterAlt;
    }
    
    @FindBy(xpath = "//mat-icon[contains(text(),'filter_alt_off')]")
    WebElement filterAltOff;
    
    public WebElement getFilterAltOff()
    {
    	return filterAltOff;
    }
}