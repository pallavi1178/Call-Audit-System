package com.telesoftlabs.testCases;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnerClass extends BaseClass implements  ITestListener 
{
	private static final Logger logger = Logger.getLogger(ITestListnerClass.class.getName());
	static 
	{
		LoggingSetup.configureLogger();
	}
	public long suiteStartTime;
	public long suiteEndTime;
	public long startTime;
	public long endTime;
	/*
	@Override
	public void onTestFailure(ITestResult result) 
	{
		// Print test context name and method name that failed
		System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		logger.info("Failed method is: "+ result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		// Capture screenshot with a filename based on test context name and method name
		captureScreenShot("Test context name and method name that failed is: "+result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
	}
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// Record the start time when a test starts
		startTime = System.currentTimeMillis();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Record the end time and calculate the duration when a test succeeds
		endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		long durationInSec = (long) (duration/1000.0);
		logger.info("Duration when tests success is: "+result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + " passed in " + durationInSec + " seconds");
		logger.info("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Record the end time and calculate the duration when a test fails
		endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		long durationInSec = (long) (duration/1000.0);
		logger.info("Failed script is: "+result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + " failed in " + durationInSec + " seconds");		
		//logger.info("Failed script is: "+result.getTestContext().getName() + "_" + result.getMethod().getMethodName());
		captureScreenShot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".png");
		logger.info("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Record the end time and calculate the duration when a test is skipped
		endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		long durationInSec = (long) (duration/1000.0);
		logger.info(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + " skipped in " + durationInSec + " seconds");
		logger.info("----------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Not implementing this method as it's not required
	}

	@Override
	public void onStart(ITestContext context) {
		// Record the start time when the test suite starts
		suiteStartTime = System.currentTimeMillis();
		// Convert milliseconds to LocalTime
		//LocalTime time = LocalTime.ofInstant(
		//java.time.Instant.ofEpochMilli(suiteStartTime),
		//ZoneId.systemDefault());

		Instant instant = Instant.now();
		ZoneId zone = ZoneId.systemDefault();
		// Convert to LocalTime via ZonedDateTime
		LocalTime time = instant.atZone(zone).toLocalTime();
		logger.info("Local Time: " + time);

		// Define the time format for 12-hour format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");       
        // Format the LocalTime object to a 12-hour format
        String formattedTime = time.format(formatter);       
		//System.out.println("Test suite started: " + context.getName());
        logger.info("---------------------****** New Test Execution["+context.getName()+"] ******---------------------");
		logger.info("Test suite started: " + context.getName());
		logger.info("Suite start time: "+formattedTime);
	}

	@Override
	public void onFinish(ITestContext context) {
		// Record the end time and calculate the duration when the test suite finishes
		suiteEndTime = System.currentTimeMillis();
		long suiteDuration = suiteEndTime - suiteStartTime;
		long durationInSec = (long) (suiteDuration/1000.0); 
		double durationInMin = (double) (durationInSec/60.0); 
		logger.info("Test suite finished: " + context.getName());
		// Convert milliseconds to LocalTime
		/*
		LocalTime time = LocalTime.ofInstant(
		java.time.Instant.ofEpochMilli(suiteEndTime),
		ZoneId.systemDefault());
		*/

		Instant instant = Instant.now();
		ZoneId zone = ZoneId.systemDefault();
		// Convert to LocalTime via ZonedDateTime
		LocalTime time = instant.atZone(zone).toLocalTime();
		logger.info("Local Time: " + time);

		// Define the time format for 12-hour format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");       
        // Format the LocalTime object to a 12-hour format
        String formattedTime = time.format(formatter); 
		logger.info("Suite End time: "+formattedTime);
		//logger.info("Total suite duration: " + suiteDuration + " milliseconds");
		logger.info("Total suite duration in seconds: " + durationInSec + " seconds");
		logger.info("Total suite duration in minutes: " + durationInMin + " minutes");
	}

}