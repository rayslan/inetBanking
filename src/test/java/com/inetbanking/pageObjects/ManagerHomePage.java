package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.Driver;

public class ManagerHomePage {
	
	WebDriver driver;
	
	public ManagerHomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='Logout.php']")
	WebElement buttonLogOut;
	
	@FindBy(xpath = "//a[@href='addcustomerpage.php']")
	WebElement btnNewCustomer;
	
	public void logOut() {
		buttonLogOut.click();
	}

	public void addNewCustomer() {
		btnNewCustomer.click();
	}
}
