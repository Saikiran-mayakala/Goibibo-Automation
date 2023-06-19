package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	
	
	WebDriver driver;
	
	public static Logger logger;
	
	ReadConfig readconfig=new ReadConfig();
	public String url= readconfig.getApplicationURL();
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser)
	{
		
		logger = Logger.getLogger("Goibibo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void getScreenshot(WebDriver driver,String tname) throws IOException {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		  
		  TakesScreenshot SShot = (TakesScreenshot) driver;
		  File source = SShot.getScreenshotAs(OutputType.FILE);
		  String Destination  = System.getProperty("user.dir") + "/Screenshot/" + tname  + dateName+".png" ;


	       FileUtils.copyFile(source,new File(Destination));
		        
	}
	

}
