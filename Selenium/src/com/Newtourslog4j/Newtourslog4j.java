package com.Newtourslog4j;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.OrangeHRM_Log4j.Log;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class Newtourslog4j

{
	@BeforeSuite
	public void Launch()
	{
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\Newtours.xml");
		
	}
	
	String url = "http://www.newtours.demoaut.com/";
	WebDriver driver = null;
	
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
		
		driver =new ChromeDriver();
		
		driver.navigate().to(url);

		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void signon()
	
		{
			//<a href="mercurysignon.php">SIGN-ON</a>
		
		WebElement signon =driver.findElement(By.linkText("SIGN-ON"));
		signon.click();
		
		Log.info("successfully click");
		
		//<input maxlength="60" name="userName" size="20">
		
		WebElement username =driver.findElement(By.name("userName"));
		username.sendKeys("tutorial");
		
		Log.info("successfully username");
		
		//<input maxlength="60" name="password" size="20" type="password">
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("tutorial");
		
		Log.info("successfully password");
		
	
		//<input type="image" name="login" value="Login" alt="Login" border="0" src="/images/forms/submit.gif" width="60" height="23">
		
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		
		Log.info("successfully lunched to nextpage");
		
		
		//<a href="mercurywelcome.php">Home</a>
		//<a href="mercuryreservation.php">Flights</a>
		//<a href="mercuryunderconst.php">Hotels</a>
		//<a href="mercuryunderconst.php">Car Rentals</a>
		
		
		
	
		java.util.List <WebElement> links = driver.findElements(By.tagName("a"));
	
			int linkscount = links.size();
	
			Log.info("the number of links is:" +linkscount);
			
			for(int i=0;i<=linkscount-1;i++)
			{
				 String linksname = links.get(i).getText();
				 
				 Log.info(i + " " +linksname);
				 
				 
				 
				
			}
			
			
		
		}
	
	}
	
	
	


