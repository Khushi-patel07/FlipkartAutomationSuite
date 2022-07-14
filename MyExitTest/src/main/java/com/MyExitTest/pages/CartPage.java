package com.MyExitTest.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Cart']")
	public WebElement Cart;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'✕')]")
	public WebElement close;

	@FindBy(how = How.XPATH, using = "//input[@title='Search for products, brands and more']")
	public WebElement searchbox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']//*[name()='svg']")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")
	public WebElement Book;

	@FindBy(how = How.XPATH, using = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement Addtocart;

	// Method that performs action using the web elements
	public void shoppingCart() throws InterruptedException {
		// to handle stale element
		try {
			Cart.click();
		} catch (StaleElementReferenceException e) {
			Cart = driver.findElement(By.xpath("//span[normalize-space()='Cart']"));
			Cart.click();
		}
		Thread.sleep(2000);
	}

	public void CloseButton() {
		close.click();
	}

	public void enterThing(String abc) {
		searchbox.sendKeys(abc);
	}

	public void Submit() throws InterruptedException {
		// to handle stale element
		try {
			submitButton.click();
		} catch (StaleElementReferenceException e) {
			submitButton = driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']"));
			submitButton.click();
		}
		Thread.sleep(2000);
	}

	public void Select() {
		Book.click();
	}

	public void Add() {
		// to switch on next window
		String mainWindowHandle = driver.getWindowHandle();// currentpage
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Length of window " + handles.size());
		for (String page : handles) {
			if (!page.contains(mainWindowHandle)) {
				driver.switchTo().window(page);
				System.out.println("New Window " + driver.getTitle());
			} else {
				driver.switchTo().window(mainWindowHandle).close();
			}

		}

		Addtocart.click();
	}

}
