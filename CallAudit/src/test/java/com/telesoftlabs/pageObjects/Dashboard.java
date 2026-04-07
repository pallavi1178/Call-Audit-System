package com.telesoftlabs.pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.testCases.BaseClass;
import com.telesoftlabs.testCases.LoggingSetup;

public class Dashboard extends BaseClass {

    WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static final Logger logger = Logger.getLogger(Dashboard.class.getName());
    static {
        LoggingSetup.configureLogger();
    }

    // Locators
    @FindBy(xpath = "//mat-label[contains(text(),'Duration')]/parent::label/following-sibling::mat-select")
    WebElement durationDropdown;

    @FindBy(xpath = "//input[contains(@name,'fromDate')]")
    WebElement fromDateInput;

    @FindBy(xpath = "//input[contains(@name,'toDate')]")
    WebElement toDateInput;

    @FindBy(xpath = "//button[contains(@class,'apply-btn')]")
    WebElement applyFilterBtn;

    @FindBy(xpath = "//span[contains(text(),'Call Summary')]")
    WebElement callSummaryTab;

    @FindBy(xpath = "//span[contains(text(),'Live CDR')]")
    WebElement liveCDRTab;

    @FindBy(id = "totalCalls")
    WebElement totalCallsElement;

    @FindBy(xpath = "//div[contains(@class,'no-records-message')]")
    WebElement noDataMessage;

    @FindBy(xpath = "//table//tbody//tr")
    List<WebElement> cdrTableRows;

    @FindBy(xpath = "//canvas[contains(@class,'callDirection')]")
    WebElement callDirectionChart;

    @FindBy(xpath = "//canvas[contains(@class,'calltype')]")
    WebElement callTypeChart;

    @FindBy(xpath = "//canvas[contains(@class,'billamount')]")
    WebElement billAmountChart;

    @FindBy(xpath = "//a[contains(@href,'/dashboard')]")
    WebElement dashboardPage;

    public WebElement getDashboardPage() {
        return dashboardPage;
    }

    // Select Duration
    public void selectDuration(String duration) {
        logger.info("Clicking Duration dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(durationDropdown)).click();
        logger.info("Selecting duration: " + duration);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[contains(text(),'" + duration + "')]")));
        option.click();
        logger.info("Duration selected successfully");
        waitForDashboardToLoad();
    }

    // Select Date Between
    public void selectDateBetween(String from, String to) {
        logger.info("Entering From Date: " + from);
        wait.until(ExpectedConditions.visibilityOf(fromDateInput));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", fromDateInput);
        fromDateInput.sendKeys(from);
        logger.info("Entering To Date: " + to);
        js.executeScript("arguments[0].value='';", toDateInput);
        toDateInput.sendKeys(to);
        logger.info("Clicking Apply Filter button");
        applyFilterBtn.click();
        waitForDashboardToLoad();
    }

    // Wait for Dashboard
    public void waitForDashboardToLoad() {
        logger.info("Waiting for loader to disappear");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//mat-spinner")));
        logger.info("Waiting for Call Summary tab visibility");
        wait.until(ExpectedConditions.visibilityOf(callSummaryTab));
        logger.info("Dashboard loaded");
    }

    // Validate Data or No Data
    public void validateNoRecordsMessage() {
        logger.warning("Using default validation without date range");       
        if (cdrTableRows.size() > 0) {
            softAssert.assertTrue(true, "Records available");
        } else {
            softAssert.assertTrue(noDataMessage.isDisplayed(),"No records message should be displayed");
        }
    }

    // Table Date Validation (FIXED)
    public void validateTableDataForDuration(String from, String to) {
        logger.info("Validating table date range");
        DateTimeFormatter configFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter uiFormatter =DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
        // Parse once
        LocalDate fromDate = LocalDate.parse(from.trim(), configFormatter);
        LocalDate toDate = LocalDate.parse(to.trim(), configFormatter);
        logger.info("Expected range: " + fromDate + " to " + toDate);
        for (WebElement row : cdrTableRows) {
            String rawDate = row.findElement(By.xpath("td[6]")).getText();
            // Clean UI date properly
            String dateText = rawDate
                    .replace("\u00A0", " ")
                    .trim();
            logger.info("Raw Date: [" + rawDate + "]");
            logger.info("Clean Date: [" + dateText + "]");
            LocalDate recordDate = LocalDate.parse(dateText, uiFormatter);
            softAssert.assertTrue((!recordDate.isBefore(fromDate) && !recordDate.isAfter(toDate)),"Invalid date: " + recordDate + " not in range");
        }
    }

    // Charts Validation
    public void validateChartsDisplayed() {
        logger.info("Validating charts visibility");
        softAssert.assertTrue(callDirectionChart.isDisplayed(),"Call Direction chart not displayed");
        softAssert.assertTrue(callTypeChart.isDisplayed(),"Call Type chart not displayed");
        softAssert.assertTrue(billAmountChart.isDisplayed(),"Bill Amount chart not displayed");
        logger.info("Charts validation completed");
    }

    public void switchToCallSummaryTab() {
        logger.info("Switching to Call Summary tab");
        callSummaryTab.click();
    }

    public void switchToLiveTableTab() {
        logger.info("Switching to Live CDR tab");
        liveCDRTab.click();
    }
}