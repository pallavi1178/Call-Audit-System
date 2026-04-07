package com.telesoftlabs.testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.telesoftlabs.utilities.ReadConfig;

public class BaseClass {
	private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
	static 
	{
		LoggingSetup.configureLogger();
	}

	String adjustedTotalRecords="";

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	public String selectedLogger = "";
	int totalRecords = 0;
	WebElement loggerElement;
	protected long duration;
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentTest failedTestLogger;
	public static String screenshotSubFolderName;

	protected String baseurl;
	protected String browser;
	protected String username;
	protected String password;
	protected String dbUrl;
	protected String userNameForDbConnection;
	protected String passwordForDbConnection;
	protected String classNameSQLServer;
	protected String classNameMySQL;
	protected String dashboardPageURL;
	protected String loginSnackBar;
	protected String invalidUsernameOrPassword;
	protected String countryName;
	protected String countryCode;
	protected String IDD;
	protected String NDD;
	protected String areacode;
	protected String fixedLineStartDigits;
	protected String mobileStartDigits;
	protected String serviceProviderName;
	protected String networkStartDigits;
	protected String callBillingPageURL;
	protected String addRegionSnackbar;
	protected String billingClass;
	protected String gracePeriod;
	protected String pulseInSeconds;
	protected String chargePerPulse;
	protected String markupPercentage;
	protected String surcharge;
	protected String tollFreeNumber;
	protected String description;
	protected String extensionStartPosition;
	protected String extensionWidth;
	protected String extensionFormat;
	protected String dateAndTimeStartPosition;
	protected String dateAndTimeWidth;
	protected String dateAndTimeFormat;
	protected String durationStartPosition;
	protected String durationWidth;
	protected String durationFormat;
	protected String trunkStartPosition;
	protected String trunkWidth;
	protected String trunkFormat;
	protected String callDirectionStartPosition;
	protected String callDirectionwidth;
	protected String callDirectionFormat;
	protected String dialedNumberStartPosition;
	protected String dialedNumberWidth;
	protected String dialedNumberFormat;
	protected String pulsesStartPosition;
	protected String pulsesWidth;
	protected String pulsesFormat;
	protected String recordSeperatorStartPosition;
	protected String recordSeperatorWidth;
	protected String recordSeperatorFormat;
	protected String accountCodeStartPosition;
	protected String accountCodeWidth;
	protected String accountCodeFormat;
	protected String CLIStartPosition;
	protected String CLIWidth;
	protected String CLIFormat;
	protected String swapExtOrCLIForIncomingCallStartPosition;
	protected String swapExtOrCLIForIncomingCallWidth;
	protected String swapExtOrCLIForIncomingCallFormat;
	protected String columnDelimiterStartPosition;
	protected String columnDelimiterWidth;
	protected String columnDelimiterFormat;
	protected String pbxName;
	protected String pbxMasterPageURL;
	protected String locationName;
	protected String cdrFilePath;
	protected String cdrFileExtension;
	protected String cdrDumpFilePath;
	protected String locationPropertiesPageURL;
	protected String communicationMode;
	protected String connectionMode;
	protected String ipAddress;
	protected String ipPort;
	protected String retryInterval;
	protected String comPort;
	protected String baudRate;
	protected String parity;
	protected String dataBit;
	protected String stopBit;
	protected String rolesPageURL;
	protected String roleName;
	protected String addBillingClassSnackbar;
	protected String addBillingExceptionSnackbar;
	protected String addLocationPropertiesSnackbar;
	protected String addPbxSnackbar;
	protected String addRolesSnackbar;
	protected String deleteBillingClassSnackbar;
	protected String deleteBillingExceptionSnackbar;
	protected String deleteLocationPropertiesSnackbar;
	protected String deletePbxSnackbar;
	protected String deleteRegionSnackbar;
	protected String updateBillingClassSnackbar;
	protected String updateBillingExceptionSnackbar;
	protected String updateLocationPropertiesSnackbar;
	protected String updatePbxSnackbar;
	protected String updateRegionSnackbar;
	protected String updateRolesSnackbar;
	protected String deleteRolesSnackbar;
	protected String usersPageURL;
	protected String addUsersSnackbar;
	protected String user;
	protected String displayName;
	protected String userPassword;
	protected String userEmail;
	protected String updateUserSnackbar;
	protected String deleteUserSnackbar;
	protected String extensionPageURL;
	protected String addExtensionSnackbar;
	protected String fromExtension;
	protected String toExtension;
	protected String extensionUsername;
	protected String trunkName;
	protected String searchLocation;
	protected String searchDirection;
	protected String searchDuration;
	protected String searchCallType;
	protected String searchExtension;
	protected String searchTrunk;
	protected String searchDialedNumber;
	protected String fromDate;
	protected String toDate;

