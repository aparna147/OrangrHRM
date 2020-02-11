package chromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverEx

{
	

	
	public static void main(String[] args)
	
	{
		
		String url="http://Bing.com";
		
	System.getProperty("Webdriver.chrome.driver","C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\chromeDriver\\ChromeDriverEx.java");
		
		ChromeDriver driver=new ChromeDriver();
		
	
		
driver.navigate().to(url);

String expected_BingHomePageTitle="bing";

System.out.println("the Expected Home Page title is:" +expected_BingHomePageTitle);

String actual_BingHomePageTitle=driver.getTitle();

System.out.println("The actual home page Tile  is:" + actual_BingHomePageTitle  );

if( actual_BingHomePageTitle.equalsIgnoreCase(expected_BingHomePageTitle))
	
{
	System.out.println("The Title is matched _PASS");
}
else
{
	System.out.println("the is not matched_FILE");
}
	}

}
