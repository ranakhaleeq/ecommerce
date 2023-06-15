package com.ecommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriverWait webDriverWait;
	public WebDriver driver;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(xpath = "//button[normalize-space()='Necessary cookies only']")
	@CacheLookup
	WebElement btnCookies;

	@FindBy(xpath = "//div[@title='Rana Khaleeq']")
	@CacheLookup
	WebElement btnProfile;

	public void rejectCookies() {
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(btnCookies));
			btnCookies.click();
		} catch (StaleElementReferenceException e) {
			// Handle the stale element exception by re-locating the element
			btnCookies = driver.findElement(By.xpath("//button[normalize-space()='Necessary cookies only']"));
			btnCookies.click();
		}

	}

	public boolean profileBtnVisible() {
		webDriverWait.until(ExpectedConditions.visibilityOf(btnProfile));
		return btnProfile.isDisplayed();
	}

	public void goToProfile() {
		btnProfile.click();
	}

}
