package com.MyExitTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	public WebElement login;

	// Method that performs action using the web elements
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterPass(String pass) {
		password.sendKeys(pass);
	}

	public void Login() {
		login.click();
	}

}
