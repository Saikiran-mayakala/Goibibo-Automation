package com.qa.testscripts;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Cabspages;
import com.qa.utilities.ExcelUtilities;

public class Cabstestscript extends BaseTest
{
	//Writen by SaiKiran Mayakala.
	//Testing the Cab booking process in Goibibo web Application .
	
	Cabspages cabsOR;//page object creation.
	

	@BeforeMethod
	public void cabstabsetup()
	{
		cabsOR =new Cabspages(driver);
		cabsOR.cabiconclick();
		
		driver.manage().window().maximize();
		logger.info("cabs page is loaded");
	}
	
	@Test(priority=1)
	public void Tc_401onewaytripbooking() throws Exception
	{
		
		
		
	
		Thread.sleep(1000);
		cabsOR.outstationselect();
			
		logger.info("outstation cabs selected");
		
		cabsOR.locations("Hyderabad");//pick location
		
		Thread.sleep(1000);
		
		cabsOR.droplocation("mumbai");//drop location
		
		Thread.sleep(1000);
		logger.info(" pickup and drop location are entered");
         cabsOR.startdate("Jan 23");
		
		Thread.sleep(1000);
		
		
		cabsOR.starttimeclick("11:45 PM");
		
		Thread.sleep(1000);
		
		logger.info("pickup time is entered.");
		cabsOR.searchclick();
		
		Thread.sleep(3000);
		
		cabsOR.carselect();//sedan car is selected
		
		
		cabsOR.addcontclick();
		Thread.sleep(1000);
		
		cabsOR.settitle("Mr.");
		Thread.sleep(1000);
		
		cabsOR.setname("saikiran");
		
		Thread.sleep(1000);
		cabsOR.setmoblieno("9848022333");
		
		cabsOR.setemail("saikiran@gamil.com");
		
		logger.info("Contact details are entered.");	//details are submited
		Thread.sleep(1000);
		
		cabsOR.continueclick();
		
		Thread.sleep(2000);
		
		cabsOR.payclick();
		
		Thread.sleep(2000);
		if(cabsOR.ispaypageloaded())
		{
			logger.info("payment page is loaded");	
			
		}
		else {
			logger.error("Payment page is Not loaded.");	
			getScreenshot(driver,"roundtriptestcase");
			
		}
		
		logger.info("completed onewaytrip cab booking test case");		
	}
	
	@Test(priority=2)
	public void roundtriptestcase() throws  Exception
	{
		Thread.sleep(1000);
		cabsOR.outstationselect();
			
		cabsOR.roundtripsel();//roundtrip is selected
		
		Thread.sleep(2000);
		
		cabsOR.locations("Hyderabad");//pickup location
		
		Thread.sleep(1000);
		
		cabsOR.droplocclick();
		Thread.sleep(1000);
		
		cabsOR.droplocation("chennai");//drop location
		
		Thread.sleep(1000);
		logger.info("locations are entered");
		
         cabsOR.startdate("Jan 23");
		
		Thread.sleep(1000);
		cabsOR.returndateclick("Jan 30");
		
		cabsOR.starttimeclick("11:45 PM");
		
		Thread.sleep(2000);
		
		logger.info("time and date are entered.");
		
		
		cabsOR.searchclick();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		cabsOR.carselect();
		
		cabsOR.addcontclick();
		Thread.sleep(2000);
		
		cabsOR.settitle("Miss");
		Thread.sleep(1000);
		
		cabsOR.setname("sree");
		
		Thread.sleep(1000);
		cabsOR.setmoblieno("9848022333");
		
		cabsOR.setemail("saikiran@gamil.com");
		
		Thread.sleep(1000);
		
		logger.info("contact Details are entered.");
		
		cabsOR.continueclick();
		
		Thread.sleep(2000);
		
		cabsOR.payclick();
		
		Thread.sleep(2000);	
		
		if(cabsOR.ispaypageloaded())
		{
			getScreenshot(driver,"roundtriptestcase");
			logger.info(" paymentpage is loaded.");
		}
		else {
			getScreenshot(driver,"Tc_401onewaytripbooking");
			logger.error("payment page not loaded.");
		}
		logger.info("Roundtrip Cab booking testcase completed. ");	
	}
	
