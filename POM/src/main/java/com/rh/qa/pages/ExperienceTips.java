package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class ExperienceTips extends TestBase 
{
	
	//Page Factor - OR
	@FindBy(xpath="//*[@class='button-primary float-right' and contains(text(),'Next')]")
	WebElement expNext;
		
	@FindBy(id="btnskip")
	WebElement expSkip;
		
	//Initializing the Page Objects
 	public ExperienceTips()
 	{
 		PageFactory.initElements(driver, this);
 	}
 	
 	public String validateExperienceTipsPageTitle()
 	{
 		return driver.getTitle();
 	}
 	
	public Experience ExpTipsNext()
 	{
		expNext.click();
		return new Experience();
 	}
	
	public Experience expPopUp()
	{
		expSkip.click();
		return new Experience();
	}
	
}
