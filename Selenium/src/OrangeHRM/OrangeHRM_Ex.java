package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Ex {

	
	public static void main(String[] args) {
		
		String url="https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\Driver File\\chromedriver.exe");

	    ChromeDriver driver = new ChromeDriver();
	    
	    driver.navigate().to(url);
	    
	   // <div id="logInPanelHeading">LOGIN Panel</div>
	    
	    
	    WebElement LoginPanel =driver.findElement(By.id("logInPanelHeading"));
	     
	   
	    String expected_OrangeLoginPage = "LOGIN Panel";

		System.out.println(" the expected home page is :" +expected_OrangeLoginPage);

		String actual_OrangeWebPage =  LoginPanel.getText();

		System.out.println("the actual home page is :"+actual_OrangeWebPage);

		if (expected_OrangeLoginPage.equals(actual_OrangeWebPage))
		{
		System.out.println("login successful-PASS");
		}
		else
		{
		System.out.println("login failed-fail");
		}

	    
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");

		// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

		driver.findElement(By.name("txtPassword")).sendKeys("admin123");

		// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

		WebElement SignIn = driver.findElement(By.name("Submit"));

		SignIn.click();
		
				
		WebElement Welcome_Admin= driver.findElement(By.id("welcome"));
		
		String expected_OrangeHRMLoginPage="Welcome_Admin";
		
		System.out.println(" the expected home page is :" +expected_OrangeHRMLoginPage);

		String actual_LoginPage = Welcome_Admin.getText();

		System.out.println("the actual home page is :"+actual_LoginPage);

		if (expected_OrangeHRMLoginPage.contains(actual_LoginPage))
		{
		System.out.println("login successful-PASS");
		}
		else
		{
		System.out.println("login failed-fail");
		}
		
	}
}