	public BaseClass()
	{
		try {
			ReadConfig readConfig = new ReadConfig();
			baseurl = readConfig.getbaseurl();
			browser = readConfig.getBrowser();
			username = readConfig.getUserName();
			password = readConfig.getPassword();
			dbUrl = readConfig.getDbUrl();
			userNameForDbConnection = readConfig.getUserNameForDbConnection();
			passwordForDbConnection = readConfig.getPasswordForDbConnection();
			classNameSQLServer = readConfig.getClassNameSQLServer();
			classNameMySQL = readConfig.getClassNameMySQL();
			dashboardPageURL = readConfig.getDashboardPageURL();
			loginSnackBar = readConfig.getLoginSnackBar();
			invalidUsernameOrPassword = readConfig.getInvalidUsernameOrPassword();
			countryName = readConfig.getCountryName();
			countryCode = readConfig.getCountryCode();
			IDD = readConfig.getIDD();
			NDD = readConfig.getNDD();
			areacode = readConfig.getAreacode();
			fixedLineStartDigits = readConfig.getFixedLineStartDigits();
			mobileStartDigits = readConfig.getMobileStartDigits();
			serviceProviderName = readConfig.getServiceProviderName();
			networkStartDigits = readConfig.getNetworkStartDigits();
			callBillingPageURL = readConfig.getCallBillingPageURL();
			addRegionSnackbar = readConfig.getAddRegionSnackbar();
			billingClass = readConfig.getbillingClass();
			gracePeriod = readConfig.getGracePeriod();
			pulseInSeconds = readConfig.getPulseInSeconds();
			chargePerPulse = readConfig.getChargePerPulse();
			markupPercentage = readConfig.getMarkupPercentage();
			surcharge = readConfig.getSurcharge();
			tollFreeNumber = readConfig.getTollFreeNumber();
			description = readConfig.getDescription();
			extensionStartPosition = readConfig.getExtensionStartPosition();
			extensionWidth = readConfig.getExtensionWidth();
			extensionFormat = readConfig.getExtensionFormat();
			dateAndTimeStartPosition = readConfig.getDateAndTimeStartPosition();
			dateAndTimeWidth = readConfig.getDateAndTimeWidth();
			dateAndTimeFormat = readConfig.getDateAndTimeFormat();
			durationStartPosition = readConfig.getDurationStartPosition();
			durationWidth = readConfig.getDurationWidth();
			durationFormat = readConfig.getDurationFormat();
			trunkStartPosition = readConfig.getTrunkStartPosition();
			trunkWidth = readConfig.getTrunkWidth();
			trunkFormat = readConfig.getTrunkFormat();
			callDirectionStartPosition = readConfig.getCallDirectionStartPosition();
			callDirectionwidth = readConfig.getCallDirectionwidth();
			callDirectionFormat = readConfig.getCallDirectionFormat();
			dialedNumberStartPosition = readConfig.getDialedNumberStartPosition();
			dialedNumberWidth = readConfig.getDialedNumberWidth();
			dialedNumberFormat = readConfig.getDialedNumberFormat();
			pulsesStartPosition = readConfig.getPulsesStartPosition();
			pulsesWidth = readConfig.getPulsesWidth();
			pulsesFormat = readConfig.getPulsesFormat();
			recordSeperatorStartPosition = readConfig.getRecordSeperatorStartPosition();
			recordSeperatorWidth = readConfig.getRecordSeperatorWidth();
			recordSeperatorFormat = readConfig.getRecordSeperatorFormat();
			accountCodeStartPosition = readConfig.getAccountCodeStartPosition();
			accountCodeWidth = readConfig.getAccountCodeWidth();
			accountCodeFormat = readConfig.getAccountCodeFormat();
			CLIStartPosition = readConfig.getCLIStartPosition();
			CLIWidth = readConfig.getCLIWidth();
			CLIFormat = readConfig.getCLIFormat();
			swapExtOrCLIForIncomingCallStartPosition = readConfig.getSwapExtOrCLIForIncomingCallStartPosition();
			swapExtOrCLIForIncomingCallWidth = readConfig.getSwapExtOrCLIForIncomingCallWidth();
			swapExtOrCLIForIncomingCallFormat = readConfig.getSwapExtOrCLIForIncomingCallFormat();
			columnDelimiterStartPosition = readConfig.getColumnDelimiterStartPosition();
			columnDelimiterWidth = readConfig.getColumnDelimiterWidth();
			columnDelimiterFormat = readConfig.getColumnDelimiterFormat();
			pbxName = readConfig.getPbxName();
			pbxMasterPageURL = readConfig.getPbxMasterPageURL();
			locationName = readConfig.getLocationName();
			cdrFilePath = readConfig.getCdrFilePath();
			cdrFileExtension = readConfig.getCdrFileExtension();
			cdrDumpFilePath = readConfig.getCdrDumpFilePath();
			locationPropertiesPageURL = readConfig.getlocationPropertiesPageURL();
			communicationMode = readConfig.getCommunicationMode();
			connectionMode = readConfig.getConnectionMode();
			ipAddress = readConfig.getIpAddress();
			ipPort = readConfig.getIpPort();
			retryInterval = readConfig.getRetryInterval();
			comPort = readConfig.getComPort();
			baudRate = readConfig.getBaudRate();
			parity = readConfig.getParity();
			dataBit = readConfig.getDataBit();
			stopBit = readConfig.getStopBit();
			rolesPageURL = readConfig.getRolesPageURL();
			roleName = readConfig.getRoleName();
			addBillingClassSnackbar = readConfig.getAddBillingClassSnackbar();
			addBillingExceptionSnackbar = readConfig.getAddBillingExceptionSnackbar();
			addLocationPropertiesSnackbar = readConfig.getAddLocationPropertiesSnackbar();
			addPbxSnackbar = readConfig.getAddPbxSnackbar();
			addRolesSnackbar = readConfig.getAddRolesSnackbar();
			deleteBillingClassSnackbar = readConfig.getDeleteBillingClassSnackbar();
			deleteBillingExceptionSnackbar = readConfig.getDeleteBillingExceptionSnackbar();
			deleteLocationPropertiesSnackbar = readConfig.getDeleteLocationPropertiesSnackbar();
			deletePbxSnackbar = readConfig.getDeletePbxSnackbar();
			deleteRegionSnackbar = readConfig.getDeleteRegionSnackbar();
			updateBillingClassSnackbar = readConfig.getUpdateBillingClassSnackbar();
			updateBillingExceptionSnackbar = readConfig.getupdateBillingExceptionSnackbar();
			updateLocationPropertiesSnackbar = readConfig.getUpdateLocationPropertiesSnackbar();
			updatePbxSnackbar = readConfig.getUpdatePbxSnackbar();
			updateRegionSnackbar = readConfig.getUpdateRegionSnackbar();
			updateRolesSnackbar = readConfig.getUpdateRolesSnackbar();
			deleteRolesSnackbar = readConfig.getDeleteRolesSnackbar();
			usersPageURL = readConfig.getUsersPageURL();
			addUsersSnackbar = readConfig.getAddUsersSnackbar();
			user = readConfig.getUser();
			displayName = readConfig.getDisplayName();
			userPassword = readConfig.getUserPassword();
			userEmail = readConfig.getUserEmail();
			updateUserSnackbar = readConfig.getUpdateUserSnackbar();
			deleteUserSnackbar = readConfig.getDeleteUserSnackbar();
			extensionPageURL = readConfig.getExtensionPageURL();
			addExtensionSnackbar = readConfig.getAddExtensionSnackbar();
			fromExtension = readConfig.getFromExtension();
			toExtension = readConfig.getToExtension();
			extensionUsername = readConfig.getExtensionUsername();
			trunkName = readConfig.getTrunkName();
			searchLocation = readConfig.getSearchLocation();
			searchDirection = readConfig.getSearchDirection();
			searchDuration = readConfig.getSearchDuration();
			searchCallType = readConfig.getSearchCallType();
			searchExtension = readConfig.getSearchExtension();
			searchTrunk = readConfig.getSearchTrunk();
			searchDialedNumber = readConfig.getSearchDialedNumber();
			fromDate = readConfig.getFromDate();
			toDate = readConfig.getToDate();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
   Maximizes the browser window and sets an implicit wait of 10 seconds. 
   Initializes the extentTest instance with the test context name. 
	 */
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("firefox") String browser,ITestContext context) throws SQLException, ClassNotFoundException {
		try {
			ReadConfig readConfig = new ReadConfig();
			if (browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", readConfig.getchromepath());
				driver = new ChromeDriver();
			}
			else if (browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", readConfig.getfirefoxpath());
				driver = new FirefoxDriver();
			}
			else if (browser.equals("msedge"))
			{
				System.setProperty("webdriver.msedge.driver", readConfig.getEdgePath());
				driver = new EdgeDriver();
			}
			logger.info("Browser initialized: " + browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
			logger.info("Browser Launched ");
			extentTest = extentReports.createTest(context.getName());
			Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = capabilities.getBrowserName();
			String browserVersion = capabilities.getBrowserVersion();
			extentReports.setSystemInfo("Browser", browserName);
			extentReports.setSystemInfo("Browser Version", browserVersion);
			
			//Tc_Login login = new Tc_Login();
			//login.login(username, password);
		} 
		catch (Exception e) 
		{
			logger.severe("exception is : "+ e.getClass() +" "+ e.getMessage());
		}
	}

	@Test
	public void placeholderTest() {}

	@AfterClass
	public void tearDown() {

		// Close database connection
		if (connection != null) {
			try {
				connection.close();
				logger.info("Database connection closed.");
			} catch (SQLException e) {
				logger.severe("Error closing database connection: " + e.getMessage());
			}
		}
		// Close the WebDriver
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed and driver instance terminated.");
		}
	}

	/**
	 * Initializes the WebDriver based on the specified browser parameter (Chrome, Firefox, or Edge). 
	 * Initializes ExtentReports for generating test reports.
	 * This method sets up the ExtentReports instance before the test suite execution. It configures two
	 * ExtentSparkReporters: one for all test reports and another specifically for failed test reports.
	 * The reports are generated in HTML format and are named "AllTests.html" and "FailedTests.html"
	 * respectively. Both reporters are attached to the ExtentReports instance, enabling the generation
	 * of comprehensive and failed test reports.
	 * In case of any exceptions during initialization, the exception message is printed to the console.
	 */
	@BeforeSuite
	public void initialiseExtentReports() {
		try {
			extentReports = new ExtentReports();
			ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
			sparkReporter_all.config().setReportName("All test reports");

			//ExtentSparkReporter sparkReporter_Failed = new ExtentSparkReporter("FailedTests.html");
			//	sparkReporter_Failed.config().setReportName("Failed test reports");
			extentReports.attachReporter(sparkReporter_all);//, sparkReporter_Failed);
			// Retrieve the capabilities of the browser
			// Add system info
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
			extentReports.setSystemInfo("Architecture", System.getProperty("os.arch"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		catch (Exception e) {
			logger.severe("exception is : "+ e.getClass() +" "+ e.getMessage());
		}

	}

	/**
	 * Generates and flushes the ExtentReports at the end of the test suite.
	 * This method is annotated with @AfterSuite, indicating that it will be executed once after all tests 
	 * in the suite have finished. It ensures that all the logged test information is written to the 
	 * configured ExtentReports and the report files are finalized.
	 */
	@AfterSuite
	public void generateExtentReports() 
	{
		extentReports.flush();
	}

	/**
	 * Logs the test result and takes a screenshot if the test fails.
	 * This method is annotated with @AfterMethod, indicating that it will be executed after each test method.
	 * It checks the test result status and logs the result accordingly. If the test fails, it captures a 
	 * screenshot and attaches it to the ExtentReports. Additionally, it logs the failed test in a separate 
	 * failed test logger. 
	 * @param m the test method that was executed
	 * @param result the result of the executed test method
	 * @throws IOException if an I/O error occurs while capturing the screenshot
	 */
	@AfterMethod
	public void checkStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = captureScreenShot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".png");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());

			// Log the failed test in the failed test logger
			failedTestLogger = extentReports.createTest("Failed: " + result.getMethod().getMethodName());
			failedTestLogger.addScreenCaptureFromPath(screenshotPath);
			failedTestLogger.fail(result.getThrowable());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			extentTest.pass(m.getName() + " is passed");
		}
	}

