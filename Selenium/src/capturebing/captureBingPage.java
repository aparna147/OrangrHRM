package capturebing;

import org.openqa.selenium.chrome.ChromeDriver;

public class captureBingPage 
{

	public static void main(String[] args) {
		String url="http://Bing.com";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe" );
		ChromeDriver driver =  new ChromeDriver();
		driver.navigate().to(url);
		String actual_BingHomePageTitle=driver.getTitle();
		System.out.println("The title of the Bing Home Page is:" +actual_BingHomePageTitle );
		
		
	}

}

