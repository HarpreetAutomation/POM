package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class EducationDescription extends TestBase{
	
	//Page Factor - OR
		@FindBy(xpath="//*[@id='btnSaveAndNext']")
		WebElement eduDescSaveNext;
		
		@FindBy(xpath="//ul[@id='prewrittenExamplesUL']/li[1]//span[text()='Add']")
		WebElement eduDescAddExample;
		
	
	//Initializing the Page Objects
	public EducationDescription()
	{
	 	PageFactory.initElements(driver, this);
	}
	
	public EducationReviewPage eduDescClick()
	{
		eduDescAddExample.click();
		eduDescSaveNext.click();
		return new EducationReviewPage();
	}

}
