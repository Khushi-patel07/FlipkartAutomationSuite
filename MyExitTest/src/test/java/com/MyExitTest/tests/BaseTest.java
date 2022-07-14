package com.MyExitTest.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.MyExitTest.utils.ExcelReader;
import com.MyExitTest.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	private static Logger logger = LogManager.getLogger(); // Logger implementation
    
	static WebDriver driver;
	public static File file;
	public static FileInputStream fis;
	public static Properties properties;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	// Excel File Test Data Reader
	public static ExcelReader reader = null;

	static {
		reader = new ExcelReader("./Resources/TestData.xlsx"); // to read date from excel file
	}

	static {
		try {
			file = new File("./Resources/config.properties"); // Using config.properties file
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeSuite(groups = { "sanity", "invalid" })
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");

	}

	@AfterSuite(groups = { "sanity", "invalid" })
	public void endReport() {
		extent.flush();
		extent.close();

	}

	@BeforeMethod(groups = { "sanity", "invalid" })
	// to initialize driver
	public static void intializeDriver() {

		String driver_mode = properties.getProperty("DriverMode");
		if (driver_mode.equals("non-headless"))// To run testcases in non-headless mode
		{
			String browser_name = properties.getProperty("Browser");
			System.out.println(browser_name);
			if (browser_name.equals("chrome")) {
				// Condition for chrome driver
				System.setProperty(properties.getProperty("ChromeDriver"), properties.getProperty("ChromePath"));
				driver = new ChromeDriver();
				logger.info("----------------------------------------------------------------------");
				logger.info("Chrome browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}
			if (browser_name.equals("ie")) {
				// Condition for internet explorer driver
				System.setProperty(properties.getProperty("IEDriver"), properties.getProperty("IEPath"));
				driver = new InternetExplorerDriver();
				logger.info("----------------------------------------------------------------------");
				logger.info("InternetExplorer browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}

			if (browser_name.equals("firefox")) {
				// Condition for firefox driver
				System.setProperty(properties.getProperty("FirefoxDriver"), properties.getProperty("FirefoxPath"));
				driver = new FirefoxDriver();
				logger.info("----------------------------------------------------------------------");
				logger.info("Firefox browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}
		}

		if (driver_mode.equals("headless")) // To run test cases in headless mode
		{
			String browser_name = properties.getProperty("Browser");
			System.out.println(browser_name);
			if (browser_name.equals("chrome")) {

				System.setProperty(properties.getProperty("ChromeDriver"), properties.getProperty("ChromePath"));
				ChromeOptions options = new ChromeOptions(); // Create object of Chrome options
				options.addArguments("headless"); // Add the headless argument
				driver = new ChromeDriver(options); // Pass the options parameter in the Chrome driver declaration
				logger.info("----------------------------------------------------------------------");
				logger.info("Chrome browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}

			if (browser_name.equals("ie")) {

				System.setProperty(properties.getProperty("IEDriver"), properties.getProperty("IEPath"));
				InternetExplorerOptions options = new InternetExplorerOptions();// Create object of InternetExplorer options
				//options.addArguments("headless");// Add the headless argument
				driver = new InternetExplorerDriver();// Pass the options parameter in the InternetExplorer driver declaration
				logger.info("----------------------------------------------------------------------");
				logger.info("InternetExplorer browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}

			if (browser_name.equals("firefox")) {

				System.setProperty(properties.getProperty("FirefoxDriver"), properties.getProperty("FirefoxPath"));
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);// Set Firefox Headless mode as TRUE
				driver = new FirefoxDriver(options); // Pass the options parameter in the Firefox driver declaration
				logger.info("----------------------------------------------------------------------");
				logger.info("Firefox browser was opened successfully");
				driver.manage().window().maximize();
				String ImplicitWaitTime = properties.getProperty("ImplicitWaitTime");
			}
		}
	}

	@BeforeMethod(groups = { "sanity", "invalid" })
	public static void openUrl() {
		// Method for url
		driver.get(properties.getProperty("Url"));
		logger.info("www.flipkart.com website was opened");
	}

	@BeforeMethod(groups = { "sanity", "invalid" }) // Implementing extent report
	public void startTest(Method name) {
		String testname = name.getName();
		extentTest = extent.startTest(testname);
	}

	@AfterMethod(groups = { "sanity", "invalid" })
	public void resultTest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String imagePath = Screenshot.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(imagePath), "Test case failed");
			logger.info("Test case failed");
		} else {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test case passed successfully");
				logger.info("Test case passed ");
			}
		}
		extent.endTest(extentTest);
	}

	@AfterMethod(groups = { "sanity", "invalid" })
	public static void testclose() {
		driver.close(); // Closing the driver
		logger.info("www.flipkart.com website was closed");
		logger.info("----------------------------------------------------------------------");

	}

}
