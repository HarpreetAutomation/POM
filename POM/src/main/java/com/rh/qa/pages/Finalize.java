package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class Finalize extends TestBase {
	
	@FindBy(xpath="//div[@class='name']/span[contains(text(),'CONTACT')]")
	WebElement ContactSection;
	
	//Initializing the Page Objects
	 	public Finalize()
	 	{
	 		PageFactory.initElements(driver, this);
	 	}
	 	
	 	public String verifyFinalizePageTitle(){
	 		return driver.getTitle();
	 	}
	 	
	 	public Contact selectContactSection(){
	 		ContactSection.click();
	 		return new Contact();
	 	}

}
