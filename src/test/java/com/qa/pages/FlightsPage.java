package com.qa.pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage {
	WebDriver driver;
Actions act;
JavascriptExecutor js;
	public FlightsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="oneway")
	@CacheLookup
	WebElement oneWay;
	public void setOneWay()
	{
		oneWay.click();
		
	}
	@FindBy(id="roundTrip")
	@CacheLookup
	WebElement roundTrip;
	public void setRoundTrip()
	{
		roundTrip.click();
		
	}
	@FindBy(id="multiCity")
	@CacheLookup
	WebElement multiCity;
	public void setMultiCity()
	{
		multiCity.click();
		
	}
	
	@FindBy(xpath="(//*[@id='gosuggest_inputSrc'])[1]")
	@CacheLookup
	WebElement fromCity1;
	public void setFromCity1(String from_city) throws InterruptedException
	{
		fromCity1.sendKeys(from_city);
		Thread.sleep(2000);
		fromCity1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		fromCity1.sendKeys(Keys.ENTER);
		
	}
	@FindBy(xpath="(//*[@id='gosuggest_inputDest'])[1]")
	@CacheLookup
	WebElement toCity1;
	public void setToCity1(String to_city) throws InterruptedException
	{
		toCity1.sendKeys(to_city);
		Thread.sleep(2000);
		toCity1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		toCity1.sendKeys(Keys.ENTER);
		
	}
	@FindBy(xpath="(//*[@id='departureCalendar'])[1]")
	@CacheLookup
	WebElement departureCalendar1;
	
	
	
	@FindBy(xpath="//*[@id='fare_20210121']")
	@CacheLookup
	WebElement departureDate;
	
	public void setDepartureDate1()
	{
		departureCalendar1.click();
		departureDate.click();
		
	}
	
	
	@FindBy(xpath="(//*[@id='returnCalendar'])[1]")
	@CacheLookup
	WebElement returnCalendar;
	
	
	
	@FindBy(xpath="//*[@id='fare_20210126']")
	@CacheLookup
	WebElement returnDate;
	
	public void setReturnDate()
	{
		returnCalendar.click();
		returnDate.click();
		
	}
	@FindBy(id="pax_label")
	@CacheLookup
	WebElement travelType;
	public void clickTravellers()
	{
		travelType.click();
	}
	
	@FindBy(id="adultPaxBox")
	@CacheLookup
	WebElement travellerCount;
	public void setTravellerCount(String i)
	{
		travellerCount.sendKeys(i);
	}
	@FindBy(id="gi_class")
	@CacheLookup
	Select travel_class;
	
	public void setTravelClass(String travelClass)
	{
		travel_class.selectByVisibleText(travelClass);
	}
	
	@FindBy(id="gi_search_btn")
	@CacheLookup
	WebElement searchBtn;
	public void setSearchBtn()
	{
		searchBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@FindBy(id="react-autosuggest-1")
	@CacheLookup
	WebElement fromDropDown;
	public void setFromDropList()
	{
		act.moveToElement(fromDropDown).build().perform();
	}
	@FindBy(xpath="(//input[@value='BOOK'])[1]")
	@CacheLookup
	WebElement bookBtn;
	public void clickBook()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		bookBtn.click();
	}
	@FindBy(id="risk-trip")
	@CacheLookup
	WebElement riskRadioBtn;
	public void clickRiskTrip()
	{
		riskRadioBtn.click();
	}
	@FindBy(xpath="//*[@id='Adulttitle1']")
	@CacheLookup
	WebElement title;
	
	public void setTitle()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//js.executeScript("arguments[0].scrollIntoView(true);", title);
		System.out.println("title");
		title.click();	

		title.sendKeys(Keys.ARROW_DOWN);
		title.sendKeys(Keys.ENTER);
		
		
	}
	@FindBy(id="AdultfirstName1")
	@CacheLookup
	WebElement firstName;
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	@FindBy(id="AdultlastName1")
	@CacheLookup
	WebElement lastName;
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	public void setEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	@FindBy(id="mobile")
	@CacheLookup
	WebElement mobile;
	public void setMobile(String mobileno)
	{
		mobile.sendKeys(mobileno);
	}

	@FindBy(xpath="//*[contains(text(),'Proceed')]")
	@CacheLookup
	WebElement proceedBtn;
	public void clickProceed()
	{
		proceedBtn.click();
	}
	@FindBy(xpath="//*[contains(text(),'Proceed To Payment')]")
	@CacheLookup
	WebElement proceedToPay;
	public void clickProceedToPay()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", proceedToPay);
		proceedToPay.click();
	}
	@FindBy(xpath="//*[contains(text(),'Payment Details')]")
	@CacheLookup
	WebElement PaymentDetails;
	public boolean paymentDetails()
	{
		
		if(PaymentDetails.isDisplayed())
			return true;
		else
			return false;
	}
	
			@FindBy(xpath="//button[contains(text(),'OK')]")
			@CacheLookup
			WebElement okBtn;
			public void clickOk()
			
			{
				js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", okBtn);
			}
	
			@FindBy(xpath="//*[@href='/']")
			@CacheLookup
			WebElement logo;
			

			
			public void clickLogo() {
				
			logo.click();
			}
	@FindBy(xpath="//span[@class='status_cont red ico13']")
	@CacheLookup
	WebElement errorMsg;
	public String getErrorMsg()
	{
		String msg=errorMsg.getText();
		return msg;
	}
	/*WebElement okBtn=driver.findElement(By.xpath("//*[contains(text(),'OK')]"));
	System.out.print("button found");
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", okBtn);*/
	
	
	
	
	
	
	
	
	
	
	
	

}
