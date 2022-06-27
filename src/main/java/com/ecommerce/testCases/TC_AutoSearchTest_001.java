package com.ecommerce.testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.AutoSearchPage;

public class TC_AutoSearchTest_001 extends BaseClass{
	
	@Test(enabled = false)
	public void AutoSearchTest() throws InterruptedException {
		
		AutoSearchPage autoSearchPage = new AutoSearchPage(driver);
		autoSearchPage.setSearchQuery("selenium"); 
		
		Thread.sleep(3000);
		
		System.out.println(autoSearchPage.getSuggestionList().size() + "   -----------------");
	
		for(WebElement ele : autoSearchPage.getSuggestionList()) {
			
			System.out.println(ele.getText());
			if(ele.getText().contains("testing")) {
				
				ele.click();
				break;
			}
		}
	
	}
	
}
   