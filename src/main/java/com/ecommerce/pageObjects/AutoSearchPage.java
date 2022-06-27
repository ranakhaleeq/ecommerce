package com.ecommerce.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoSearchPage {

	WebDriver driver;
	
	public AutoSearchPage(WebDriver driver){
	
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//input[@id='sb_form_q']")
	@CacheLookup
	WebElement searchBar;
	
	@FindBy(xpath = "//li[@class='sa_sg']")
	@CacheLookup
	List<WebElement> suggestionList;
	
	public void setSearchQuery(String searchText) {

		searchBar.sendKeys(searchText);   
	} 
	
	public List<WebElement> getSuggestionList() {
		
		return suggestionList;
		
	}
	
}
