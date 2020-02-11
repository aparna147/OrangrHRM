package com.OHRM_LoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest 
{
	
	public WebDriver driver = null;
	public String url="https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login";
	
	//https://localhost/orangehrm-4.2/symfony/web/index.php/auth/login
	
	public String UserName="admin";
	public String Password="Livetech@123";
	
	@Given("^Open Browser and Navigate to OrangeHRM$")
	public void Open_Browser_and_Navigate_to_OrangeHRM() throws Throwable
	
	{
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@When("^User enters UserName and Password and click LoginButton$")
	public void User_enters_UserName_and_Password_and_click_LoginButton() throws Throwable 
	{
	    
		
	}

	@Then("^User should be able to successfully login to the apllication and close the Application$")
	public void User_should_be_able_to_successfully_login_to_the_apllication_and_close_the_Application() throws Throwable {
	    
	}

	

}
