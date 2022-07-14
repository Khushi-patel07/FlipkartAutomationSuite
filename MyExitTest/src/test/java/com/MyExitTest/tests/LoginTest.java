package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyExitTest.pages.LoginPage;
import com.MyExitTest.utils.CommonUtils;

public class LoginTest extends BaseTest {

	private static Logger logger = LogManager.getLogger();//logger
	private static String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file
	
	@Test(priority = 1, groups = { "sanity", "invalid" })
	public static void ValidUserLoginIn() throws InterruptedException{

		String testname = "ValidUserLoginIn";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String email = testData.get("Email");
        String password = testData.get("Password");
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create LoginPage object
		LoginPage login = new LoginPage(driver);
		login.enterEmail(email);
		login.enterPass(password);
		login.Login();
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.info("Valid user login:user logged in successfully");
	}

	@Test(priority = 2, groups = { "sanity", "invalid" })
	public void InValidUserLogIn() {
		
		String testname = "InValidUserLogIn";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String invalidemail = testData.get("Invalid Email");
        String invalidpassword = testData.get("Invalid Password");
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);

        // create LoginPage object
		LoginPage login = new LoginPage(driver);
		login.enterEmail(invalidemail);
		login.enterPass(invalidpassword);
		login.Login();
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.info("Invalid user login:user not be able to login due to invalid credentials");
	}

	@Test(priority = 3, groups = { "sanity", "invalid" })
	public void BlankUserLogIn() {

		String testname = "BlankUserLogIn";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String blank = testData.get("Blank");
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
		
        // create LoginPage object
		LoginPage login = new LoginPage(driver);
		login.enterEmail(blank);
		login.enterPass(blank);
		login.Login();
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.info("Blank user login:user not be able to login due to blank credentials ");
	}
}
