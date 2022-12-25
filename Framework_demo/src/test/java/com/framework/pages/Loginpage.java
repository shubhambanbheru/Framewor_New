package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;

	public Loginpage(WebDriver ldriver) {

//	PageFactory.initElements(driver, this); 
		// or
		this.driver = ldriver;
	}

	@FindBy(name = "uid")
	
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	WebElement loginbtn;

	public void logintoguru(String useridapp, String passapp) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		username.sendKeys(useridapp);
		password.sendKeys(passapp);
		loginbtn.click();

	}
}
