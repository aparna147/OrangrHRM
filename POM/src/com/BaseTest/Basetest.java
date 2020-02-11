package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Basetest {
	
	public WebDriver driver = null;
	public String url = "http://newtours.demoaut.com";
	
	@BeforeMethod
	public void Setup() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\POM\\Driver File\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.navigate().to(url);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
		
		@AfterMethod
		public void tearDown()
		{
		
		
			//driver.quit();
			
		
		
		
	}

}
