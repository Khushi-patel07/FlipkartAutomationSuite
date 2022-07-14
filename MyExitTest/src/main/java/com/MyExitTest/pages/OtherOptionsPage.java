package com.MyExitTest.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OtherOptionsPage {

	WebDriver driver;
	Actions action;

	// Constructor, as every page needs a Webdriver to find elements
	public OtherOptionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
	}

	// finding different elements of webpage
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'✕')]")
	public WebElement close;

	@FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[2]")
	public WebElement explorePlus;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Help Center']")
	public WebElement helpcenter;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")
	public WebElement helpwithyourissues;

	@FindBy(how = How.XPATH, using = "//img[@alt='Top Offers']")
	public WebElement topOffers;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Advertise']")
	public WebElement advertise;

	@FindBy(how = How.XPATH, using = "//span[@class='hDTmm5'][normalize-space()='Become a Seller']")
	public WebElement becomeaseller;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='YouTube']")
	public WebElement youtube;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Contact Us']")
	public WebElement contactus;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='About Us']")
	public WebElement aboutus;

	@FindBy(how = How.XPATH, using = "//div[@class='exehdJ']")
	public WebElement moreoption;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]")
	public WebElement notificationpreferences;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]/div[1]")
	public WebElement downloadapp;

	@FindBy(how = How.XPATH, using = "//img[@class='_3HURxL']")
	public WebElement googleplay;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Gift Cards']")
	public WebElement giftcards;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Facebook']")
	public WebElement facebook;

	// Method that performs action using the web elements
	public void CloseButton() {
		close.click();
	}

	public void FlipkartPlus() {
		explorePlus.click();
	}

	public void helpCenter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)", helpcenter);
		// to handle stale element
		try {
			helpcenter.click();
		} catch (StaleElementReferenceException e) {
			helpcenter = driver.findElement(By.xpath("//span[normalize-space()='Help Center']"));
			helpcenter.click();
		}
		Thread.sleep(2000);

	}

	public void Issues() {
		helpwithyourissues.click();
	}

	public void TopOffers() throws InterruptedException {
		// to handle stale element
		try {
			topOffers.click();
		} catch (StaleElementReferenceException e) {
			topOffers = driver.findElement(By.xpath("//img[@title='Flipkart']"));
			topOffers.click();
		}
		Thread.sleep(2000);
	}

	public void Advertise() {
		advertise.click();
	}

	public void BecomeASeller() {
		becomeaseller.click();
	}

	public void FlipkartYoutube() {
		youtube.click();
	}

	public void ContactUs() {
		contactus.click();
	}

	public void AboutUs() {
		aboutus.click();
	}

	public void MoreOPtion() {
		moreoption.click();
	}

	public void NotificationPreference() {
		// perform mouse hover action on the web element and perform action
		action.moveToElement(moreoption).perform();
		action.moveToElement(notificationpreferences).perform();
		notificationpreferences.click();
	}

	public void DownloadApp() {
		// perform mouse hover action on the web element and perform action
		action.moveToElement(moreoption).perform();
		action.moveToElement(downloadapp).perform();
		downloadapp.click();
	}

	public void Download() {
		googleplay.click();
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
	}

	public void GiftCard() {
		giftcards.click();
	}

	public void Facebook() {
		facebook.click();
	}
}
