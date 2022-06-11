package com.ecommerce.testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.ecommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 
	WebDriver driver; 
//	ReadConfig readConfig = new ReadConfig();
//
//	public String baseUrl = readConfig.getBaseURL();
	
	@Test
	public void start() { 
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	 
}
