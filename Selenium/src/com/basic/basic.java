package com.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class basic {
	String url = "https://www.google.com/search?q=youtube&oq=youtube&aqs=chrome..69i57.6309j0j8&sourceid=chrome&ie=UTF-8";
	WebDriver driver=null;

	//private ChromeDriver ChromeDriver;
	@BeforeTest
	public void youtube() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to(url);
	
	
	
	
		
	}
	
	

}
