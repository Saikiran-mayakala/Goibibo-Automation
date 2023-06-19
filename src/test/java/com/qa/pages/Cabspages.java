package com.qa.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cabspages 
{
	
	WebDriver driver;
	
	
	
	@FindBy(xpath="//span[contains(text(),'Cabs')]")
	@CacheLookup
	WebElement cabslink;
	
	
	@FindBy(xpath="//span[contains(text(),'Outstation')]")
	@CacheLookup()
	WebElement outstationcabs;
	
	@FindBy(xpath="//a[contains(text(),'Airport Cabs')]")
	@CacheLookup()
	WebElement airportcabs;
	
	@FindBy(xpath="//a[contains(text(),'One Way')]")
	@CacheLookup()
	WebElement onewaycabs;
	
	public void onewaybooking()
	{
		onewaycabs.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Round Trip')]")
	@CacheLookup()
	WebElement roundtripcabs;
	
	public void roundtripsel()
	{
		roundtripcabs.click();
	}
	
	
	@FindBy(xpath="//p[@id='sourceText']")
	@CacheLookup()
	WebElement pickupclick;
	
	@FindBy(xpath="//p[@id='destText']")
	@CacheLookup()
	WebElement dropclick;
	
	public void droplocclick()
	{
		dropclick.click();
	}
	
	@FindBy(xpath="//input[@class='form-control']")
	@CacheLookup()
	WebElement input;
	
	@FindBy(xpath="//div[@class='DayPickerInput']")
	@CacheLookup()
	WebElement startdate;
	
	@FindBy(xpath="(//div[@class='DayPickerInput'])[2]")
	@CacheLookup()
	WebElement returndate;
	
	@FindBy(xpath="//select[@data-testid='selectTime']")
	@CacheLookup()
	WebElement starttime;
	
	@FindBy(xpath="((//select[@data-testid='selectTime'])[2]")
	@CacheLookup()
	WebElement returntime;
	
	@FindBy(xpath="//button[contains(text(),'Search Cabs')]")
	@CacheLookup()
	WebElement search;
	
	@FindBy(xpath="//*[@class='srp-addTraveller']")
	@CacheLookup()
	WebElement addcontact;
	
	@FindBy(xpath="//span[contains(text(),'Mr.')]")
	@CacheLookup()
	WebElement Mrtitle;
	
	@FindBy(xpath="//span[contains(text(),'Mrs.')]")
	@CacheLookup()
	WebElement Mrstitle;
	
	@FindBy(xpath="//span[contains(text(),'Miss')]")
	@CacheLookup()
	WebElement Misstitle;
	
	@FindBy(className="travellerInputTxt")
	@CacheLookup()
	WebElement inputname;
	
	@FindBy(xpath="//input[@placeholder='Mobile']")
	@CacheLookup()
	WebElement mobileno;
	
	@FindBy(xpath="//input[@placeholder='E-mail']")
	@CacheLookup()
	WebElement email;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	@CacheLookup()
	WebElement buttoncont;
	
	@FindBy(xpath="//span[contains(text(),'Pay')]")
	@CacheLookup()
	WebElement paybutton;
	
	
	
	
	public Cabspages(WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void cabiconclick()
	{
		
		//System.out.println(" url is loaded");
		
		cabslink.click();
		
	//	System.out.println(" cabslink is clicked");
		
	}
	
	public void outstationselect()
	{
		
		outstationcabs.click();
	}
	
	public void airportcabsclick()
	{
		airportcabs.click();
	}
	
	public void locations(String pickloc) throws InterruptedException
	{
		pickupclick.click();
		
		input.clear();
		input.sendKeys(pickloc);
		
		Thread.sleep(1000);
		
		input.sendKeys(Keys.ARROW_UP);
		
		Thread.sleep(1000);
				
		
		input.sendKeys(Keys.ENTER);
				
		
	}
	
	
	public void airportpickup(String pickup ) throws InterruptedException
	{
		
		pickupclick.click();
		
		input.clear();
		input.sendKeys(pickup);
		
		Thread.sleep(1000);
		
		input.sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(1000);
				
		//input.sendKeys(Keys.RETURN);
		input.sendKeys(Keys.ENTER);
				
		
		
	}
	
	public void airportdroplocation(String droploc) throws InterruptedException
	{
		WebElement drop=driver.findElement(By.xpath("//input[@class='form-control']"));
		
		drop.clear();
		drop.sendKeys(droploc);
		Thread.sleep(1000);
		
		drop.sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(1000);
		drop.sendKeys(Keys.ENTER);
		
		
		
	}
	
	
	public void droplocation(String droploc) throws InterruptedException
	{
		WebElement drop=driver.findElement(By.xpath("//input[@class='form-control']"));
		
		drop.clear();
		drop.sendKeys(droploc);
		Thread.sleep(1000);
		
		drop.sendKeys(Keys.ARROW_UP);
		
		Thread.sleep(1000);
		drop.sendKeys(Keys.ENTER);
		
		
		
	}
	
	public void startdate(String sdate) throws InterruptedException
	{
		
		startdate.click();
		
        Thread.sleep(500);
        
        String dateXpath="//div[contains(@aria-label,'"+sdate+"')]";
		
		driver.findElement(By.xpath(dateXpath)).click();
			
	}
	
	public void starttimeclick(String time)
	{
		
		Select pickuptime=new Select(starttime);
		 pickuptime.selectByValue(time);
	}
	
	
	
	public void returndateclick(String rdate) throws InterruptedException
	{
		returndate.click();
		Thread.sleep(1000);
		
        String dateXpath="//div[contains(@aria-label,'"+rdate+"')]";
		
		driver.findElement(By.xpath(dateXpath)).click();
		
		
		
	}
	
	
	
	public void searchclick()
	{
		search.click();
	}
	
	@FindBy(xpath="//p[contains(text(),'Sedan')]")
	@CacheLookup()
	WebElement sedanselect;
	
	public void carselect()
	{
		sedanselect.click();
	}
	
	public void addcontclick()
	{
		addcontact.click();
		
	}
	
	public void settitle(String title)
	{
		
		if(title.equalsIgnoreCase("Mr."))
		{
			Mrtitle.click();
		}
		else if(title.equalsIgnoreCase("Mrs."))
		{
			Mrstitle.click();
		}
		else
			Misstitle.click();
		
		
	}
	
	public void setname(String name)
	{
		inputname.clear();
		inputname.sendKeys(name);
	}
	
	public void setmoblieno(String number)
	{
		mobileno.clear();
		mobileno.sendKeys(number);
	}
	
	public void setemail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	public void continueclick()
	{
		buttoncont.click();
	}
	
	public void payclick()
	{
		paybutton.click();
	}
	
	public void negativedroplocation(String droploc) throws InterruptedException
	{
		WebElement drop=driver.findElement(By.xpath("//input[@class='form-control']"));
		
		drop.clear();
		drop.sendKeys(droploc);
		Thread.sleep(1000);
		for(int i=0;i<3;i++)
		{
		drop.sendKeys(Keys.ARROW_UP);
		}
		Thread.sleep(1000);
		drop.sendKeys(Keys.ENTER);
		
	}
	
	
	
	@FindBy(xpath="//span[@class='ico14 lh1-2']")
	@CacheLookup()
	WebElement errormsg;
	
	public String displaymsg()
	{
		return errormsg.getText();
	}
	public void clickgotit()
	{
		driver.findElement(By.xpath("//button[contains(text(),'GOT IT')]")).click();
	}
	
	@FindBy(xpath="//input[@name='cardCVV']")
	@CacheLookup()
	WebElement paypage;
	
	public boolean ispaypageloaded()
	{
		return paypage.isDisplayed();
	}
	
	
}
