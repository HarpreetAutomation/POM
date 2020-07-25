package com.rh.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class HIWPage extends TestBase {
	
	@FindBy(xpath="//*[@id='btnCreateResume']")
	WebElement buildYourResume;
		
//Initializing the Page Objects
public HIWPage()
{
 	PageFactory.initElements(driver, this);
}
 	
//Actions:
public String validateHIWPageTitle()
{
	return driver.getTitle();
}
 	
	public ChooseTemplate HIWclick() throws InterruptedException
 	{   
		Thread.sleep(2000);
		//driver.findElement(By.id("btnCreateResume")).click();
		buildYourResume.click();
		
		return new ChooseTemplate();
 		
 	}
	
	
	
	
}
