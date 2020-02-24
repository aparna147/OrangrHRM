package com.orangeHRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM
{
WebDriver driver = null;
	
	String url = "https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login";	
	//String url = "https://opensource-demo.orangehrmlive.com/";

	@BeforeTest
	
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
		
		 driver = new ChromeDriver();	
		 driver.navigate().to(url);
		
		//<button id="details-button" class="secondary-button small-link">
        driver.findElement(By.id("details-button")).click();
		
		//<a href="#" id="proceed-link" class="small-link">Proceed to localhost (unsafe)</a>
		driver.findElement(By.id("proceed-link")).click();
		
	}
	@Test(priority=1)
	
	public void loginTest() throws IOException
	{
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		WebElement Login_Panel = driver.findElement(By.id("logInPanelHeading"));
		
		String Expected_LoginPage = "LoginPanel";
		System.out.println("The expected home page is :" +Expected_LoginPage);
		
		String Actual_LoginPage = Login_Panel.getText();
		System.out.println("The actual home page is :"+Actual_LoginPage);
		
		if (Expected_LoginPage.equals(Actual_LoginPage))
		{
			System.out.println("Succesfully login PASS");
		}
		
		else
			
		{
			System.out.println("Login Failed FAIL");
		}
		
		//FileInputStream file1 = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\propertyfilesO\\congf.properties");
		FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\OHRM_Login.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		//Properties properties = new Properties();
		//properties.load(file1);
				
		for (int i=1;i<=rowcount;i++)
		{
			Row row = sheet.getRow(i);
		
		// <input name="txtUsername" id="txtUsername" type="text">	
		WebElement Username = driver.findElement(By.id("txtUsername"));
		Username.clear();
		Username.sendKeys(row.getCell(0).getStringCellValue());
		
		// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys(row.getCell(1).getStringCellValue());

		// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		WebElement SignIn = driver.findElement(By.name("Submit"));
		SignIn.click();
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>	
		WebElement Welcome_Admin = driver.findElement(By.linkText("Welcome Admin"));		
		String expected_Text="Welcome Admin";
		System.out.println("The expected result is :"+expected_Text);
						
		String actual_Text = Welcome_Admin.getText();
		System.out.println(" The actual text is :"+actual_Text );
	    if(actual_Text.contains(expected_Text))
		{
	    	System.out.println(" LogIN Successfull - PASS");
			row.createCell(2).setCellValue("LogIN Successfull - PASS");
		    //driver.navigate().back();
		}
	    else
		{
			System.out.println(" LogIn Failed - FAIL");
			row.createCell(2).setCellValue("LogIn Failed - FAIL");
		}
	    //<a href="/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>	
	    WebElement OrangePIM = driver.findElement(By.id("menu_pim_viewPimModule"));	
		Actions act = new Actions(driver);
		act.moveToElement(OrangePIM).perform();
		//OrangePIM.click();
		
		//<a href="/orangehrm-4.2/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		WebElement EmployeeList = driver.findElement(By.id("menu_pim_addEmployee"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(OrangePIM).perform();
		//EmployeeList.click();
			
		WebElement Add_Employee = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")); 	
		String Expected_page = "Add Employee";	
		String Actual_Result = Add_Employee.getText();
			
		if (Actual_Result.contains(Expected_page))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	}
}	
@Test(priority=2)
public void employeeID() throws IOException
	{
		//FileInputStream file1 = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\propertyfilesO\\congf.properties");
		
		FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\OHRM_Login.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		//Properties properties = new Properties();
		
		//properties.load(file1);
				
		for (int i=1;i<=rowcount;i++)
		{
			Row row = sheet.getRow(i);
			//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
			
			WebElement FirstName = driver.findElement(By.name("firstName"));
			FirstName.clear();
			FirstName.sendKeys(row.getCell(0).getStringCellValue());
			
			//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
			
			WebElement MiddleName = driver.findElement(By.name("middleName"));
			MiddleName.clear();
			MiddleName.sendKeys(row.getCell(1).getStringCellValue());
			
			//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
			
			WebElement LastName = driver.findElement(By.name("lastName"));
			LastName.clear();
			LastName.sendKeys(row.getCell(2).getStringCellValue());
			
			//<input class="formInputText" maxlength="10" type="text" name="employeeId" value="0002" id="employeeId">
			
			WebElement EmpID = driver.findElement(By.name("employeeId"));
			String employee_Id=EmpID.getAttribute("value");
			System.out.println(employee_Id);
			
			//<input type="button" class="" id="btnSave" value="Save">
			
			WebElement Save = driver.findElement(By.id("btnSave"));
			Save.click();
			
		}
	}
@AfterTest
public void tearDown()
{
	driver.quit();
}

}
