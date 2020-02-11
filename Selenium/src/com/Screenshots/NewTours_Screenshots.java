package com.Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_Screenshots
{
	WebDriver driver=null;

	String url="http://www.newtours.demoaut.com/";

	@BeforeTest
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");

	driver=new ChromeDriver();

	driver.navigate().to(url);

	}
		
	@Test(priority=1)
	public void regis() throws IOException

	{
	List <WebElement> links = driver.findElements(By.tagName("a"));

	int linkscount = links.size();

	System.out.println("the no.of"+linkscount);

	for (int i=0;i<linkscount;i++)
	{
	String linkname = links.get(i).getText();

	System.out.println(i + " "+linkname);

	links.get(i).click();



	//links = driver.findElements(By.tagName("a"));

	File newTourScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	FileUtils.copyFile(newTourScreenShot, new File("./screenshots/"+linkname+".png"));

	System.out.println(driver.getTitle());

	System.out.println(driver.getCurrentUrl());


	System.out.println();

	driver.navigate().back();

	links = driver.findElements(By.tagName("a"));


	}
	}
	@AfterTest
	public void tearDown()
	{

	driver.quit();
	
	}



}
