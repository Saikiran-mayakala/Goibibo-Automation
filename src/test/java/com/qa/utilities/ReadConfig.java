package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		
			File Src = new File("C:\\Users\\SAIKIRAN\\eclipse-workspaceEE\\Goibibo\\Configuration\\config.properties");
		try {
			FileInputStream Fileloc = new FileInputStream(Src);
			prop = new Properties();
			prop.load(Fileloc);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is " + e.getMessage());
		}
			
			
		
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseurl");
		return url;
	}
	
//	public String getpickuplocation()
//	{
//		String loc=prop.getProperty("pickuplocation");
//		return loc;
//	}
//	

}