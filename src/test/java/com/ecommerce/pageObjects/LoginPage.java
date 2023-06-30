package com.ecommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;
	public WebDriverWait webDriverWait;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@FindBy(id = "email")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(id = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(id = "submit-button")
	@CacheLookup
	WebElement btnLogin;


	public void setUserName(String userName) {

		txtUserName.clear();
		txtUserName.sendKeys(userName);
	}

	public void setPassword(String password) {

		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLoginBtn() {

		btnLogin.click();
	}
}
