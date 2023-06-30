package com.ecommerce.testCases;

import java.io.File; 
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.pageObjects.ProfilePage;

public class Profile_TC_002 extends Setup implements IInvokedMethodListener, ITestListener{
	
	public LoginPage signinPage;
	public ProfilePage profilePage;
	public HomePage homePage;
	
	@Test(priority = 1)
	public void loginTest() {
		
		signinPage = new LoginPage(driver);
		
		signinPage.setUserName("rehmanranahouse@gmail.com");
		signinPage.setPassword("Asdfg098@");
		signinPage.clickLoginBtn();
	}
	
	@Test(priority = 2)
	public void visitProfile() {
		
		homePage = new HomePage(driver);
		
		Assert.assertEquals(true, homePage.profileBtnVisible()); 
		homePage.goToProfile();
		homePage.rejectCookies();
	}
	
	@Test(priority = 3, dependsOnMethods = {"visitProfile"} )
	public void enableShotcuts(){
		
		profilePage = new ProfilePage(driver);
		profilePage.openSettings();
		homePage.rejectCookies();
		
		//Assertion
		Assert.assertTrue(profilePage.enableShotcuts());
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("alert('Keyboard Shortcuts Enabled')");
		driver.switchTo().alert().accept(); 
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		//IInvokedMethodListener.super.afterInvocation(method, testResult);
		System.out.println(method.toString());
	}
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		//IInvokedMethodListener.super.beforeInvocation(method, testResult);
		System.out.println(method.toString());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		
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
		
	}
	
}
