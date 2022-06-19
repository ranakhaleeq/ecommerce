package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoSearchPage {

	public AutoSearchPage(WebDriver driver){
	
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//input[contains(@title,'Search')]")
	@CacheLookup
	WebElement searchBar;
	
	public void setSearchQuery(String searchText) {
		
		searchBar.sendKeys(searchText); 
	}
	
}
