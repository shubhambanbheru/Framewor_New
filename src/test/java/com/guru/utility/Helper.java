package com.guru.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String capturescreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "/Screenshots/Login_" + currentdataandtime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (Exception e) {
			System.out.println("Screenshot not captured -->"+e.getMessage());
		}

		return screenshotpath;

	}

	public static String currentdataandtime() {
		DateFormat currentformat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Date currentdate = new Date();
		return currentformat.format(currentdate);
	}
}
