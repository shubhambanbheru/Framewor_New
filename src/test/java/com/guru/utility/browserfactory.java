package com.guru.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserfactory {
	
	public static  WebDriver startapplication(WebDriver driver,String browsername,String URL) {
		
		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("IE")) {

			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriveerServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browsername.equals("edge")) {

			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("browser is not opening");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		return driver;
	}
	
	public static WebDriver quitbrowser(WebDriver driver) {
		driver.quit();
	return driver;	
	}
	
	

}
