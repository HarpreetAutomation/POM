package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class LandingPage extends TestBase 
{
	
	//Page Factor - OR
	 
 		@FindBy(xpath="//*[@href='/resume/how-it-works' and contains(text(),'get started')]")           
 		WebElement getStarted;
 		
 		@FindBy(xpath="//*[@href='/user/login' and contains(text(),'Sign in')]")
 		WebElement getSignIn;
 		
 		//Initializing the Page Objects
	 	public LandingPage()
	 	{
	 		PageFactory.initElements(driver, this);
	 	}
		public HIWPage Landing()
	 	{
			getStarted.click();
	 		return new HIWPage();
	 		
	 	}
		
		public LoginPage LandingClick()
	 	{
			getSignIn.click();
	 		return new LoginPage();
	 		
	 	}
		//Actions:
	 	public String validateLandingPageTitle()
	 	{
	 		return driver.getTitle();
	 	}
}
