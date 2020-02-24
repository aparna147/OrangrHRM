package com.orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Login {

	public static void main(String[] args) throws Exception {
		
		String url = "https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");

	    ChromeDriver driver = new ChromeDriver();
	    
	    //<button id="details-button" class="secondary-button small-link">
        
	    WebElement advance = driver.findElement(By.id("details-button"));
	    
	    advance.click();

		driver.navigate().to(url);
		Thread.sleep(2000);
		
		driver.findElement(By.id("details-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
		
		String expected_LoginPage = "LOGIN Panel";

		System.out.println(" the expected home page is :" +expected_LoginPage);

		String actual_OrangeWebPage = driver.getTitle();

		System.out.println("the actual home page is :"+actual_OrangeWebPage);

		if (expected_LoginPage.contains(actual_OrangeWebPage))
		{
		System.out.println("login successful-PASS");
		}
		else
		{
		System.out.println("login failed-fail");
		}

		// <input name="txtUsername" id="txtUsername" type="text">

		driver.findElement(By.name("txtUsername")).sendKeys("admin");

		// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

		driver.findElement(By.name("txtPassword")).sendKeys("Livetech@123");

		// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

		WebElement SignIn = driver.findElement(By.name("Submit"));

		SignIn.click();

		
		/*
		<a href="#" id="menu_admin_UserManagement" class="arrow">User Management</a>
		<a href="#" id="menu_admin_Job" class="arrow">Job</a>
		<a href="#" id="menu_admin_Organization" class="arrow">Organization</a>
		*/

		//WebElement Job = driver.findElement(By.linkText("Job"));

		//Job.click();

		List<WebElement>Links = driver.findElements(By.tagName("a"));

		int Linkscount = Links.size();

		System.out.println(" the total number of links are :"+Linkscount);

		for (int i=0;i<Linkscount;i++)

		{
		String LinkName = Links.get(i).getText();

		System.out.println(i + " " +LinkName);
		}


	}

}
