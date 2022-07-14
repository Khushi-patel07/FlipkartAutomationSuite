package com.MyExitTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TravelPage {

	WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public TravelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "//img[@alt='Travel']")
	public WebElement travel;

	@FindBy(how = How.XPATH, using = "//input[@name='0-departcity']")
	public WebElement from;

	@FindBy(how = How.XPATH, using = "//input[@name='0-arrivalcity']")
	public WebElement to;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='SEARCH']")
	public WebElement search;

	// Method that performs action using the web elements
	public void Travel() {
		travel.click();
	}

	public void From(String From) {
		from.sendKeys(From);

	}

	public void To(String To) {
		to.sendKeys(To);

	}

	public void Search() {
		search.click();

	}
}
