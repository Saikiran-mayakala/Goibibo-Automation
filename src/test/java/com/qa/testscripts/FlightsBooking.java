package com.qa.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.FlightsPage;
import com.qa.utilities.ExcelUtilities;


public class FlightsBooking extends BaseTest {
	
	
	FlightsPage flightTicket;
	boolean payment;
	JavascriptExecutor scrollDown;
	 Actions actions;
	@BeforeMethod
	public void selecting()
	{
		flightTicket=new FlightsPage(driver);
	}
	@AfterMethod
	public void getHomePage()
	{
		flightTicket.clickLogo();
	}
	
	
	@Test(priority=1,dataProvider="details")
	public void oneWayFlightBooking_TC301(String fname,String lname,String email,String mobileno) throws InterruptedException, IOException
	
	{
		
		
	flightTicket.setOneWay();
	flightTicket.setFromCity1("Hyderabad");
	
	flightTicket.setToCity1("Mumbai");
	flightTicket.setDepartureDate1();
	flightTicket.clickTravellers();
	
	flightTicket.setSearchBtn();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	flightTicket.clickBook();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	flightTicket.clickRiskTrip();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 actions = new Actions(driver);

     // Scroll Down using Actions class
     actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
     Thread.sleep(4000);
    // Driver.findElement(By.xpath("//select[@id='Adulttitle1']")).click();
     
	flightTicket.setTitle();
	//JavascriptExecutor scrollDown = (JavascriptExecutor) Driver;
	//scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	flightTicket.setFirstName(fname);
	flightTicket.setLastName(lname);
	flightTicket.setEmail(email);
	flightTicket.setMobile("9874561230");
	flightTicket.clickProceed();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'OK')]")));
	System.out.println("Wait");
	Reporter.log("Wait",true);
	flightTicket.clickOk();
	System.out.println("button");
	Reporter.log("button",true);
	
	
	payment=flightTicket.paymentDetails();
	if(payment==true)
	{	//getScreenshot(driver,"oneWayFlightBooking_TC301");
		Reporter.log("passed",true);
		Assert.assertTrue("Payment page is loaded",true);

	}
	else
	{
		getScreenshot(driver,"oneWayFlightBooking_TC301");
		Assert.assertFalse("Payment page is not loaded", true);
	}
	System.out.print("passed");
	
	
		
	}
	@Test(priority=2)
	public void searchingSameCity_TC302() throws InterruptedException, IOException
	{
		flightTicket.setOneWay();
		flightTicket.setFromCity1("Hyderabad");
		
		flightTicket.setToCity1("Hyderabad");
		flightTicket.setDepartureDate1();
		flightTicket.clickTravellers();
		
		flightTicket.setSearchBtn();
		String msg=flightTicket.getErrorMsg();
		if(msg!=null)
		{
			Reporter.log("TC2",true);
			getScreenshot(driver,"searchingSameCity_TC302");
			Assert.assertEquals("Source and Destination cannot be same", msg);
		
		}
		else
			System.out.println(msg+"no text");
		
	}
	
	
	@DataProvider(name="details")
	public Object[][] getdata()
	{
		Object data[][]=testData( System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\cabsbookingtestdata.xlsx","Sheet2");
		return data;
		
	}
	
	
	
	public static Object[][] testData(String FilePath, String SheetName){
		
		ExcelUtilities EUtil = new ExcelUtilities(FilePath, SheetName);
		int rowcount = EUtil.getrowcount();
		int colcount = EUtil.getcolcount();
		
	Object data[][]=new Object[rowcount-1][colcount-1];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=1;j<colcount;j++)
			{
				String celldata=EUtil.getcelldata(i, j);
				data[i-1][j-1]=celldata;
				
			}
			
		}
		
		return data;
		
	}
	
	
	
	
	
	
}
