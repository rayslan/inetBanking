package com.inetbanking.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.testCases.TC_LoginTest_001;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static Logger logger =LogManager.getLogger(TC_LoginTest_001.class);
	

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

@BeforeClass
public void setUp() {
		driver=Driver.getDriver();
}



@BeforeTest
public void setExtentReport() {
	htmlReporter=new ExtentHtmlReporter("extent-report.html");
	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Functional Report");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	extent.setSystemInfo("Browser", "Chrome");

}

@AfterTest
public void endReport() {
	extent.flush();
}

@AfterClass
public void tearDown() {
	Driver.closeDriver();
}

}
