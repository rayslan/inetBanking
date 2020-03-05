package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.Driver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(){
		this.driver=Driver.getDriver();
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	WebElement buttonLogin;
	
	
	public void setUsername(String str) {
		txtUserName.sendKeys(str);
	}
	
	public void setPassword(String str) {
		txtPassword.sendKeys(str);
	}
	
	public void clickLogin() {
		buttonLogin.click();
	}
	
}
