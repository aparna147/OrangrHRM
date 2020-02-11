package automationchrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogInPage {

	public static void main(String[] args) {
String URL="http://bing.com";

		System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		String expected_BingHomePageTitle="bing";
		System.out.println("The Expected Bing Home page is:"+expected_BingHomePageTitle);

		String actual_BingHomePageTitle=driver.getTitle();
		System.out.println("The Title of the Bing Home page is:"+"actual_BingHomePageTitle");
		if(actual_BingHomePageTitle.equalsIgnoreCase(expected_BingHomePageTitle))
		{
			System.out.println("Title is matched_PASS");
		}
		else {System.out.println("Title not matched_FAIL");
			}

		}
		

	}


