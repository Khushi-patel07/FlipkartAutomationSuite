package com.MyExitTest.tests;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyExitTest.pages.OtherOptionsPage;
import com.MyExitTest.utils.CommonUtils;

public class OtherOptionsTest extends BaseTest {

	private static Logger logger = LogManager.getLogger();//logger
	private static String sheetName = properties.getProperty("SheetName");// for getting sheetname from config.properties file

	@Test(priority = 9, groups = { "sanity", "invalid" })
	public void Exploreplus() throws InterruptedException {

		String testname = "Exploreplus";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage explore = new OtherOptionsPage(driver);
		explore.CloseButton();
		explore.FlipkartPlus();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart Plus – The Ultimate Rewards Program for Flipkart Customers | Flipkart.com");
		logger.info("Flipkart PLUS page opened");
	}

	@Test(priority = 10, groups = { "sanity", "invalid" })
	public static void HelpCenterFlipkart() throws InterruptedException {

		String testname = "HelpCenterFlipkart";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage help = new OtherOptionsPage(driver);
		help.CloseButton();
		help.helpCenter();
		Thread.sleep(2000);
		help.Issues();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");		
		logger.info("Flipkart Help Center | 24x7 Customer Care Support opened");
	}

	@Test(priority = 11, groups = { "sanity", "invalid" })
	public static void TopOffers() throws InterruptedException {

		String testname = "TopOffers";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.TopOffers();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart Offers & Deals of the Day - Get Best Discounts on Mobiles, Electronics, Fashion & Home etc.");
		logger.info("Flipkart TOPOFFERS page opened");
	}

	@Test(priority = 12, groups = { "sanity", "invalid" })
	public static void Advertise() throws InterruptedException {

		String testname = "Advertise";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.Advertise();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart Brand Health, Brand Pulse, Flipkart Insights, Flipkart Advertising, Commerce Advertising Platform");
		logger.info("Flipkart ADVERTISING page opened");
	}

	@Test(priority = 13, groups = { "sanity", "invalid" })
	public static void BecomeASeller() throws InterruptedException {

		String testname = "BecomeASeller";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
	 	OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.BecomeASeller();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Sell Online on Flipkart | Grow your business with the leader in Indian e-commerce");
		logger.info("Flipkart SELLER page opened");
	}

	@Test(priority = 14, groups = { "sanity", "invalid" })
	public static void FlipkartYoutube() throws InterruptedException {

		String testname = "FlipkartYoutube";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file 
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.FlipkartYoutube();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart - YouTube");
		logger.info("Flipkart YOUTUBE channel page opened");
	}

	@Test(priority = 15, groups = { "sanity", "invalid" })
	public static void ContactUs() throws InterruptedException {

		String testname = "ContactUs";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.ContactUs();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
		logger.info("Flipkart CONTACT US page opened");
	}

	@Test(priority = 16, groups = { "sanity", "invalid" })
	public static void AboutUs() throws InterruptedException {

		String testname = "AboutUs";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.AboutUs();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : About Us");
		logger.info("Flipkart ABOUT US page opened");
	}

	@Test(priority = 17, groups = { "sanity", "invalid" })
	public static void NotificationPreferences() throws InterruptedException {

		String testname = "NotificationPreferences";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		Thread.sleep(2000);
		options.MoreOPtion();
		Thread.sleep(2000);
		options.NotificationPreference();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Push Store Online - Buy Push Online at Best Price in India | Flipkart.com");
		logger.info("Flipkart NOTIFICATION PREFERENCES page opened");
	}

	@Test(priority = 18, groups = { "sanity", "invalid" })
	public static void DownloadApp() throws InterruptedException {

		String testname = "DownloadApp";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.MoreOPtion();
		options.DownloadApp();
		Thread.sleep(2000);
		options.Download();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart Online Shopping App - Apps on Google Play");
		logger.info("Flipkart ABOUT US page opened");
	}

	@Test(priority = 19, groups = { "sanity", "invalid" })
	public static void GiftCards() throws InterruptedException {

		String testname = "GiftCards";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.GiftCard();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart Gift Cards: Buy Gift Cards & Gift Vouchers Online | Great Offers & Top Brands | Flipkart.com");
		logger.info("Flipkart GIFT CARDS page opened");
	}

	@Test(priority = 20, groups = { "sanity", "invalid" })
	public static void Facebook() throws InterruptedException {

		String testname = "Facebook";

        // Fetching all test data from excel file
        HashMap<String, String> testData = new HashMap<String, String>();
        testData = reader.getRowTestData(sheetName, testname);
        String executionRequired = testData.get("Execution Required").toLowerCase();
        String expectedTitle = testData.get("Expected Title");

        // log all data from excel file
        CommonUtils.logTestData(sheetName, testname);

        // if execution required field is no or empty
        CommonUtils.toCheckExecutionRequired(executionRequired);
        
        // create OtherOptionsPage object
		OtherOptionsPage options = new OtherOptionsPage(driver);
		options.CloseButton();
		options.Facebook();
		Thread.sleep(2000);
		
		// get actual title of the page
		String actualTitle = driver.getTitle().toLowerCase();
		// assertion:check that actual and expected title are equal
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()), "Assertion on actual and expected title");
		logger.info("Actual Title : Flipkart - Home | Facebook");
		logger.info("Flipkart FACEBOOK page opened");
	}
}
