package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.Driver;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(name="rad1")
	WebElement gender;

	@FindBy(name="dob")
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement phoneNumber;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	
	
	public void setName(String str) {
		customerName.sendKeys(str);
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void setDateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	public void setAddress(String str) {
		address.sendKeys(str);
	}
	
	public void setCity(String str) {
		city.sendKeys(str);
	}
	
	public void setState(String str) {
		state.sendKeys(str);
	}
	
	public void setZip(String str) {
		pin.sendKeys(str);
	}
	
	public void setPhoneNumber(String str) {
		phoneNumber.sendKeys(str);
	}
	
	public void setEmail(String str) {
		email.sendKeys(str);
	}
	
	public void setPassword(String str) {
		password.sendKeys(str);
	}
	
	public void submit() {
		btnSubmit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

