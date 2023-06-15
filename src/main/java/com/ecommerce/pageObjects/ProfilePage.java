package com.ecommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Search…']")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(xpath = "//a[normalize-space()='Settings']")
	@CacheLookup 
	WebElement btnSettings;
	
	@FindBy(id = "keyboardShortcut")
	@CacheLookup
	WebElement toggleBtnShortcuts;
	
	public void openSettings() {
		
		btnSettings.click();
	}
	
	public boolean enableShotcuts() {
		
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", toggleBtnShortcuts);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		javascriptExecutor.executeScript("arguments[0].click()", toggleBtnShortcuts);
		toggleBtnShortcuts.click();
		return false;
		
	}
	
	
	public void searchQuary(String searchQueryPart1, String searchQueryPart2) {
		
		searchField.clear();
		
		  new Actions(driver)
          .moveToElement(searchField)
          .pause(Duration.ofSeconds(1))
          .clickAndHold()
          .keyDown(Keys.SHIFT)
          .sendKeys(searchQueryPart1 + " ")
          .keyUp(Keys.SHIFT)
          .sendKeys(searchQueryPart2)
          .perform();
		
		  new Actions(driver).sendKeys(searchField, Keys.ENTER)
          .perform();
	}
}
