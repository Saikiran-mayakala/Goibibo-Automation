package com.qa.testscripts;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Solcodility 
{

	WebDriver webDriver;


	@Before
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		webDriver=new ChromeDriver();

		webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

	}

	@Test
	public void a() throws InterruptedException
	{	

		boolean email= webDriver.findElement(By.id("email-input")).isDisplayed();
		boolean password= webDriver.findElement(By.id("password-input")).isDisplayed();

		Thread.sleep(2000);
		assertEquals( email, true);
		assertEquals( password, true);

	}

	@Test
	public void b() throws InterruptedException
	{
		webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
		webDriver.findElement(By.id("password-input")).sendKeys("password");

		webDriver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String txt=webDriver.findElement(By.xpath("//div[@class='message success']")).getText();

		assertEquals(txt,"Welcome to Codility");

	}

	@Test
	public void c() throws InterruptedException
	{
		webDriver.findElement(By.id("email-input")).sendKeys("unlogin@codility.com");
		webDriver.findElement(By.id("password-input")).sendKeys("password");

		webDriver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String txt=webDriver.findElement(By.xpath("//div[@class='message error']")).getText();

		assertEquals(txt,"You shall not pass! Arr!");

	}

	@Test
	public void d() throws InterruptedException
	{

		webDriver.findElement(By.id("email-input")).sendKeys("unlogin");
		webDriver.findElement(By.id("password-input")).sendKeys("password");

		webDriver.findElement(By.id("login-button")).click();
		String txt=webDriver.findElement(By.xpath("(//div[@class='validation error'])")).getText();

		assertEquals(txt,"Enter a valid email");
	}

	@Test
	public void e() throws InterruptedException
	{

		webDriver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String emailxpath="(//div[@class='validation error'])[1]";
		String passxpath="(//div[@class='validation error'])[2]";
		String emailtxt=webDriver.findElement(By.xpath(emailxpath)).getText();
		String passtxt=webDriver.findElement(By.xpath(passxpath)).getText();
		Thread.sleep(2000);



		assertEquals(emailtxt,"Email is required");
		assertEquals(passtxt,"Password is required");

	}


}
