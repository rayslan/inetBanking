package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.BaseClass;
import com.inetbanking.utilities.Driver;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginTest_001 extends BaseClass{
	

	
	@Test
	public void loginTest() {
		
		test=extent.createTest("ebankin test");
		
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.setUsername("mngr248715");
		test.log(Status.PASS, "ne biliiim");
		logger.info("Entered user name");
		loginPage.setPassword("esejedE");
		logger.info("Entered the password");
		loginPage.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		logger.info("Test passed, bro");
	}

}
