package com.framework.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.utility.RandomString;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath =System.getProperty("user.dir")+"/Screenshots/loginpage_"+getcurrentDateTime()+".png";

		String random = RandomString.make(4);

		try {
			org.openqa.selenium.io.FileHandler.copy(src,
					new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("Screenshots not captured>>" + e.getMessage());
		}

		return screenshotpath;
	}

	public static String getcurrentDateTime() {

		DateFormat customFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Date customdate = new Date();
		return customFormat.format(customdate);
	}

}
