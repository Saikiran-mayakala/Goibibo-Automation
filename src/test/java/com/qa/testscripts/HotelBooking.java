package com.qa.testscripts;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HotelsPage;

public class HotelBooking extends BaseTest
{
	HotelsPage Hotelobj;
	@BeforeMethod
	public void moduleLink()
	{
		Hotelobj =new HotelsPage(driver);
		Hotelobj.goStays();
	}
	@AfterMethod
	public void homePageNavigate()
	{
		Hotelobj.homePage();
	}
	@Test
	public void hotelBooking_TC201() throws InterruptedException, IOException 
	{	
		//System.out.println("TEST IS RUNNING");
		//Hotelobj.goStays();
		//System.out.println("TEST1 IS RUNNING");
		Thread.sleep(1000);
		Hotelobj.radioButtonIndia();
		/*
		 * if(0>1) { Assert.assertTrue(true); } else {
		 * captureScreen(Driver,"hotelBooking"); Assert.assertTrue(false);
		 * 
		 * }
		 */
		//System.out.println("button is selected");
		Hotelobj.searchLocation("Manali");
		Thread.sleep(1000);
		//System.out.println("manali is selected");
		Hotelobj.checkInDate();
		//System.out.println("Date Selected");
		Thread.sleep(1000);
		Hotelobj.checkOutDate();
		//System.out.println("check out dateis selected");

		//Hotelobj.guestAndRooms();
		//System.out.println("rooms selected");
		Hotelobj.searchButton();
		Thread.sleep(1000);
		String window1 = driver.getWindowHandle();
		System.out.println("test0");

		Hotelobj.hotel();
		Thread.sleep(1000);

		System.out.println("test1");
			for(String winHandle : driver.getWindowHandles())
			{
				   driver.switchTo().window(winHandle);
				   
			}
			System.out.println("test2");
			Thread.sleep(1000);
			//Hotelobj.roomSelect();
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			WebElement element = driver.findElement(By.xpath("(//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-9 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 bdisym bCgKhF'])[1]"));
			actions.moveToElement(element).click().build().perform();
			Thread.sleep(1000);
			Hotelobj.fName("ABCD");
			Hotelobj.fName("ABCD");

			System.out.println("test3");
			Hotelobj.lName("sada");
			System.out.println("test4");

			Hotelobj.email("ajdhsj@ads.com");
			Hotelobj.phoneNo("1234567890");
			Hotelobj.paymentButton();
			Thread.sleep(2000);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			String title=driver.getTitle();
			System.out.println(title);
			
			driver.close();
			driver.switchTo().window(window1);
		}
	
	@Test
	public void  hotelBooking_TC202() throws InterruptedException, IOException 
	{
		System.out.println("test202");
	}
}
