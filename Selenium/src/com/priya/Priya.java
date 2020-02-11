package com.priya;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Priya 
{
	WebDriver driver=null;
	//  rtu5String url="https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login";
	
	String url = "https://opensource-demo.orangehrmlive.com/";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		
	/*driver.findElement(By.id("details-button")).click();
		
		//<a href="#" id="proceed-link" class="small-link">Proceed to localhost (unsafe)</a>
		
		driver.findElement(By.id("proceed-link")).click();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);*/
	}
	@Test
	public void OrangeLogin_MultipleUsers() throws IOException
	{
		String expected_LoginPage="LOGIN Panel";
		//<div id="logInPanelHeading">LOGIN Panel</div>
		String actual_LoginPage=driver.findElement(By.id("logInPanelHeading")).getText();
		if(expected_LoginPage.equals(actual_LoginPage))
				{
			System.out.println("It's a Login Page-Pass");
				}
		else
		{
			System.out.println("It is not a Login Page-Fail");
		}
	FileInputStream file=new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\OHRM_Login.xlsx");
	XSSFWorkbook workBook=new XSSFWorkbook(file);
	XSSFSheet sheet = workBook.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum();
	for(int i=1;i<=rowCount;i++)
	{
		Row row =sheet.getRow(i);
		//<input name="txtUsername" id="txtUsername" type="text">
	WebElement userName=driver.findElement(By.id("txtUsername"));
	userName.clear();
	userName.sendKeys(row.getCell(0).getStringCellValue());

	//<input name="txtPassword" id="txtPassword" type="password" autocomplete="off">
	WebElement password=driver.findElement(By.id("txtPassword"));
	password.clear();
	password.sendKeys(row.getCell(1).getStringCellValue());

	//<input name="Submit" class="button" id="btnLogin" type="submit" value="LOGIN">
	WebElement login=driver.findElement(By.id("btnLogin"));
	login.click();
	String expected_page="http://localhost/orangehrm/symfony/web/index.php/dashboard";
	String current_WebPage=driver.getCurrentUrl();
	if(current_WebPage.contains(expected_page))
	{
	String expected_HomePage="Admin";
	//<a class="panelTrigger" id="welcome" href="#">Welcome Admin</a>
	String actual_HomePage=driver.findElement(By.id("welcome")).getText(); 

	if(actual_HomePage.contains(expected_HomePage))
	{
		System.out.println("Login successfull-Pass");
		Cell cell=row.createCell(2);
		cell.setCellValue("Login successfull-Pass");
		driver.navigate().back();
	}
	}
	else
	{
		System.out.println("Login unsuccessfull-Fail");
		Cell cell=row.createCell(2);
		cell.setCellValue("Login unsuccessfull-Fail");



	FileOutputStream file1=new FileOutputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\OHRM_Login.xlsx");
	workBook.write(file1);
	}
	}
	}
}


