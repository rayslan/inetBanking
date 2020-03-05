package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.ManagerHomePage;
import com.inetbanking.utilities.BaseClass;
import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.XlUtility;

public class TC_LoginTest_002 extends BaseClass {

	@Test
	
	public void loginDDT() throws IOException, InterruptedException {
		String path = "/Users/suvhanberdiatamyradov/eclipse-workspace/inetBankingV1/DataDriven/Workbook1.xlsx";

		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		LoginPage loginPage = new LoginPage();
		ManagerHomePage managerHomePage = new ManagerHomePage();

		for (int i = 1; i <= XlUtility.getRowCount(path, "Sheet1"); i++) {

			loginPage.setUsername(String.valueOf(XlUtility.getCellData(path, "Sheet1", i, 1)));
			loginPage.setPassword(String.valueOf(XlUtility.getCellData(path, "Sheet1", i, 2)));
			loginPage.clickLogin();
			Thread.sleep(1000);
			
			if(alertCheck()==true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(true);
				managerHomePage.logOut();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				
			}

		}
	}



	public boolean alertCheck() {
	try {
		driver.switchTo().alert();
		return true;
	}catch(Exception e) {
		return false;
	}
	}
	
	}

//	@DataProvider(name = "LoginData")
//	public String [][] getData() throws IOException{
//		
//		String path = "/Users/suvhanberdiatamyradov/eclipse-workspace/inetBankingV1/DataDriven/Workbook1.xlsx";
//		
//		int rowNum=XlUtility.getRowCount(path, "Sheet1");
//		int colNum=XlUtility.getColCount(path, "Sheet1", rowNum);
//		
//		String loginData[][]= new String [rowNum][colNum];
//		
//		for(int i=1; i<=rowNum; i++) {
//			
//			for(int j=0;j<=colNum;j++) {
//				loginData[i-1][j]=XlUtility.getCellData(path, "Sheet1", i, j);
//			}
//		}
//		return loginData;
//	}
