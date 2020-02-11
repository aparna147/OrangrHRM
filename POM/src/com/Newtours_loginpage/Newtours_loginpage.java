package com.Newtours_loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newtours_loginpage
{
	
	//<a href="mercurysignon.php">SIGN-ON</a>
	
	@FindBy(linkText= "SIGN-ON")
	WebElement signOn;
	
	public void signOn()
	{
		signOn.click();
	}
	
	
	//<a href="mercuryregister.php">REGISTER</a>
	
	@FindBy(linkText ="REGISTER")
	WebElement register;

	public void register()
	{
		register.click();
	}
	
	//<input maxlength="60" name="userName" size="20">
	//<input maxlength="60" name="password" size="20" type="password">
	//<input type="image" name="login" value="Login" alt="Login" border="0" src="/images/forms/submit.gif" width="60" height="23">
	
	
	@FindBy(name ="userName")
	WebElement UserName;
	
	
	@FindBy(name ="password")
	WebElement Password;
	
	@FindBy(name = "login")
	WebElement signon;
	
	public void findAFlight (String userName , String password)
	{
		UserName.clear();
		UserName.sendKeys(userName);
		Password.clear();
		Password.sendKeys(password);
		
		
		
		
		
		
		
		
	}
}
