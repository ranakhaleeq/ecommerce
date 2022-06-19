package com.ecommerce.testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.utilities.ReadConfig;

//import com.ecommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass { 
	 
	WebDriver driver; 
	
	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getBaseURL();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) { 
		
		if(browser.equals("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(baseUrl);
		}
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}
		
		driver.manage().window().maximize();
		
	}
	
	 
}
