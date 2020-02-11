package newTourAppLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver=null;

	String url="http://www.newtours.demoaut.com/";
	@BeforeTest
	//@BeforeTest
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");

	driver=new ChromeDriver();

	//driver.navigate().to(url);
	 driver.navigate().to(url);
	    
	}

}
