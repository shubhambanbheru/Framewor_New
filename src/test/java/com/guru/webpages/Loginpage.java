package com.guru.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver ;
	public Loginpage(WebDriver ldriver) {
//		PageFactory.initElements(driver, this);
		this.driver =ldriver;
	}
	
	@FindBy(name="uid") WebElement username;
	@FindBy(name="password 1") WebElement pass;
	@FindBy(xpath="//input[@name=\"btnLogin\"]") WebElement loginbtn;
	
	public void logincred(String userid,String password) {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		username.sendKeys(userid);
		pass.sendKeys(password);
		loginbtn.click();
		
	}
}
