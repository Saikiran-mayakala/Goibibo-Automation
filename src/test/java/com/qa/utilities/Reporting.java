package com.qa.utilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	ExtentReports XReport; 
	ExtentHtmlReporter HtmlReporter;
	ExtentTest XTest;
	
	  public void onStart(ITestContext testContext) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			HtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
			
		  
		 // HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
			HtmlReporter.config().setDocumentTitle("Automation Report");
			HtmlReporter.config().setReportName("Functional Report");
			HtmlReporter.config().setTheme(Theme.DARK);
			HtmlReporter.config().setAutoCreateRelativePathMedia(true);
			
			
			XReport = new ExtentReports();
			XReport.attachReporter(HtmlReporter);
			XReport.setSystemInfo("HostName", "LocalHost");
			XReport.setSystemInfo("OS", "Windows 10");
			XReport.setSystemInfo("Browser", "Chrome");
			XReport.setSystemInfo("Testername", "Sai Kiran");
	    
	  }

	  
	  public void onFinish(ITestContext testContext) {
		 
		  XReport.flush();
		  
		  
	  }
	
	
	  public void onTestSuccess(ITestResult tr) {
		 
		  XTest=XReport.createTest(tr.getName());
		  XTest.log(Status.PASS, tr.getName());
		 // XTest.log(Status.PASS, tr.getThrowable());
		  String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		  
		  String sspath=System.getProperty("user.dir") + "/Screenshot/"+tr.getName()+dateName+".png";
			File f=new File(sspath);
			if(f.exists())
			{
				try {
					
					XTest.addScreenCaptureFromPath(sspath);
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		  
		  
	    
	  }

	  
	  public void onTestFailure(ITestResult tr) {
		  XTest=XReport.createTest(tr.getName());
		  XTest.log(Status.FAIL, tr.getName());
		  XTest.log(Status.FAIL, tr.getThrowable());
		  
		  String sspath=System.getProperty("user.dir") + "/Screenshot/"+tr.getName()+".png";
		File f=new File(sspath);
		if(f.exists())
		{
			try {
				
				XTest.addScreenCaptureFromPath(sspath);
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	    
	  }

	
	  public void onTestSkipped(ITestResult tr) {
	  
		  XTest=XReport.createTest(tr.getName());
		  XTest.log(Status.SKIP, tr.getName());
		  XTest.log(Status.SKIP, tr.getThrowable());
		  
		  
	  }
	 

	

}
