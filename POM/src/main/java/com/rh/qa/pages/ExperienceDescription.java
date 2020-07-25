package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class ExperienceDescription extends TestBase {
	
	//Page Factor - OR
	@FindBy(xpath="//*[@id='btnSaveAndNext']")
	WebElement expDescSaveNext;
	
	@FindBy(xpath="//ul[@id='prewrittenExamplesUL']/li[1]//span[text()='Add']")
	WebElement expDescAddExample;
	
	public ExperienceDescription()
 	{
 		PageFactory.initElements(driver, this);
 	}
	
	public void expAddExample()
	{
		expDescAddExample.click();
	}

	public ExperienceReview expDescClick()
	{
		expDescAddExample.click();
		
		expDescSaveNext.click();
		return new ExperienceReview();
	}
	

}
