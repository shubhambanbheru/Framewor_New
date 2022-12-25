package com.framework.pages;

import java.io.File;
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
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.Browserfactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupsuite() {

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extenthtml = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir")) + "/Reports/loginp_" + Helper.getcurrentDateTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extenthtml);

	}

	@BeforeClass
	public void setup() {
		driver = Browserfactory.StartApplication(driver, config.getbrowser(), config.getStagingURL());
	}

	@AfterClass
	public void Teardown() {
		Browserfactory.quitbrowser(driver);
	}

	@AfterMethod
	public void getscreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();

	}
}
