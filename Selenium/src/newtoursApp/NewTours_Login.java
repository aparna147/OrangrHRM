package newtoursApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_Login {
	
	//String url = "http://www.newtours.demoaut.com/"
			
			
			WebDriver driver = null;
			String url = "http://www.newtours.demoaut.com/";

			@BeforeTest
			public void Setup()
			{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}


			@Test (priority=1)
			public void Registration()
			{
			WebElement register=driver.findElement(By.linkText("REGISTER"));
			register.click();
			}
			@Test(priority=2)
			public void register_LoginPage() throws IOException
			{
				
				FileInputStream file1 = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\propertyfilenew\\newtour.properties");
				
				FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\newtoursdata.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet("sheet1");
				
				int rowcount = sheet.getLastRowNum();
				
				Properties properties = new Properties();
				properties.load(file1);
				
				
				for (int i=1;i<=rowcount;i++)
				{
				Row row = sheet.getRow(i);
				
				
				//<input maxlength="60" name="firstName" size="20">
				
				WebElement fristname = driver.findElement(By.name(properties.getProperty("firstname")));
				fristname.clear();
				fristname.sendKeys(row.getCell(0).getStringCellValue());
				
				//<input maxlength="60" name="lastName" size="20">
				

				WebElement lastname = driver.findElement(By.name(properties.getProperty("lastname")));
				lastname.clear();
				lastname.sendKeys(row.getCell(1).getStringCellValue());
				
		/*double d=row.getCell(2).getNumericCellValue();
				long x = (long)d;
				String phonenumber=Long.toString(x);*/
				
				//<input maxlength="20" name="phone" size="15">
			
				

				double d=row.getCell(2).getNumericCellValue();
				long x=(long)d;
				String phoneNumber=Long.toString(x);
				WebElement phoneno = driver.findElement(By.name (properties.getProperty("phone")));
				phoneno.clear();
				phoneno.sendKeys(phoneNumber);
				
				
				//<input name="userName" id="userName" size="35" maxlength="64">
				
				
				WebElement email = driver.findElement(By.name(properties.getProperty("EMAIL")));
				email.clear();
				email.sendKeys(row.getCell(3).getStringCellValue());
				
				//<input maxlength="60" name="address1" size="40">
				
				
				WebElement address= driver.findElement(By.name(properties.getProperty("adress")));
				address.clear();
				address.sendKeys(row.getCell(4).getStringCellValue());
				
				//<input maxlength="60" name="city" size="15">
				
				
				WebElement city= driver.findElement(By.name(properties.getProperty("city")));
				city.clear();
				city.sendKeys(row.getCell(5).getStringCellValue());
				
				//<input maxlength="40" name="state">
				
				
				WebElement state= driver.findElement(By.name(properties.getProperty("state/province")));
				state.clear();
				state.sendKeys(row.getCell(6).getStringCellValue());
				
				
				double c=row.getCell(7).getNumericCellValue();
				long y = (long)c;
				String postalcode=Long.toString(y);
				
				
				//<input maxlength="20" name="postalCode" size="15">
				

				WebElement postalCode= driver.findElement(By.name(properties.getProperty("postalcode")));
				postalCode.clear();
				postalCode.sendKeys(postalcode);
				
				///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select
				
				
				WebElement country= driver.findElement(By.name(properties.getProperty("country")));
				//country.clear();
				country.sendKeys(row.getCell(8).getStringCellValue());
				
				//<input name="email" id="email" size="20" maxlength="60">
				
				WebElement uname= driver.findElement(By.name(properties.getProperty("username")));
				uname.clear();
				uname.sendKeys(row.getCell(9).getStringCellValue());
				
				//<input maxlength="60" name="password" size="20" type="password">
				
				WebElement password= driver.findElement(By.name(properties.getProperty("password")));
				password.clear();
				password.sendKeys(row.getCell(10).getStringCellValue());
				
				//<input maxlength="60" name="confirmPassword" size="20" type="password">
				
				
				WebElement confrimpassword= driver.findElement(By.name(properties.getProperty("confirm")));
				confrimpassword.clear();
				confrimpassword.sendKeys(row.getCell(11).getStringCellValue());
				
			}
			}
				
			
			
			


	
	
}
