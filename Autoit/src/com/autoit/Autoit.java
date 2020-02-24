package com.autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autoit {

	public static void main(String[] args)
	{
		WebDriver driver = null;
		
		String url = "file:///C:/Users/colruyt/Desktop/fileupload.html";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Autoit\\Driver File\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.navigate().to(url);
		
		//<input type="file" ,id="1" ,name="resumeupload">
		
		WebElement chooseFile = driver.findElement(By.id("1"));
		
		chooseFile.click();
		

	}

}
