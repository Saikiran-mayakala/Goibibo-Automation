package com.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Buspages {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/ul/li[4]/a")
	@CacheLookup
	WebElement busicon;
	
	public void clickbusicon() {
		busicon.click();
	}
	@FindBy(id="downshift-1-item-0")
	@CacheLookup
	WebElement fromcity;
	public void fromcityclick() {
		fromcity.click();
	}
	@FindBy(xpath="//input[@id='autosuggestBusSRPSrcHome']")
	@CacheLookup
	WebElement source;
	
	public void setsource(String src) {
		
		//source.clear();
		source.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		source.sendKeys(src);
		
	}
	
	@FindBy(id="downshift-2-item-0")
	@CacheLookup
	WebElement tocity;
	public void tocityclick() {
		tocity.click();
		
	}
	@FindBy(xpath="//input[@id='autosuggestBusSRPDestHome']")
	@CacheLookup
	WebElement destination;
	
	public void setdestination(String dest) {
		destination.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//destination.clear();
		destination.sendKeys(dest);	
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/div/span[2]")
	@CacheLookup
	WebElement date;

	public void setdate() {
		date.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/div/span[1]")
	@CacheLookup
	WebElement todaydate;

	public void settodaydate() {
		todaydate.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[5]/button")
	@CacheLookup
	WebElement search;
	
	public void clicksearch() {
		search.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[1]/div/label")
	@CacheLookup
	WebElement msg;
	
	public String errormsg() {
//		String Message =  
//		System.out.println(Message);
		return msg.getText();
		
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayoutinner\"]/div[1]/div[1]/span[2]")
	@CacheLookup
	WebElement totalbuses;
	public void numberofbuses() {
		String element = totalbuses.getText();
		System.out.println("Total number of buses present are: "+ element);
	}
	
	@FindBy(xpath="//*[@class=\"SrpActiveCardstyles__PriceSeparationDiv-yk1110-35 hSfhtR\"]")
	@CacheLookup
	List<WebElement> prices;
	public void busprices() {
		for(WebElement i: prices) {

			if(prices.contains(i)) {
				
				System.out.println("Prices of buses available are: "+ i.getText());
			}
			else
				System.out.println("buses are not available");
	}
	}
	
	@FindBy(xpath="//p[contains(text(),'Sorry, no bus found for your searched route.')]")
	@CacheLookup
	WebElement errormsg;
	
	public String displaymsg() {
		String mssg = errormsg.getText();
		System.out.println("Error is: "+mssg);
		return mssg;
	}
	
	@FindBy(xpath="//*[@href='/']")
	@CacheLookup
	WebElement logo;
	
	public void clicklogo() {
		logo.click();
	}
	
	public Buspages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