	@Test(priority=3,dataProvider="personalDetails")
	public void Tc_403airportcabs(String title,String name,String mobile,String email) throws InterruptedException
	{
		
		
		
	
		Thread.sleep(1000);
		cabsOR.airportcabsclick();//AirPort cabs Selected
		Thread.sleep(1000);
		
		logger.info("airportcabs selected.");
		cabsOR.airportpickup("lbnagar");
		
		
		
		Thread.sleep(2000);
		
		cabsOR.airportdroplocation("RGIA");;
		
		Thread.sleep(2000);
		
		 
		
         cabsOR.startdate("Jan 23");
		
		Thread.sleep(1000);
		
		
		cabsOR.starttimeclick("11:45 PM");
		
		Thread.sleep(1000);
		
		logger.info("booking details are entered");
		
		cabsOR.searchclick();
		
		Thread.sleep(2000);
		
		cabsOR.carselect();
		Thread.sleep(2000);
		
		cabsOR.addcontclick();
		Thread.sleep(2000);
		
		cabsOR.settitle(title);
		Thread.sleep(1000);
		
		cabsOR.setname(name);
		
		Thread.sleep(1000);
		cabsOR.setmoblieno(mobile);
		
		cabsOR.setemail(email);
		
		Thread.sleep(1000);
		
		
		logger.info("contact details are entered.");
		
		cabsOR.continueclick();
		
		Thread.sleep(1000);
		
		cabsOR.payclick();
		
		Thread.sleep(2000);
		
		if(cabsOR.ispaypageloaded())
		{
			logger.info(" paymentpage is loaded.");
		}
		else {
			logger.error("payment page is not loaded.");
		}
		
		logger.info("completed the airport cabs booking test case");	
	}
	
	
	@Test(priority=4)
	public void negativeOnewaytripCabBooking_TC405() throws Exception
	{
		cabsOR.outstationselect();
		
		cabsOR.onewaybooking();
		Thread.sleep(1000);
		
			
		
		
		cabsOR.locations("Hyderabad");
		
		cabsOR.droplocclick();
		Thread.sleep(1000);
		
		cabsOR.negativedroplocation("Hyderabad");
		logger.info("same source and destination is entered. ");
		Thread.sleep(2000);

		
		String error=cabsOR.displaymsg();
		System.out.println("the error message is : "+error);
		
		if(error!=null)
		{
			logger.info("error message is : "+error);
			getScreenshot(driver,"negativeOnewaytripCabBooking_TC405");
		   Assert.assertEquals(error,"Source and destination cannot be same");
		}
		else {
			logger.error(" it is accepting the same source and destination.");
			
		}
		cabsOR.clickgotit();
		logger.info("negative onewaytrip booking testcase is completed.");
			
	}
	
	@Test(priority=5)
	public void negativeRoundtripCabBooking_TC404() throws Exception
	{
		cabsOR.outstationselect();
		
		cabsOR.roundtripsel();
		Thread.sleep(1000);
		
			
		
		
		cabsOR.locations("Hyderabad");
		
		cabsOR.droplocclick();
		Thread.sleep(1000);
		
		cabsOR.negativedroplocation("mumbai");
		
		Thread.sleep(1000);

		
		cabsOR.searchclick();
		Thread.sleep(1000);
		
		String error=cabsOR.displaymsg();
		System.out.println("the error message is : "+error);
		
		if(error!=null)
		{
			logger.info("error message : "+error);
			getScreenshot(driver,"negativeRoundtripCabBooking_TC404");
		   Assert.assertEquals(error,"Dear customer, Selected duration is not sufficient to complete your round trip travel.");
		}
		else
			logger.error("No Error message is displayed.");
		cabsOR.clickgotit();
		
		logger.info("negative roundtrip cab booking  testcase is completed.");
		
		
	}
	
	
	
	
	@DataProvider(name="personalDetails")
	public Object[][] getdata()
	{
		Object data[][]=testdata( System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\cabsbookingtestdata.xlsx","Sheet1");
		return data;
		
	}
	public static Object[][]  testdata(String filepath,String sheetname)
	{
		
		ExcelUtilities eUtil= new ExcelUtilities(filepath,sheetname);
		int rowcount=eUtil.getrowcount();
		int colcount=eUtil.getcolcount();
		
		
		Object data[][]=new Object[rowcount-1][colcount-1];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=1;j<colcount;j++)
			{
				String celldata=eUtil.getcelldata(i, j);
				data[i-1][j-1]=celldata;
				
			}
			
		}
		
		
		return data;
		
	}

}
