package automationchrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class Automationchrome_Ex {
 public static void main(String[] args)
	{
	

		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
	
		
		 ChromeDriver cd = new ChromeDriver();
		cd.get("http://amazon.com");
		cd.close();
	}

}
