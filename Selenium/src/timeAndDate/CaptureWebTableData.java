package timeAndDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureWebTableData {
	WebDriver driver=null;

	String url="https://www.timeanddate.com/worldclock/";				

	@BeforeTest
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");

	driver=new ChromeDriver();

	driver.navigate().to(url);
	}
	
	
	@Test
	public void CapturecompleteWebTableData()
	{
		for(int i=1;i<=36;i++)
		{
			for(int j=1;j<=8;j++) 
			{
				///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
			
				String data = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data);
			}
	
			System.out.println();
		}	
	}
}
