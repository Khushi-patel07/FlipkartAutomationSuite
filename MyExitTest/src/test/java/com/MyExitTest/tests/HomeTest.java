package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyExitTest.pages.HomePage;
import com.MyExitTest.utils.CommonUtils;

public class HomeTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(); //logger
	private String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file

	@Test(priority = 4, groups = { "sanity", "invalid" })
	public void FlipkartHome() throws InterruptedException {
		
		String testname = "FlipkartHome";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create HomePage object
		HomePage home = new HomePage(driver);
		home.Element();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.info("Flipkart homePage opened");
	}
}
