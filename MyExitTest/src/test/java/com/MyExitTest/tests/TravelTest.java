package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyExitTest.pages.TravelPage;
import com.MyExitTest.utils.CommonUtils;

public class TravelTest extends BaseTest {

	private static Logger logger = LogManager.getLogger();//logger
	private static String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file

	@Test(priority = 8, groups = { "sanity", "invalid" })
	public static void Travel() throws InterruptedException {
		
		String testname = "Travel";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String from = testData.get("Flight From");
        String to = testData.get("Flight To");
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
		LoginTest.ValidUserLoginIn();
		Thread.sleep(2000);
		 // create HomePage object
		TravelPage travel = new TravelPage(driver);
		travel.Travel();
		Thread.sleep(2000);
		travel.From(from);
		travel.To(to);
		travel.Search();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flight Booking | Book Flight Tickets at Lowest Airfare on Flipkart.com");
		logger.info("Flipkart FLIGHT BOOKING page opened");
	}
}
