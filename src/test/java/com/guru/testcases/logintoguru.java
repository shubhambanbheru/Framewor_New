package com.guru.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.guru.utility.browserfactory;
import com.guru.webpages.Loginpage;
import com.guru.webpages.baseclass;

public class logintoguru extends baseclass {

	@Test
	public void loginpage1() {

		logger = report.createTest("Login Test");
		Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting app");
		loginpage.logincred(excel.getStringdata("Sheet1", 1, 0), excel.getStringdata("Sheet1", 1, 1));
		logger.pass("login successful");
	}

}
