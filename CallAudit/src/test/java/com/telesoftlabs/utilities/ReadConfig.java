package com.telesoftlabs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.openqa.selenium.WebElement;

import net.bytebuddy.matcher.MethodReturnTypeMatcher;

public class ReadConfig {
	Properties pro;
	String appDirectory = "";
	public ReadConfig() throws IOException
	{
		appDirectory = new File("").getAbsolutePath();
		File src=new File("./Configurations/config.properties");
		try {
			// Load the config.properties file
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) 
		{
			System.out.println("Exception is" + e.getMessage());
		}
	}
	public String getbaseurl()
	{
		String baseurl= pro.getProperty("baseurl");
		return baseurl;
	}

	public String getfirefoxpath()
	{
		String firefoxpath= pro.getProperty("firefoxpath");
		return  appDirectory+"\\"+firefoxpath; 
	}

	public String getchromepath()
	{
		String chromepath= pro.getProperty("chromepath");
		return  appDirectory+"\\"+chromepath; 
	}

	public String getEdgePath()
	{
		String edgePath = pro.getProperty("msedgepath");
		return appDirectory+"\\"+edgePath;
	}

	public String getBrowser()
	{
		String browser = pro.getProperty("browser");
		return browser;
	}

	public String getUserName()
	{
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

	public String getClassNameSQLServer()
	{
		String classNameSQLServer = pro.getProperty("classNameSQLServer");
		return classNameSQLServer;
	}

	public String getClassNameMySQL()
	{
		String classNameMySQL = pro.getProperty("classNameMySQL");
		return classNameMySQL;
	}

	public String getDbUrl()
	{
		String dbUrl = pro.getProperty("dbUrl");
		return dbUrl;
	}

	public String getUserNameForDbConnection()
	{
		String userNameForDbConnection = pro.getProperty("userNameForDbConnection");
		return userNameForDbConnection;
	}

	public String getPasswordForDbConnection()
	{
		String passwordForDbConnection = pro.getProperty("passwordForDbConnection");
		return passwordForDbConnection;
	}

	public String getDashboardPageURL()
	{
		String dashboardPageURL = pro.getProperty("dashboardPageURL");
		return dashboardPageURL;
	}

	public String getLoginSnackBar()
	{
		String loginSnackBar = pro.getProperty("loginSnackBar");
		return loginSnackBar;
	}

	public String getInvalidUsernameOrPassword()
	{
		String invalidUsernameOrPassword = pro.getProperty("invalidUsernameOrPassword");
		return invalidUsernameOrPassword;
	}

	public String getCountryName()
	{
		String countryName = pro.getProperty("countryName");
		return countryName;
	}

	public String getCountryCode()
	{
		String countryCode = pro.getProperty("countryCode");
		return countryCode;
	}

	public String getIDD()
	{
		String IDD = pro.getProperty("IDD");
		return IDD;
	}

	public String getNDD()
	{
		String NDD = pro.getProperty("NDD");
		return NDD;
	}

	public String getAreacode()
	{
		String areacode = pro.getProperty("areacode");
		return areacode;
	}

	public String getFixedLineStartDigits()
	{
		String fixedLineStartDigits = pro.getProperty("fixedLineStartDigits");
		return fixedLineStartDigits;
	}

	public String getMobileStartDigits()
	{
		String mobileStartDigits = pro.getProperty("mobileStartDigits");
		return mobileStartDigits;
	}

	public String getServiceProviderName()
	{
		String serviceProviderName = pro.getProperty("serviceProviderName");
		return serviceProviderName;
	}

	public String getNetworkStartDigits()
	{
		String networkStartDigits = pro.getProperty("networkStartDigits");
		return networkStartDigits;
	}

	public String getCallBillingPageURL()
	{
		String callBillingPageURL = pro.getProperty("callBillingPageURL");
		return callBillingPageURL;
	}

	public String getAddRegionSnackbar()
	{
		String addRegionSnackbar = pro.getProperty("addRegionSnackbar");
		return addRegionSnackbar;
	}

	public String getbillingClass()
	{
		String billingClass = pro.getProperty("billingClass");
		return billingClass;
	}

	public String getGracePeriod()
	{
		String gracePeriod = pro.getProperty("gracePeriod");
		return gracePeriod;
	}
	
	public String getPulseInSeconds()
	{
		String pulseInSeconds = pro.getProperty("pulseInSeconds");
		return pulseInSeconds;
	}
	
	public String getChargePerPulse()
	{
		String chargePerPulse = pro.getProperty("chargePerPulse");
		return chargePerPulse;
	}
	
	public String getMarkupPercentage()
	{
		String markupPercentage = pro.getProperty("markupPercentage");
		return markupPercentage;
	}
	
	public String getSurcharge()
	{
		String surcharge = pro.getProperty("surcharge");
		return surcharge;
	}
	
	public String getTollFreeNumber()
	{
		String tollFreeNumber = pro.getProperty("tollFreeNumber");
		return tollFreeNumber;
	}
	
	public String getDescription()
	{
		String description = pro.getProperty("description");
		return description;
	}
	
	public String getExtensionStartPosition()
	{
		String extensionStartPosition = pro.getProperty("extensionStartPosition");
		return extensionStartPosition;
	}
	
	public String getExtensionWidth()
	{
		String extensionWidth = pro.getProperty("extensionWidth");
		return extensionWidth;
	}
	
	public String getExtensionFormat()
	{
		String extensionFormat = pro.getProperty("extensionFormat");
		return extensionFormat;
	}
	
	public String getDateAndTimeStartPosition()
	{
		String dateAndTimeStartPosition = pro.getProperty("dateAndTimeStartPosition");
		return dateAndTimeStartPosition;
	}
	
	public String getDateAndTimeWidth()
	{
		String dateAndTimeWidth = pro.getProperty("dateAndTimeWidth");
		return dateAndTimeWidth;
	}
	
	public String getDateAndTimeFormat()
	{
		String dateAndTimeFormat = pro.getProperty("dateAndTimeFormat");
		return dateAndTimeFormat;
	}
	
	public String getDurationStartPosition()
	{
		String durationStartPosition = pro.getProperty("durationStartPosition");
		return durationStartPosition;
	}
	
	public String getDurationWidth()
	{
		String durationWidth = pro.getProperty("durationWidth");
		return durationWidth;
	}
	
	public String getDurationFormat()
	{
		String durationFormat = pro.getProperty("durationFormat");
		return durationFormat;
	}
	
	public String getTrunkStartPosition()
	{
		String trunkStartPosition = pro.getProperty("trunkStartPosition");
		return trunkStartPosition;
	}
	
	public String getTrunkWidth()
	{
		String trunkWidth = pro.getProperty("trunkWidth");
		return trunkWidth;
	}
	
	public String getTrunkFormat()
	{
		String trunkFormat = pro.getProperty("trunkFormat");
		return trunkFormat;
	}
	
	public String getCallDirectionStartPosition()
	{
		String callDirectionStartPosition = pro.getProperty("callDirectionStartPosition");
		return callDirectionStartPosition;
	}
	
	public String getCallDirectionwidth()
	{
		String callDirectionwidth = pro.getProperty("callDirectionwidth");
		return callDirectionwidth;
	}
	
	public String getCallDirectionFormat()
	{
		String callDirectionFormat = pro.getProperty("callDirectionFormat");
		return callDirectionFormat;
	}
	
	public String getDialedNumberStartPosition()
	{
		String dialedNumberStartPosition = pro.getProperty("dialedNumberStartPosition");
		return dialedNumberStartPosition;
	}
	
	public String getDialedNumberWidth()
	{
		String dialedNumberWidth = pro.getProperty("dialedNumberWidth");
		return dialedNumberWidth;
	}
	
	public String getDialedNumberFormat()
	{
		String dialedNumberFormat = pro.getProperty("dialedNumberFormat");
		return dialedNumberFormat;
	}
	
	public String getPulsesStartPosition()
	{
		String pulsesStartPosition = pro.getProperty("pulsesStartPosition");
		return pulsesStartPosition;
	}
	
	public String getPulsesWidth()
	{
		String pulsesWidth = pro.getProperty("pulsesWidth");
		return pulsesWidth;
	}
	
	public String getPulsesFormat()
	{
		String pulsesFormat = pro.getProperty("pulsesFormat");
		return pulsesFormat;
	}
	
	public String getRecordSeperatorStartPosition()
	{
		String recordSeperatorStartPosition = pro.getProperty("recordSeperatorStartPosition");
		return recordSeperatorStartPosition;
	}
	
	public String getRecordSeperatorWidth()
	{
		String recordSeperatorWidth = pro.getProperty("recordSeperatorWidth");
		return recordSeperatorWidth;
	}
	
	public String getRecordSeperatorFormat()
	{
		String recordSeperatorFormat = pro.getProperty("recordSeperatorFormat");
		return recordSeperatorFormat;
	}
	
	public String getAccountCodeStartPosition()
	{
		String accountCodeStartPosition = pro.getProperty("accountCodeStartPosition");
		return accountCodeStartPosition;
	}
	
	public String getAccountCodeWidth()
	{
		String accountCodeWidth = pro.getProperty("accountCodeWidth");
		return accountCodeWidth;
	}
	
	public String getAccountCodeFormat()
	{
		String accountCodeFormat = pro.getProperty("accountCodeFormat");
		return accountCodeFormat;
	}
	
	public String getCLIStartPosition()
	{
		String CLIStartPosition = pro.getProperty("CLIStartPosition");
		return CLIStartPosition;
	}
	
	public String getCLIWidth()
	{
		String CLIWidth = pro.getProperty("CLIWidth");
		return CLIWidth;
	}
	
	public String getCLIFormat()
	{
		String CLIFormat = pro.getProperty("CLIFormat");
		return CLIFormat;
	}
	
	public String getSwapExtOrCLIForIncomingCallStartPosition()
	{
		String swapExtOrCLIForIncomingCallStartPosition = pro.getProperty("swapExtOrCLIForIncomingCallStartPosition");
		return swapExtOrCLIForIncomingCallStartPosition;
	}
	
	public String getSwapExtOrCLIForIncomingCallWidth()
	{
		String swapExtOrCLIForIncomingCallWidth = pro.getProperty("swapExtOrCLIForIncomingCallWidth");
		return swapExtOrCLIForIncomingCallWidth;
	}
	
	public String getSwapExtOrCLIForIncomingCallFormat()
	{
		String swapExtOrCLIForIncomingCallFormat = pro.getProperty("swapExtOrCLIForIncomingCallFormat");
		return swapExtOrCLIForIncomingCallFormat;
	}
	
	public String getColumnDelimiterStartPosition()
	{
		String columnDelimiterStartPosition = pro.getProperty("columnDelimiterStartPosition");
		return columnDelimiterStartPosition;
	}
	
	public String getColumnDelimiterWidth()
	{
		String columnDelimiterWidth = pro.getProperty("columnDelimiterWidth");
		return columnDelimiterWidth;
	}
	
	public String getColumnDelimiterFormat()
	{
		String columnDelimiterFormat = pro.getProperty("columnDelimiterFormat");
		return columnDelimiterFormat;
	}
	
	public String getPbxName()
	{
		String pbxName = pro.getProperty("pbxName");
		return pbxName;
	}
	
	public String getPbxMasterPageURL()
	{
		String pbxMasterPageURL = pro.getProperty("pbxMasterPageURL");
		return pbxMasterPageURL;
	}
	
	public String getLocationName()
	{
		String locationName = pro.getProperty("locationName");
		return locationName;
	}
	
	public String getCdrFilePath()
	{
		String cdrFilePath = pro.getProperty("cdrFilePath");
		return cdrFilePath;
	}
	
	public String getCdrFileExtension()
	{
		String cdrFileExtension = pro.getProperty("cdrFileExtension");
		return cdrFileExtension;
	}
	
	public String getCdrDumpFilePath()
	{
		String cdrDumpFilePath = pro.getProperty("cdrDumpFilePath");
		return cdrDumpFilePath;
	}
	
	public String getlocationPropertiesPageURL()
	{
		String locationPropertiesPageURL = pro.getProperty("locationPropertiesPageURL");
		return locationPropertiesPageURL;
	}
	
	public String getCommunicationMode()
	{
		String communicationMode = pro.getProperty("communicationMode");
		return communicationMode;
	}
	
	public String getConnectionMode()
	{
		String connectionMode = pro.getProperty("connectionMode");
		return connectionMode;
	}
	
	public String getIpAddress()
	{
		String ipAddress = pro.getProperty("ipAddress");
		return ipAddress;
	}
	
	public String getIpPort()
	{
		String ipPort = pro.getProperty("ipPort");
		return ipPort;
	}
	
	public String getRetryInterval()
	{
		String retryInterval = pro.getProperty("retryInterval");
		return retryInterval;
	}
	
	public String getComPort()
	{
		String comPort = pro.getProperty("comPort");
		return comPort;
	}
	
	public String getBaudRate()
	{
		String baudRate = pro.getProperty("baudRate");
		return baudRate;
	}
	
	public String getParity()
	{
		String parity = pro.getProperty("parity");
		return parity;
	}
	
	public String getDataBit()
	{
		String dataBit = pro.getProperty("dataBit");
		return dataBit;
	}
	
	public String getStopBit()
	{
		String stopBit = pro.getProperty("stopBit");
		return stopBit;
	}
	
	public String getRolesPageURL()
	{
		String rolesPageURL = pro.getProperty("rolesPageURL");
		return rolesPageURL;
	}
	
	public String getRoleName()
	{
		String roleName = pro.getProperty("roleName");
		return roleName;
	}
	
	public String getAddBillingClassSnackbar()
	{
		String addBillingClassSnackbar = pro.getProperty("addBillingClassSnackbar");
		return addBillingClassSnackbar;
	}
	
	public String getAddBillingExceptionSnackbar()
	{
		String addBillingExceptionSnackbar = pro.getProperty("addBillingExceptionSnackbar");
		return addBillingExceptionSnackbar;
	}
	
	public String getAddLocationPropertiesSnackbar()
	{
		String addLocationPropertiesSnackbar = pro.getProperty("addLocationPropertiesSnackbar");
		return addLocationPropertiesSnackbar;
	}
	
	public String getAddPbxSnackbar()
	{
		String addPbxSnackbar = pro.getProperty("addPbxSnackbar");
		return addPbxSnackbar;
	}
	
	public String getAddRolesSnackbar()
	{
		String addRolesSnackbar = pro.getProperty("addRolesSnackbar");
		return addRolesSnackbar;
	}
	
	public String getDeleteBillingClassSnackbar()
	{
		String deleteBillingClassSnackbar = pro.getProperty("deleteBillingClassSnackbar");
		return deleteBillingClassSnackbar;
	}
	
	public String getDeleteBillingExceptionSnackbar()
	{
		String deleteBillingExceptionSnackbar = pro.getProperty("deleteBillingExceptionSnackbar");
		return deleteBillingExceptionSnackbar;
	}
	
	public String getDeleteLocationPropertiesSnackbar()
	{
		String deleteLocationPropertiesSnackbar = pro.getProperty("deleteLocationPropertiesSnackbar");
		return deleteLocationPropertiesSnackbar;
	}
	
	public String getDeletePbxSnackbar()
	{
		String deletePbxSnackbar = pro.getProperty("deletePbxSnackbar");
		return deletePbxSnackbar;
	}
	
	public String getDeleteRegionSnackbar()
	{
		String deleteRegionSnackbar = pro.getProperty("deleteRegionSnackbar");
		return deleteRegionSnackbar;
	}
	
	public String getUpdateBillingClassSnackbar()
	{
		String updateBillingClassSnackbar = pro.getProperty("updateBillingClassSnackbar");
		return updateBillingClassSnackbar;
	}
	
	public String getupdateBillingExceptionSnackbar()
	{
		String updateBillingExceptionSnackbar = pro.getProperty("updateBillingExceptionSnackbar");
		return updateBillingExceptionSnackbar;
	}
	
	public String getUpdateLocationPropertiesSnackbar()
	{
		String updateLocationPropertiesSnackbar = pro.getProperty("updateLocationPropertiesSnackbar");
		return updateLocationPropertiesSnackbar;
	}
	
	public String getUpdatePbxSnackbar()
	{
		String updatePbxSnackbar = pro.getProperty("updatePbxSnackbar");
		return updatePbxSnackbar;
	}
	
	public String getUpdateRegionSnackbar()
	{
		String updateRegionSnackbar = pro.getProperty("updateRegionSnackbar");
		return updateRegionSnackbar;
	}
	
	public String getUpdateRolesSnackbar()
	{
		String updateRolesSnackbar = pro.getProperty("updateRolesSnackbar");
		return updateRolesSnackbar;
	}
	
	public String getDeleteRolesSnackbar()
	{
		String deleteRolesSnackbar = pro.getProperty("deleteRolesSnackbar");
		return deleteRolesSnackbar;
	}
	
	public String getUsersPageURL()
	{
		String usersPageURL = pro.getProperty("usersPageURL");
		return usersPageURL;
	}
	
	public String getAddUsersSnackbar()
	{
		String addUsersSnackbar = pro.getProperty("addUsersSnackbar");
		return addUsersSnackbar;
	}
	
	public String getUser()
	{
		String user = pro.getProperty("user");
		return user;
	}
	
	public String getDisplayName()
	{
		String displayName = pro.getProperty("displayName");
		return displayName;
	}
	
	public String getUserPassword()
	{
		String userPassword = pro.getProperty("userPassword");
		return userPassword;
	}
	
	public String getUserEmail()
	{
		String userEmail = pro.getProperty("userEmail");
		return userEmail;
	}
	
	public String getUpdateUserSnackbar()
	{
		String updateUserSnackbar = pro.getProperty("updateUserSnackbar");
		return updateUserSnackbar;
	}
	
	public String getDeleteUserSnackbar()
	{
		String deleteUserSnackbar = pro.getProperty("deleteUserSnackbar");
		return deleteUserSnackbar;
	}
	
	public String getExtensionPageURL()
	{
		String extensionPageURL = pro.getProperty("extensionPageURL");
		return extensionPageURL;
	}
	
	public String getAddExtensionSnackbar()
	{
		String addExtensionSnackbar = pro.getProperty("addExtensionSnackbar");
		return addExtensionSnackbar;
	}
	
	public String getFromExtension()
	{
		String fromExtension = pro.getProperty("fromExtension");
		return fromExtension;
	}
	
	public String getToExtension()
	{
		String toExtension = pro.getProperty("toExtension");
		return toExtension;
	}
	
	public String getExtensionUsername()
	{
		String extensionUsername = pro.getProperty("extensionUsername");
		return extensionUsername;
	}
	
	public String getTrunkName()
	{
		String trunkName = pro.getProperty("trunkName");
		return trunkName;
	}
	
	public String getSearchLocation()
	{
		String searchLocation = pro.getProperty("searchLocation");
		return searchLocation;
	}
	
	public String getSearchDirection()
	{
		String searchDirection = pro.getProperty("searchDirection");
		return searchDirection;
	}
	
	public String getSearchDuration()
	{
		String searchDuration = pro.getProperty("searchDuration");
		return searchDuration;
	}
	
	public String getSearchCallType()
	{
		String searchCallType = pro.getProperty("searchCallType");
		return searchCallType;
	}
	
	public String getSearchExtension()
	{
		String searchExtension = pro.getProperty("searchExtension");
		return searchExtension;
	}
	
	public String getSearchTrunk()
	{
		String searchTrunk = pro.getProperty("searchTrunk");
		return searchTrunk;
	}
	
	public String getSearchDialedNumber()
	{
		String searchDialedNumber = pro.getProperty("searchDialedNumber");
		return searchDialedNumber;
	}
	
	public String getFromDate()
	{
		String fromDate = pro.getProperty("fromDate");
		return fromDate;
	}
	
	public String getToDate()
	{
		String toDate = pro.getProperty("toDate");
		return toDate;
	}
}
