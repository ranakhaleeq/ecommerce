package com.ecommerce.testCases;

import org.testng.annotations.Test;

import com.ecommerce.pageObjects.AutoSearchPage;

public class TC_AutoSearchTest_001 extends BaseClass{
	
	@Test
	public void AutoSearchTest() {
		
		AutoSearchPage autoSearchPage = new AutoSearchPage(driver);
		autoSearchPage.setSearchQuery("selenium"); 
	}
	
}
 