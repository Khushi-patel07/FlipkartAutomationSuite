package com.MyExitTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchboxPage {

	WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public SearchboxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'✕')]")
	public WebElement close;

	@FindBy(how = How.XPATH, using = "//input[@title='Search for products, brands and more']")
	public WebElement searchbox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']//*[name()='svg']")
	public WebElement submitButton;

	// Method that performs action using the web elements
	public void CloseButton() {
		close.click();
	}

	public void EnterThing(String abc) {
		searchbox.sendKeys(abc);
	}

	public void Submit() {
		submitButton.click();
	}

}
