package com.Newtours_testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BaseTest.Basetest;
import com.Newtours_loginpage.Newtours_loginpage;

public class NewToursTestCases extends Basetest
{
	Newtours_loginpage NewToursTestcases= null;
	
	@Test(priority=1)
	public void signon()
	{
		
		NewToursTestcases = PageFactory.initElements(driver, Newtours_loginpage.class);
		
		
		NewToursTestcases.signOn();
		
	}
	@Test(priority=2)
	
	public void register()
	{
		
		NewToursTestcases = PageFactory.initElements(driver, Newtours_loginpage.class);
		
		
		NewToursTestcases.register();
	}
		
	@Test(priority=3)
	
	public void findAFlightTest() throws IOException
	{
		NewToursTestcases = PageFactory.initElements(driver, Newtours_loginpage.class);
		
		FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\POM_New.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		Row row = sheet.getRow(1);
		
		NewToursTestcases.findAFlight(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		
		String expected_HomePageTitle="Find";
		System.out.println("The expected Title of the New Tours Home Page is:"+expected_HomePageTitle);
				
		String actual_WebPageTitle=driver.getTitle();
		System.out.println(" The actual title of the NewTours WebPage is :"+actual_WebPageTitle );
				
		if(actual_WebPageTitle.contains(expected_HomePageTitle))
		{
			System.out.println(" LogIN Successfull - PASS");
			row.createCell(2).setCellValue("LogIN Successfull - PASS");
		}
		else
		{
				System.out.println(" LogIn Failed - FAIL");
				row.createCell(2).setCellValue("LogIn Failed - FAIL");
		}
				
		driver.navigate().back();
		
		FileOutputStream file1 = new FileOutputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\POM_New.xlsx");
		workbook.write(file1);
	}
}






















/*//extends BaseTest{


NewTours_LogInPage newTours_LogInPage = null;

@Test(priority=1)
public void signOnTest()
{	
	
	newTours_LogInPage= PageFactory.initElements(driver, NewTours_LogInPage.class);

	newTours_LogInPage.SignOn();

	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	System.out.println();

}*/