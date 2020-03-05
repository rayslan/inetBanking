package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.ManagerHomePage;
import com.inetbanking.pageObjects.NewCustomerPage;
import com.inetbanking.utilities.BaseClass;
import com.inetbanking.utilities.ReadConfig;

public class TC_AddingNewCustomer_001 extends BaseClass{
	
	@Test
	public void addNewCustomer() {
		
		driver.get(ReadConfig.configFile.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginPage loginPage = new LoginPage();
		loginPage.setUsername(ReadConfig.configFile.getProperty("userId"));
		loginPage.setPassword(ReadConfig.configFile.getProperty("userPassword"));
		loginPage.clickLogin();
		
		ManagerHomePage managerHomePage= new ManagerHomePage();
		managerHomePage.addNewCustomer();
		
		NewCustomerPage newCustomerPage=new NewCustomerPage();
		newCustomerPage.setName("Aya Djorayeva");
		newCustomerPage.selectGender();
		newCustomerPage.setDateOfBirth("06", "02", "18");
		newCustomerPage.setAddress("1708 FirestCove Dr");
		newCustomerPage.setCity("MtProspect");
		newCustomerPage.setState("IL");
		newCustomerPage.setZip("600565");
		newCustomerPage.setPhoneNumber("234235");
		newCustomerPage.setEmail(randomEmail());
		newCustomerPage.setPassword("ayay123");
		
		newCustomerPage.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully !!!");
		Assert.assertTrue(res==false);
	
	}
	
	public String randomEmail() {
		String randomString=RandomStringUtils.randomAlphabetic(6);
		String randomNewEmail= randomString+"@mail.ru";
		return randomNewEmail;
	}

}
