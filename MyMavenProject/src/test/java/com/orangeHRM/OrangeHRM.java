package com.orangeHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.navigate().to(url);
		
		//<button id="details-button" class="secondary-button small-link">
        
		driver.findElement(By.id("details-button")).click();
		
		//<a href="#" id="proceed-link" class="small-link">Proceed to localhost (unsafe)</a>
		
		driver.findElement(By.id("proceed-link")).click();
		
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	@Test
	
	public void loginTest() throws IOException
	{
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		WebElement Login_Panel = driver.findElement(By.id("logInPanelHeading"));
		//Login_Panel.click();
		
		String Expected_LoginPage = "LOGIN Panel";
		
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
		
		FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\MyMavenProject\\src\\test\\java\\com\\exceloperation\\OHRM_Login.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		//Properties properties = new Properties();
	   // properties.load(file1);
				
		for (int i=1;i<=rowcount;i++)
		{
			Row row = sheet.getRow(i);
		
		// <input name="txtUsername" id="txtUsername" type="text">

				
			
				WebElement Username = driver.findElement(By.name(""));
			
				//WebElement username = driver.findElement(By.name("txtUsername"));
				Username.clear();
				Username.sendKeys(row.getCell(0).getStringCellValue());

				// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

				WebElement password = driver.findElement(By.name(""));
				//WebElement password = driver.findElement(By.name("txtPassword"));
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
						
						if(actual_Text.equals(expected_Text))
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
						FileOutputStream file2 = new FileOutputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\OHRM_Login.xlsx");
						workbook.write(file2);
		
	}
	}


}
