package com.ecommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.pageObjects.ProfilePage;
import com.ecommerce.utilities.XLUtility;


public class Login_TC_001 extends Setup implements IExecutionListener{ //, ITestListener  implements IInvokedMethodListener 
	
	public LoginPage signPage;
	public HomePage homePage;
	public ProfilePage profilePage;
	
	@Test(enabled = true, priority = 1)
	public void login() {
		
		signPage = new LoginPage(driver);
		
		signPage.setUserName("rehmanranahous@gmail.com");
		signPage.setPassword("Asdfg098@");
		signPage.clickLoginBtn();
	} 
	
	@Test(priority = 2, dependsOnMethods = {"login"})
	public void visitProfile() {
		
		homePage = new HomePage(driver);
		
		Assert.assertEquals(true, homePage.profileBtnVisible()); 
		homePage.goToProfile();
		homePage.rejectCookies();
	}
	
	@Test(priority = 3, dependsOnMethods = {"visitProfile"})
	public void searchQuery() {
		
		profilePage = new ProfilePage(driver);
//		profilePage.searchQuary("java", "selenium");
	} 
	
	@Test(priority = 4, dependsOnMethods = {"visitProfile"} )
	public void enableShotcuts(){
		
		profilePage.openSettings();
		homePage.rejectCookies();
		Assert.assertTrue(profilePage.enableShotcuts());
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("alert('Keyboard Shortcuts Enabled')");
		driver.switchTo().alert().accept(); 

	}

	
	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException {
		
		String path = "C:/Users/dell/eclipse-workspace/data/E-Commerce/dataFiles/loginData.xlsx";
		
		XLUtility xlUtility = new XLUtility(path);
		
		int totalRows = xlUtility.getRowCount("login");
		int totalCols = xlUtility.getCellCount("login", 1);
		
		String loginData[][] = new String[totalRows][totalCols]; 
		
		for(int i=1; i<=totalRows; i++) //1
		{
			for(int j=0; j<totalCols; j++) //0
			{
				loginData[i-1][j] = xlUtility.getCellData("login", i, j);
			}
				
		}
		
		return loginData;
	}

	@Override
	public void onExecutionFinish() {
		
		LocalDateTime endTime= LocalDateTime.now();
		System.out.println("Inform all the suite have finished execution at "+ endTime.toString());
	}
	
	@Override
	public void onExecutionStart() {
		
		LocalDateTime endTime= LocalDateTime.now();
		System.out.println("Inform all the suite starts execution at "+ endTime.toString());
	}
	
//	@Override
//		public void onTestFailure(ITestResult result) {
//			// TODO Auto-generated method stub
////			ITestListener.super.onTestFailure(result);
//		
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//		File desFile = new File("C:/Users/dell/eclipse-workspace/data/E-Commerce/screenshots");
//		
//		try {
//			FileUtils.copyFile(srcFile, desFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}
	
}
