package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyExitTest.pages.SearchboxPage;
import com.MyExitTest.utils.CommonUtils;

public class SearchboxTest extends BaseTest {

	private static Logger logger = LogManager.getLogger();//logger
	private String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file

	@Test(priority = 7, groups = { "sanity", "invalid" })
	public void Searchbox() throws InterruptedException {

		String testname = "Searchbox";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String data = testData.get("Searchbox");
		String expectedTitle = testData.get("Expected Title");

		// log all data from excel file
		CommonUtils.logTestData(sheetName, testname);

		// if execution required field is no or empty
		CommonUtils.toCheckExecutionRequired(executionRequired);

		// create SearchboxPage object
		SearchboxPage search = new SearchboxPage(driver);
		search.CloseButton();
		search.EnterThing(data);
		search.Submit();
		Thread.sleep(2000);

		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Tshirt- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		logger.info("Search for product is Successful");

	}
}
