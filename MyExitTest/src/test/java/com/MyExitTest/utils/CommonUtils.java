package com.MyExitTest.utils;

import java.util.HashMap;
import com.MyExitTest.tests.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;

public class CommonUtils extends BaseTest{
	
	private static Logger logger = LogManager.getLogger();
	
	// Show Test Data
	public static void logTestData(String worksheetName, String testCaseName) {
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(worksheetName, testCaseName);

		// Print all data
		for (HashMap.Entry<String, String> entry : testData.entrySet()) {
			if(entry.getKey() != "" && entry.getValue() != "") {
				logger.info(entry.getKey() + " : " + entry.getValue().toString());
			}
		}
	}
	
	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {
		
		// if execution required field is no
		if(executionRequired.equals("no")) {
			logger.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}
		
		// if execution required field is empty
		if(executionRequired.equals("")) {
			logger.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}
}
