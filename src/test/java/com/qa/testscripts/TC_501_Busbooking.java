package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Buspages;

public class TC_501_Busbooking extends BaseTest{

	Buspages busobject;

	@BeforeMethod
	public void selecting()
	{
		busobject=new Buspages(driver);
		busobject.clickbusicon();
	}
	
	
	
	@Test(priority=2,dataProvider="BusBookingTwo")
	public void busBooking(String source, String destination) throws InterruptedException, IOException {
	 		
	 		busobject.setsource(source);
		    Thread.sleep(2000);
		    busobject.fromcityclick();
		    busobject.setdestination(destination);
		    Thread.sleep(2000);
		    busobject.tocityclick();
		    busobject.setdate();
		    Thread.sleep(2000);
		    busobject.clicksearch();
		    Thread.sleep(2000);
		    busobject.errormsg();
		    getScreenshot(driver,"BusBooking_2");
		    Assert.assertTrue(false);
	   
	  }
	  
	  @DataProvider(name = "BusBookingTwo")
	  public Object[][] Data(){
		  Object[][] value = new Object[1][2];
		  value[0][0] = "Hyderabad";
		  value[0][1] = "Hyderabad";
		  
		  return value;
	  }
	  
	@Test(priority=3)
	public void searchbus() throws InterruptedException
	
	{
		
		busobject.setsource("Hyderabad");
    	Thread.sleep(2000);
    	busobject.fromcityclick();
    	busobject.setdestination("Chennai");
    	Thread.sleep(2000);
    	busobject.tocityclick();
    	busobject.setdate();
    	Thread.sleep(2000);
    	busobject.clicksearch();
    	Thread.sleep(2000);
    	busobject.numberofbuses();
    	Thread.sleep(1000);
    	busobject.busprices();
	}
	
	@Test(priority=1,dataProvider="BusBookingOne")
	public void busBookingone(String source, String destination) throws InterruptedException, IOException {
			
	 		busobject.setsource(source);
		    Thread.sleep(2000);
		    busobject.fromcityclick();
		    busobject.setdestination(destination);
		    Thread.sleep(2000);
		    busobject.tocityclick();
		    busobject.settodaydate();
		    Thread.sleep(2000);
		    busobject.clicksearch();
		    Thread.sleep(2000);
		    //busobject.displaymsg();
		    String message = busobject.displaymsg();
		    if(message!=null) {
		    	getScreenshot(driver,"busBookingone");
		    	Assert.assertEquals(message, "Sorry, no bus found for your searched route.");
		    }
		    else
		    	System.out.println("error");
	}
	  
	  @DataProvider(name = "BusBookingOne")
	  public Object[][] datOne(){
		  Object[][] TestValue = new Object[1][2];
		  TestValue[0][0] = "Hyderabad";
		  TestValue[0][1] = "Amritsar";
		  
		  return TestValue;
	  }
	 
}
