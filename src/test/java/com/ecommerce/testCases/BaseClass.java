package com.ecommerce.testCases;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.utilities.ReadConfig;

//import com.ecommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass { 
	 
	WebDriver driver; 
	
//	ReadConfig readConfig = new ReadConfig();
	//public String baseUrl_001 = "https://social-dev.traderverse.io/login";
//	public String baseUrl_002 = "";
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setup(String browser, String url) { 
		
		if(browser.equals("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(getChromeOptions());
			
			if(url.equals("no link available"))
				driver.get("");
			else
				driver.get(url);
		}
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		
	}
	
	public ChromeOptions getChromeOptions() {
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();
		    
		// set ExperimentalOption - prefs
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);
		
		return options;
	}
	

	
	 
}
