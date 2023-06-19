package com.qa.testscripts;



import static org.junit.Assert.assertEquals;//

import java.util.List;

import org.junit.Before;//
import org.junit.Test;//
import org.openqa.selenium.By;//
import org.openqa.selenium.WebDriver;//
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;//

import io.github.bonigarcia.wdm.WebDriverManager;//

public class Solutions 
{
	WebDriver webDriver;


	@Before
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		webDriver=new ChromeDriver();

		webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");

	}

	@Test
	public void a() throws InterruptedException
	{	

		boolean textExists = webDriver.findElement(By.id("search-input")).isDisplayed();
		boolean btnExists = webDriver.findElement(By.id("search-button")).isDisplayed();

		Thread.sleep(2000);
		assertEquals( textExists, true);
		assertEquals( btnExists, true);

	}



	@Test
	public void b() throws InterruptedException
	{
		String txt = webDriver.findElement(By.id("search-input")).getText();
		if(txt.isEmpty()){
			webDriver.findElement(By.id("search-button")).click();
			String text = webDriver.findElement(By.id("error-empty-query")).getText();
			Thread.sleep(1000);
			System.out.println(text);
			assertEquals( "Provide some query", text);
		}
	}

	@Test
	public void c() throws InterruptedException
	{ 

		webDriver.findElement(By.id("search-input")).sendKeys("isla");
		webDriver.findElement(By.id("search-button")).click();
		Thread.sleep(10000);
		List<WebElement> findElements = webDriver.findElements(By.id("search-results"));
		int size = findElements.size();
		boolean num = size>=1;
		System.out.println(num);
		Thread.sleep(1000);
		assertEquals(num,true);
	}

	@Test
	public void d() throws InterruptedException
	{
		webDriver.findElement(By.id("search-input")).sendKeys("castle");
		webDriver.findElement(By.id("search-button")).click();
		String text1 = webDriver.findElement(By.id("error-no-results")).getText();

		Thread.sleep(1000);
		System.out.println(text1);
		assertEquals( "No results", text1);
	}

	@Test
	public void e() throws InterruptedException
	{

		webDriver.findElement(By.id("search-input")).sendKeys("port");
		webDriver.findElement(By.id("search-button")).click();
		Thread.sleep(10000);
		List<WebElement> findElements = webDriver.findElements(By.id("search-results"));
		int size=findElements.size();
		boolean b=size==1;
		assertEquals( b, true);
		for(WebElement item:findElements)
		{
			assertEquals(item.getText(),"Port Royal");
		}
	}


}
