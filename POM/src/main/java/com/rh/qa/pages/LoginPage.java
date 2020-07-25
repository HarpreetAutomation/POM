package com.rh.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class LoginPage extends TestBase 
		{
		//Page Factor - OR
	 
	 	@FindBy(id="UserName")
		WebElement username;
	 	
	 	@FindBy(id="Password")
		WebElement password;
	 	
	 	@FindBy(id="loginSubmit")
	 	WebElement LoginBtn;
	 	
	 	@FindBy(xpath="//div[@class='login-form']//a[text()='Sign Up']")
	 	WebElement SignUpLink;
	 	
	 	@FindBy(xpath="//div[@class='login-form']//a[text()='Sign Up']")
	 	WebElement RHLogo;
	 	
	 	//Initializing the Page Objects
	 	public LoginPage()
	 	{
	 		PageFactory.initElements(driver, this);
	 	}
	 	
	 	//Actions:
	 	public String validateLoginPageTitle()
	 	{
	 		return driver.getTitle();
	 	}
	 	
	 	public boolean validateRHLogo()
	 	{
	 		return RHLogo.isDisplayed();
	 	}
	 	
	 	public Dashboard Login(String un, String pwd)
	 	{
	 		username.sendKeys(un);
	 		password.sendKeys(pwd);
	 		LoginBtn.click();
	 		
	 		return new Dashboard();
	 		
	 	}
	 	
	 	public Dashboard newLogin(String un, String pwd)
	 	{
	 		username.sendKeys(un);
	 		password.sendKeys(pwd);
	 		LoginBtn.click();
	 		
	 		return new Dashboard();
	 		
	 	}
	 	
}
	 	
	 	
	 	


