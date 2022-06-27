package com.ecommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatepickerPage {
	
//	WebDriver driver;
	
	public DatepickerPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='txtOnwardCalendar']")
	@CacheLookup
	WebElement btnOpenDatePicker;
	
	@FindBy(xpath = "//div[@class='clearfix rb-calendar-main']//div[@id='rb-calmiddle']//li[@id='rb-next-middle']//img")
	@CacheLookup
	WebElement btnForwardMonth;
	
	@FindBy(xpath = "//div[@class='clearfix rb-calendar-main']//div[@id='rb-calmiddle']//span[@id='rb-year']")
	@CacheLookup
	WebElement year; 
	
	@FindBy(xpath = "//div[@class='clearfix rb-calendar-main']//div[@id='rb-calmiddle']//span[@id='rb-month']")
	@CacheLookup
	WebElement month;
	
	@FindBy(xpath = "//div[@class='D120_search_container']//div[@id='rb-calmiddle']//ul[@class='rb-calendar-days']//li")
	@CacheLookup
	List<WebElement> dates;
	
	public void openDatePicker() {
		btnOpenDatePicker.click();
		
	}
	
	public boolean canGoToNextMonthAndYear() {
		return btnForwardMonth.isEnabled();
		
	}
	
	public void goToNextMonthAndYear() {
		btnForwardMonth.click();
		
	}
 
	public String getNextYear() {
		
		return year.getText();
	}
	
	public String getNextMonth() {
		
		return month.getText();
	}
	
	public List<WebElement> getDates() {
		
		return dates;
	}
}
