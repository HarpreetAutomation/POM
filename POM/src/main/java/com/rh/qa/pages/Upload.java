package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class Upload extends TestBase {
	@FindBy(xpath="//*[@id='btnCreateNewResume']")
	WebElement uploadYourResume;
	
	//Initializing the Page Objects
	public Upload()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateUploadPageTitle()
 	{
		return driver.getTitle();
 	}
	
    public Contact cnct()
	{
		uploadYourResume.click();
		return new Contact();
	}
}
