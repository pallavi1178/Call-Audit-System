package com.telesoftlabs.CallAudit;

import java.util.logging.Logger;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.telesoftlabs.pageObjects.AddUser;
import com.telesoftlabs.testCases.BaseClass;
import com.telesoftlabs.testCases.LoggingSetup;
import com.telesoftlabs.testCases.Tc_AddBillingClass;
import com.telesoftlabs.testCases.Tc_AddBillingException;
import com.telesoftlabs.testCases.Tc_AddExtension;
import com.telesoftlabs.testCases.Tc_AddLocationProperties;
import com.telesoftlabs.testCases.Tc_AddPBX;
import com.telesoftlabs.testCases.Tc_AddRegion;
import com.telesoftlabs.testCases.Tc_AddRoles;
import com.telesoftlabs.testCases.Tc_AddUser;
import com.telesoftlabs.testCases.Tc_Dashboard;
import com.telesoftlabs.testCases.Tc_DeleteBillingClass;
import com.telesoftlabs.testCases.Tc_DeleteBillingException;
import com.telesoftlabs.testCases.Tc_DeleteExtension;
import com.telesoftlabs.testCases.Tc_DeleteLocationProperties;
import com.telesoftlabs.testCases.Tc_DeletePBX;
import com.telesoftlabs.testCases.Tc_DeleteRegion;
import com.telesoftlabs.testCases.Tc_DeleteRoles;
import com.telesoftlabs.testCases.Tc_DeleteUser;
import com.telesoftlabs.testCases.Tc_ExportExtensions;
import com.telesoftlabs.testCases.Tc_ImportExtension;
import com.telesoftlabs.testCases.Tc_LatestCDR;
import com.telesoftlabs.testCases.Tc_Login;
import com.telesoftlabs.testCases.Tc_ReportsValidation;
import com.telesoftlabs.testCases.Tc_SearchPage;
import com.telesoftlabs.testCases.Tc_UpdateBillingClass;
import com.telesoftlabs.testCases.Tc_UpdateBillingException;
import com.telesoftlabs.testCases.Tc_UpdateExtension;
import com.telesoftlabs.testCases.Tc_UpdateLocationProperties;
import com.telesoftlabs.testCases.Tc_UpdatePBX;
import com.telesoftlabs.testCases.Tc_UpdateRegion;
import com.telesoftlabs.testCases.Tc_UpdateRoles;
import com.telesoftlabs.testCases.Tc_UpdateUser;


public class TelesuiteCallAuditApplication extends BaseClass 
{
	
	Tc_Login tc_Login;
	Tc_AddRegion addRegion;
	Tc_AddBillingClass addBillingClass;
	Tc_AddBillingException addBillingException;
	Tc_AddPBX addPBX;
	Tc_AddLocationProperties addLocation;
	Tc_DeleteLocationProperties deleteProperties;
	Tc_DeletePBX deletePBX;
	Tc_DeleteRegion deleteRegion;
	Tc_DeleteBillingClass deleteBillingClass;
	Tc_DeleteBillingException deleteBillingException;
	Tc_UpdateRegion updateRegion;
	Tc_UpdateBillingClass updateBillingClass;
	Tc_UpdateBillingException updateBillingException;
	Tc_UpdatePBX updatePBX;
	Tc_UpdateLocationProperties updateLocationProperties;
	Tc_AddRoles addRoles;
	Tc_UpdateRoles updateRoles;
	Tc_DeleteRoles deleteRoles;
	Tc_AddUser addUser;
	Tc_UpdateUser updateUser;
	Tc_DeleteUser deleteUser;
	Tc_LatestCDR latest;
	Tc_AddExtension addExtension;
	Tc_UpdateExtension updateExtension;
	Tc_DeleteExtension deleteExtension;
    Tc_ImportExtension importExt;
    Tc_ExportExtensions exportExt;
    Tc_ReportsValidation report;
    Tc_SearchPage search;
    Tc_Dashboard dashboard;
	private static final Logger logger = Logger.getLogger(TelesuiteCallAuditApplication.class.getName());
	static
	{
		LoggingSetup.configureLogger();
	}

