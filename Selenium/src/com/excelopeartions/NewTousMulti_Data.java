package com.excelopeartions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTousMulti_Data 

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

	@Test
	public void logIn() throws IOException
	{
	        FileInputStream file=new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\multiNewtour.xlsx");

	        XSSFWorkbook workbook=new XSSFWorkbook(file);

	        XSSFSheet sheet=workbook.getSheet("Sheet1");

	        int rowCount=sheet.getLastRowNum();

	        System.out.println("Rows Count :"+rowCount);

	        for(int i=1;i<=rowCount;i++)
	        {
	        Row row=sheet.getRow(i);

	        String cell_Username=row.getCell(0).getStringCellValue();

	        System.out.println(i+""+cell_Username);

	        String cell_password=row.getCell(1).getStringCellValue();

	        System.out.println(i+ ""+cell_password);

	        WebElement username=driver.findElement(By.name("userName"));

	        username.sendKeys(cell_Username);

	        WebElement password=driver.findElement(By.name("password"));

	        password.sendKeys(cell_password);

	        driver.findElement(By.name("login")).click();

	        String expected_Title="Find";

	        String actual_webpageTitle=driver.getTitle();

	        System.out.println(actual_webpageTitle);

	        if(actual_webpageTitle.contains(expected_Title))
	        {
	        System.out.println("Login Success- PASS");

	        Cell cell2= row.createCell(2);

	        cell2.setCellValue("PASS");

	        FileOutputStream file1=new FileOutputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\multiNewtour.xlsx");

	        workbook.write(file1);

	        }
	        else
	        {

	        Cell cell2= row.createCell(2);

	        cell2.setCellValue("FAIL");

	        FileOutputStream file1=new FileOutputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\multiNewtour.xlsx");

	        workbook.write(file1);

	        System.out.println("Login Failed -FAIL ");
	        }

	        driver.navigate().back();

	        }

	}

	@AfterTest
	public void tearDown()
	{

	driver.quit();

	}

	}


