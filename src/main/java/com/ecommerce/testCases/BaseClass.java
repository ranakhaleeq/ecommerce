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
//	public String baseUrl_001 = "https://www.bing.com/?toWww=1&redig=84E37A62F9D840E1B477FC569FDE59C4";
	public String baseUrl_002 = "https://www.redbus.in/bus-tickets";
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) { 
		
		if(browser.equals("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(baseUrl_002);
		}
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(baseUrl_002);
		}
		
		driver.manage().window().maximize();
		
	}
	
	 
}
