package com.guru.webpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru.utility.ConfigDataProvider;
import com.guru.utility.ExcelDataProvider;
import com.guru.utility.Helper;
import com.guru.utility.browserfactory;

public class baseclass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite() {
		excel =new ExcelDataProvider();
		config= new ConfigDataProvider();
		ExtentHtmlReporter extenthtml =new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/loging_"+Helper.currentdataandtime()+".html");
		report =new ExtentReports();
		report.attachReporter(extenthtml);
		
	}
	
		
	
@BeforeClass
	public void setup() {
		driver = browserfactory.startapplication(driver, config.getbrowser(), config.getURL());
		// to give driver is imp else it will throw error i.e NullPointerException
}
	
	@AfterClass
	public void teardown() {
		browserfactory.quitbrowser(driver);
	}
	@AfterMethod
	public void getscreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			try {
				logger.fail("Login failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			} catch (IOException e) {
								
			}
		
			
			
		}
		report.flush();
		
		
	}
}