	/**
	 * Captures a screenshot and saves it to the specified directory.
	 * 
	 * This method takes a screenshot of the current WebDriver instance and saves it to a directory 
	 * structure based on the timestamp when the screenshot was captured. If the directory for 
	 * screenshots does not exist, it creates a new one. The screenshot file is named with the provided
	 * fileName parameter.
	 * 
	 * @param fileName the name of the screenshot file
	 * @return the file path of the captured screenshot
	 */
	public String captureScreenShot(String fileName) {
		if (screenshotSubFolderName == null) 
		{
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			screenshotSubFolderName = date.format(formatter);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destFilePath = "./Screenshots/" + screenshotSubFolderName + "/" + fileName;
		File destFile = new File(destFilePath);
		try 
		{
			FileUtils.copyFile(sourceFile, destFile);
		} 
		catch (Exception e)
		{
			logger.severe("exception is : "+ e.getClass() +" "+ e.getMessage());
		}
		return destFilePath;
	}

	/**
	 * Establishes and returns a database connection using the provided JDBC driver class name.
	 * 
	 * This method loads the specified JDBC driver class (if required) and creates a connection 
	 * to the database using the provided database URL, username, and password. It logs a 
	 * success message upon successful connection or logs an error message in case of a failure.
	 * 
	 * @param className the fully qualified name of the JDBC driver class
	 * @return a {@link Connection} object to the database
	 * @throws SQLException if a database access error occurs
	 * @throws ClassNotFoundException if the JDBC driver class is not found
	 */
	public Connection getDBConnection(String className) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {
			// Load the JDBC driver (optional step for newer JDBC versions)
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName(className);

			// Establish connection
			connection = DriverManager.getConnection(dbUrl, userNameForDbConnection, passwordForDbConnection);
			logger.info("Database connected successfully.");

		} catch (SQLException e) {
			logger.severe( "Exception is: "+e.getMessage());
		}
		return connection;
	}

