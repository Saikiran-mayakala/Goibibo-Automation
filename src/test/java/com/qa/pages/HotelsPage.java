package com.qa.pages;

import org.openqa.selenium.By;

//import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage 
{	
	//Date date = new Date();
	
	WebDriver Driver;
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/ul/li[3]/a")
	@CacheLookup
	WebElement GoStays;
	public void goStays()
	{
		GoStays.click();
	}
	@FindBy(xpath="//input[@id='downshift-1-input']")
	@CacheLookup
	WebElement SearchLoc;
	public void searchLocation(String location) throws InterruptedException
	{
		SearchLoc.click();
		SearchLoc.sendKeys(location);
		Thread.sleep(1000);

		SearchLoc.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);

		SearchLoc.sendKeys(Keys.RETURN);

		
		//SearchLoc.findElement(By.("aria-activedescendant"("downshift-1-item-0"))).click();
		
	}
	/*
	 * @FindBy(xpath="")
	 * 
	 * @CacheLookup WebElement SearchLoc1; public void searchLocation(String
	 * location) { SearchLoc.click(); SearchLoc.sendKeys(location);
	 * SearchLoc.sendKeys(Keys.ENTER);
	 * 
	 * }
	 */
	
	@FindBy(xpath="//h4[contains(text(),'India')]")
	WebElement RadioButtonIndia;
	public void radioButtonIndia()
	{
		/*
		 * Boolean x=RadioButtonIndia.isSelected(); if(x==true) {
		 * 
		 * }
		 */
		RadioButtonIndia.click();
	}
	@FindBy(xpath="//h4[contains(text(),'International')]")
	WebElement RadioButtonInt;
	public void radioButtonInternational()
	{
		/*
		 * Boolean x=RadioButtonIndia.isSelected(); if(x==true) {
		 * 
		 * }
		 */
		RadioButtonInt.click();
	}
	
	//@FindBy(xpath="//div[contains(text(),'Check-in')]")
	@FindBy(xpath="(//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-6 SearchBlockUIstyles__CheckInDateWrapDiv-fity7j-14 cGwINZ lkSOrE'])[1]")
	WebElement CheckInDate;
	public void checkInDate()
	{
		
		CheckInDate.click();
		CheckInDate.findElement(By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-r2jz2t-7 jXPZCe']/li[30]")).click();
	}
	@FindBy(xpath="//div[contains(text(),'Check-out')]")
	WebElement CheckOutDate;
	public void checkOutDate()
	{
		//CheckOutDate.click();
		//CheckOutDate.findElement(By.xpath("(//span[contains(text(),'20')])[1]")).click();
		CheckInDate.findElement(By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-r2jz2t-7 jXPZCe']/li[32]")).click();
		
	}
	@FindBy(xpath="//input[@class='SearchBlockUIstyles__CitySearchInput-fity7j-12 gPhhhX']")
	WebElement GuestAndRooms;
	public void guestAndRooms()
	{
		
		GuestAndRooms.click();
		
	}
	@FindBy(xpath="//button[contains(text(),'Search Hotels')]")
	WebElement SearchButton;
	public void searchButton()
	{
		
		SearchButton.click();
		
	}
	
	@FindBy(xpath="(//div[@itemtype='http://schema.org/Hotel'])[1]")
	WebElement Hotel;
	public void hotel()
	{
		//public static void HoverAndClick(WebDriver driver,WebElement elementToHover,WebElement elementToClick) {
		//	Actions action = new Actions(driver);
		//	action.moveToElement(elementToHover).click(elementToClick).build().perform();
		
		Hotel.click();
		//(//div[@itemtype=\"http://schema.org/Hotel\"])[4]
		//String winHandleBefore = driver.getWindowHandle();
		//for(String winHandle : driver.getWindowHandles()){
		 //   driver.switchTo().window(winHandle);
	}
	@FindBy(xpath="(//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-9 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 bdisym bCgKhF'])[1]")
	WebElement RoomSelect;
	public void roomSelect()
	{
		RoomSelect.click();
		//String winHandleBefore = driver.getWindowHandle();
		//for(String winHandle : driver.getWindowHandles()){
		 //   driver.switchTo().window(winHandle);
	}
	@FindBy(xpath="//a[@class=\"hdrLogo\"]")
	WebElement HomePage;
	public void homePage()
	{
		HomePage.click();
	}
	@FindBy(xpath="//input[@data-guestdetailsinnerwrapid='first-name']")
	WebElement FName;
	public void fName(String fname)
	{	
		//FName.click();
		FName.sendKeys(fname);
	}
	@FindBy(xpath="//input[@data-guestdetailsinnerwrapid='last-name']")
	WebElement LName;
	public void lName(String Lname)
	{
		LName.sendKeys(Lname);
	}
	@FindBy(xpath="//input[@data-guestdetailsinnerwrapid='guest-details-email']")
	WebElement Email;
	public void email(String emailId)
	{
		Email.sendKeys(emailId);
	}
	@FindBy(xpath="//input[@data-guestdetailsinnerwrapid='guest-details-phone']")
	WebElement PhoneNo;
	public void phoneNo(String phone)
	{
		PhoneNo.sendKeys(phone);
	}
	@FindBy(xpath="//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-9 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 bdisym hvAOPy']")
	WebElement PaymentButton;
	public void paymentButton()
	{
		PaymentButton.click();
	}
	
	public HotelsPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
}
