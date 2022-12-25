package com.guru.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() {
		
		File src =new File(System.getProperty("user.dir")+"/config/config.properties");
		
		try {
			FileInputStream fis =new FileInputStream(src);
			 pro =new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
		}
		
		 		
	}
	public  String getbrowser() {
		return pro.getProperty("browser");
		
	}

	public String getURL() {
		return pro.getProperty("qaURL");
		
	}
}