	SoftAssert softAssert = new SoftAssert();
	
	/***************Login******************/
	//@Test(priority = 1, dataProvider = "loginData", dataProviderClass = BaseClass.class)   public void login(String username, String password)
	@Test(priority = 1)
	public void login() throws InterruptedException
	{	
		try {
			tc_Login = new Tc_Login();
			tc_Login.login(username, password);
		} catch (Exception e) {
			logger.severe("Exception while Login....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Login....:( "+ e.getClass() +" "+ e.getMessage());
		}
		finally {
			softAssert.assertAll();
		}
	}
	
	@Test(priority = 2)
	public void addRegion()
	{
		try {
			addRegion = new Tc_AddRegion();
			addRegion.addRegion();
		} catch (Exception e) {
			logger.severe("Exception while Adding Region....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Region....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void addBillingClass()
	{
		try {
			addBillingClass = new Tc_AddBillingClass();
			addBillingClass.addBillingClass();
		} catch (Exception e) {
			logger.severe("Exception while Adding Billing Class....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Billing Class....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 4)
	public void addBillingException()
	{
		try {
			addBillingException = new Tc_AddBillingException();
			addBillingException.addBillingException();
		} catch (Exception e) {
			logger.severe("Exception while Adding Billing Exception....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Billing Exception....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 5)
	public void addPBX()
	{
		try {
			addPBX = new Tc_AddPBX();
			addPBX.addPBX();
		} catch (Exception e) {
			logger.severe("Exception while Adding PBX....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding PBX....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 6)
	public void addLocationProperties()
	{
		try {
			addLocation = new Tc_AddLocationProperties();
			addLocation.addLocationProperties();
		} catch (Exception e) {
			logger.severe("Exception while Adding Location Properties....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Location Properties....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 7)
	public void addRoles()
	{
		try {
			addRoles = new Tc_AddRoles();
			addRoles.addRoles();
		} catch (Exception e) {
			logger.severe("Exception while Adding Roles....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Roles....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 8)
	public void addUser()
	{
		try {
			addUser = new Tc_AddUser();
			addUser.addUser();
		} catch (Exception e) {
			logger.severe("Exception while Adding Users....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Users....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 9)
	public void addExtension()
	{
		try {
			addExtension = new Tc_AddExtension();
			addExtension.addExtension();
		} catch (Exception e) {
			logger.severe("Exception while Adding Extension....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Adding Extension....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 10)
	public void latestCdr()
	{
		try {
			latest = new Tc_LatestCDR();
			latest.latestCdr();
		} catch (Exception e) {
			logger.severe("Exception while Handling Latest CDR....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Handling Latest CDR....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 11)
	public void search()
	{
		try {
			search = new Tc_SearchPage();
			search.verifySearchFunctionality();
		} catch (Exception e) {
			logger.severe("Exception while Handling Search....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Handling Search....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 12)
	public void reports()
	{
		try {
			report = new Tc_ReportsValidation();
			report.validateAllReports();
		} catch (Exception e) {
			logger.severe("Exception while Handling Reports....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Handling Reports....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 13)
	public void updateUser()
	{
		try {
			Thread.sleep(500);
			updateUser = new Tc_UpdateUser();
			updateUser.updateUser();
		} catch (Exception e) {
			logger.severe("Exception while Updating Users....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating Users....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	
	@Test(priority = 14)
	public void updateRoles()
	{
		try {
			updateRoles = new Tc_UpdateRoles();
			updateRoles.updateRoles();
		} catch (Exception e) {
			logger.severe("Exception while Updating Roles....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating Roles....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 15)
	public void UpdateRegion()
	{
		try {
			updateRegion = new Tc_UpdateRegion();
			updateRegion.updateRegion();
		} catch (Exception e) {
			logger.severe("Exception while Updating Region....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating Region....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 16)
	public void UpdateBillingClass()
	{
		try {
			updateBillingClass = new Tc_UpdateBillingClass();
			updateBillingClass.updateBillingClass();
		} catch (Exception e) {
			logger.severe("Exception while Updating BillingClass....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating BillingClass....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 17)
	public void UpdateBillingException()
	{
		try {
			updateBillingException = new Tc_UpdateBillingException();
			updateBillingException.UpdateBillingException();
		} catch (Exception e) {
			logger.severe("Exception while Updating BillingException....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating BillingException....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 18)
	public void UpdatePBX()
	{
		try {
			updatePBX = new Tc_UpdatePBX();
			updatePBX.updatePBX();
		} catch (Exception e) {
			logger.severe("Exception while Updating PBX....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating PBX....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
		
	@Test(priority = 19)
	public void UpdateExtension()
	{
		try {
			updateExtension = new Tc_UpdateExtension();
			updateExtension.searchAndUpdateExtension();
		} catch (Exception e) {
			logger.severe("Exception while Updating Extension....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating Extension....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 20)
	public void UpdateLocationProperties()
	{
		try {
			updateLocationProperties = new Tc_UpdateLocationProperties();
			updateLocationProperties.updateLocationProperties();
		} catch (Exception e) {
			logger.severe("Exception while Updating LocationProperties....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Updating LocationProperties....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}	
	
	@Test(priority = 21)
	public void importExtension()
	{
		try {
			importExt = new Tc_ImportExtension();
			importExt.importExtensions();
		} catch (Exception e) {
			logger.severe("Exception while Importing Extensions....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Importing Extensions....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
		
	@Test(priority = 22)
	public void exportExtension()
	{
		try {
			exportExt = new Tc_ExportExtensions();
			exportExt.exportExtensions();
		} catch (Exception e) {
			logger.severe("Exception while Exporting Extensions....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Exporting Extensions....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 23)
	public void deleteUser()
	{
		try {
			deleteUser = new Tc_DeleteUser();
			deleteUser.deleteUser();
		} catch (Exception e) {
			logger.severe("Exception while Deleting User....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting User....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 24)
	public void deleteExtension()
	{
		try {
			deleteExtension = new Tc_DeleteExtension();
			deleteExtension.searchAndDeleteExtension();
		} catch (Exception e) {
			logger.severe("Exception while Deleting Extension....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting Extension....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 25)
	public void deleteLocationProperties()
	{
		try {
			deleteProperties = new Tc_DeleteLocationProperties();
			deleteProperties.deleteLocationProperties();
		} catch (Exception e) {
			logger.severe("Exception while Deleting Location Properties....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting Location Properties....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 26)
	public void deletePBX()
	{
		try {
			deletePBX = new Tc_DeletePBX();
			deletePBX.deletePBX();
		} catch (Exception e) {
			logger.severe("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 27)
	public void deleteRegion()
	{
		try {
			deleteRegion = new Tc_DeleteRegion();
			deleteRegion.deleteRegion();
		} catch (Exception e) {
			logger.severe("Exception while Deleting Region....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting Region....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 28)
	public void deleteBillingClass()
	{
		try {
			deleteBillingClass = new Tc_DeleteBillingClass();
			deleteBillingClass.deleteBillingClass();
		} catch (Exception e) {
			logger.severe("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 29)
	public void deleteBillingException()
	{
		try {
			deleteBillingException = new Tc_DeleteBillingException();
			deleteBillingException.deleteBillingException();
		} catch (Exception e) {
			logger.severe("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting PBX....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 30)
	public void deleteRoles()
	{
		try {
			deleteRoles = new Tc_DeleteRoles();
			deleteRoles.deleteRoles();
		} catch (Exception e) {
			logger.severe("Exception while Deleting Roles....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Deleting Roles....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
	
	@Test(priority = 31)
	public void dashboard()
	{
		try {
			dashboard = new Tc_Dashboard();
			dashboard.validateTodayAnalysis();
			dashboard.validateThisMonthAnalysis();
			dashboard.validateDateBetweenAnalysis();
		} catch (Exception e) {
			logger.severe("Exception while Validating Dashboard....:( "+ e.getClass() +" "+ e.getMessage());
			extentTest.fail("Exception while Validating Dashboard....:( "+ e.getClass() +" "+ e.getMessage());
		}
	}
}