	public Connection getDBConnectionOld() throws SQLException {
		Connection connection = null;
		try {
			// Establish connection with added timeout parameters for optimization
			connection = DriverManager.getConnection(
					dbUrl + ";loginTimeout=10;socketTimeout=30;", 
					userNameForDbConnection, 
					passwordForDbConnection
					);
			logger.info("Database connected successfully.");

		} catch (SQLException e) {
			logger.severe("Failed to connect to the database. Error: " + e.getMessage());
			throw e; 
		}
		return connection;
	}

	/**
	 * Executes the given SQL query and logs the total record count retrieved from the database.
	 * 
	 * This method establishes a connection to the database, executes the provided SQL query, 
	 * and iterates over the result set to count the number of records retrieved. The total 
	 * record count is then logged. The method includes exception handling to print any 
	 * SQL errors encountered during execution.
	 * 
	 * @param query the SQL query to execute
	 * @throws ClassNotFoundException if the database driver class is not found
	 */
	public void executeSQLQueryOld(String query) throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// Establish connection
			connection = getDBConnection(classNameSQLServer);

			// Create statement
			statement = connection.createStatement();

			// Execute query
			resultSet = statement.executeQuery(query);

			// Count the total number of records fetched
			int totalRecords = 0;

			// Iterate over the ResultSet to count records
			while (resultSet.next()) {
				totalRecords++;
			}
			adjustedTotalRecords = String.valueOf(totalRecords);
			// Print the total number of records found
			logger.info("Total records found in DB for the query: " + adjustedTotalRecords);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes the given SQL query and logs the total record count retrieved from the database.
	 * 
	 * This method establishes a database connection, executes the provided SQL query, 
	 * and retrieves the result set. It fetches the count of records from the result set 
	 * and logs the total number of records. The method ensures proper resource management 
	 * by using a try-with-resources block to close database resources automatically.
	 * 
	 * If an SQL exception occurs during query execution, it logs the error along with 
	 * the query. Additionally, it handles any other unexpected exceptions, logging their 
	 * type and message for easier troubleshooting.
	 * 
	 * @param query the SQL query to be executed
	 * @throws ClassNotFoundException if the database driver class is not found
	 */
	public void executeSQLQuery(String query) throws ClassNotFoundException {
		try (
				// Establish connection
				Connection connection = getDBConnection(classNameSQLServer);
				// Create statement
				Statement statement = connection.createStatement();
				// Execute query
				ResultSet resultSet = statement.executeQuery(query)
				) {
			// Fetch the count directly
			if (resultSet.next()) {
				totalRecords = resultSet.getInt(1);
				logger.info("Total records found in DB for the query: " + totalRecords);
			}
		} catch (SQLException e) {
			logger.severe("SQL error while executing the query: " + query);
		}
		catch (Exception e) {
			logger.severe("exception is : "+ e.getClass() +" "+ e.getMessage());
		}
	}

	// Data provider method
	@DataProvider
	public Object[][] loginData() {
		return new Object[][] {
			{"invalidUser", "invalidPass"},
			{"",""},
			{"", "invalidPass"},
			{"InvalidUser", ""},
			{username, password} // This is the valid login case
		};
	}
}
