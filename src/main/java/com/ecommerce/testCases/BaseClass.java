package com.ecommerce.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ecommerce.utilities.ReadConfig;

public class BaseClass {
	 
	WebDriver driver; 
	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getBaseURL();
	
	@Test
	public void start() {
		
	}
}
