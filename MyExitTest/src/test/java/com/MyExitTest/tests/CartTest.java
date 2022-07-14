package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyExitTest.pages.CartPage;
import com.MyExitTest.utils.CommonUtils;

public class CartTest extends BaseTest {

	private static Logger logger = LogManager.getLogger();// logger
	private static String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file

	@Test(priority = 5, groups = { "sanity", "invalid" })
	public static void CheckCart() throws InterruptedException {

		String testname = "CheckCart";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		CommonUtils.logTestData(sheetName, testname);

		// if execution required field is no or empty
		CommonUtils.toCheckExecutionRequired(executionRequired);

		LoginTest.ValidUserLoginIn();
		// create CartPage object
		CartPage cart = new CartPage(driver);
		cart.shoppingCart();
		Thread.sleep(2000);

		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Shopping Cart | Flipkart.com");
		logger.info("Your cart is diplayed");
	}

	@Test(priority = 6, groups = { "sanity", "invalid" })
	public void AddToCart() throws InterruptedException {

		String testname = "AddToCart";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String item = testData.get("Searchbox1");
		String expectedTitle = testData.get("Expected Title");

		// log all data from excel file
		CommonUtils.logTestData(sheetName, testname);

		// if execution required field is no or empty
		CommonUtils.toCheckExecutionRequired(executionRequired);

		LoginTest.ValidUserLoginIn();
		// create CartPage object
		CartPage cart = new CartPage(driver);
		cart.CloseButton();
		cart.enterThing(item);
		cart.Submit();
		cart.Select();
		Thread.sleep(2000);
		cart.Add();

		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info(
				"Actual Title : Mastering Selenium WebDriver 3.0: Buy Mastering Selenium WebDriver 3.0 by Collin Mark at Low Price in India | Flipkart.com");
		logger.info("Product added to cart Successful");

	}
}
