package com.telesoftlabs.testCases;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.telesoftlabs.pageObjects.Dashboard;

public class Tc_Dashboard extends BaseClass{

	public static final Logger logger = Logger.getLogger(Tc_Dashboard.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}
	Dashboard dashboard;

	@Test(priority = 1)
	public void login() {
		logger.info("===== LOGIN TEST START =====");
		try {
			Tc_Login login = new Tc_Login();
			login.login(username, password);
			logger.info("Login successful");
		} catch (Exception e) {
			logger.severe("Login failed: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void validateTodayAnalysis() {
		dashboard = new Dashboard(driver);
		logger.info("===== TODAY ANALYSIS TEST START =====");
		dashboard.getDashboardPage().click();
		dashboard.selectDuration("Today");
		dashboard.validateChartsDisplayed();
		dashboard.validateNoRecordsMessage();
		logger.info("===== TODAY ANALYSIS TEST END =====");
	}

	@Test(priority = 3)
	public void validateThisMonthAnalysis() {
		dashboard = new Dashboard(driver);
		logger.info("===== THIS MONTH TEST START =====");
		dashboard.getDashboardPage().click();
		dashboard.selectDuration("This Month");
		dashboard.validateChartsDisplayed();
		dashboard.validateNoRecordsMessage();
		logger.info("===== THIS MONTH TEST END =====");
	}

	@Test(priority = 4)
	public void validateDateBetweenAnalysis() throws InterruptedException {
		dashboard = new Dashboard(driver);
	    logger.info("===== DATE BETWEEN TEST START =====");
	    dashboard.getDashboardPage().click();
	    dashboard.selectDuration("Date Between Analysis");
	    String from = fromDate;
	    String to = toDate;
	    logger.info("Applying date range from config: " + from + " → " + to);
	    dashboard.selectDateBetween(from, to);
	    dashboard.validateChartsDisplayed();
	    dashboard.validateNoRecordsMessage();
	    logger.info("===== DATE BETWEEN TEST END =====");
	}
}
