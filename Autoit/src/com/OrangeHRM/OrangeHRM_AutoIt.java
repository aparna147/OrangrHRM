package com.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM_AutoIt 
{
	WebDriver driver = null;
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	
	public void setUp()
	{
		
	//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Autoit\\Driver File\\geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Autoit\\Driver File\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.navigate().to(url);
		
		/*//<button id="details-button" class="secondary-button small-link">
        
		WebElement advance = driver.findElement(By.id("details-button"));
		
		advance.click();
		
		//<a href="#" id="proceed-link" class="small-link">Proceed to localhost (unsafe)</a>
		
		WebElement proceed = driver.findElement(By.id("proceed-link"));
		
		proceed.click(); */
	}
	
	@Test(priority=1)
	
	public void login()
	
	{
		//<input name="txtUsername" id="txtUsername" type="text">
		
		WebElement userName = driver.findElement(By.name("txtUsername"));
		
		userName.sendKeys("Admin");
		
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		
		WebElement password = driver.findElement(By.name("txtPassword"));
		
		password.sendKeys("admin123");
		
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		
		WebElement submit = driver.findElement(By.name("Submit"));
		
		submit.click();
		
	}
	
	@Test(priority=2)
	
	public void pim() throws InterruptedException, IOException
	{
		
		//<a href="/orangehrm-4.2/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
		
		WebElement PIM = driver.findElement(By.linkText("PIM"));
		
		PIM.click();
		
		Thread.sleep(1000);
		
		//<a href="/orangehrm-4.2/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		WebElement addEmployee = driver.findElement(By.linkText("Add Employee"));
		
		addEmployee.click();
		
		Thread.sleep(3000);
		
		//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		
		//WebElement 
		
		
		//<input class="duplexBox" type="file" name="photofile" id="photofile">
		
		//<input class="duplexBox" type="file" name="photofile" id="photofile">
		
		////*[@id="photofile"]
		
		
		WebElement firstName=driver.findElement(By.id("firstName"));
		firstName.sendKeys("Testing");
		
		WebElement lastName=driver.findElement(By.id("lastName"));
		lastName.sendKeys("hello");
		
		Thread.sleep(5000);
		
		// photofile
	//	WebElement ChooseFile = driver.findElement(By.id("photofile"));
		
		// //*[@id="photofile"]
		
		Thread.sleep(10000);
		
		WebElement ChooseFile =driver.findElement(By.xpath("//input[@id='photofile']"));
				
		
		ChooseFile.click();
		
		Thread.sleep(10000);
		
		java.lang.Runtime.getRuntime().exec(".//AutoItScripts//profileImageUpload.exe");
		
		
		
		
		
	
	}

}
