package automationchrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class BingcaptureTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String URL="http://bing.com";
System.setProperty("webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.get(URL);
String Expected_HomePage ="Bing";
System.out.println("The expected result is:"+Expected_HomePage);
String actual_BingHomePageTitle=driver.getTitle();
System.out.println("The Title of the Bing Home page is:"+actual_BingHomePageTitle);



	}

}
