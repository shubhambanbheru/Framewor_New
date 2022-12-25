package com.framework.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.pages.BaseClass;
import com.framework.pages.Loginpage;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class LoginToGuru extends BaseClass {

	@Test
	public void loginPage() {

//	 Loginpage lp =new Loginpage(driver);
//	 lp.logintoguru(useridapp, passapp);
		
		// or
		
		logger =report.createTest("Login to Guru");
		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting web");
		loginpage.logintoguru(excel.getStringData("Sheet1", 1, 0), excel.getStringData("Sheet1", 1, 0));

		logger.pass("login successful");
		
	}
	
	
	}
	

