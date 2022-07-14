package com.MyExitTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div/div[1]/div[1]/div[1]")
	public WebElement element;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'✕')]")
	public WebElement close;

	// Method that performs action using the web elements
	public void Element() {
		close.click();
		element.click();
	}

}
