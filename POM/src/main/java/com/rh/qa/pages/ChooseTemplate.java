package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class ChooseTemplate extends TestBase {
	
	@FindBy(xpath="//div[@id='rgSkinWrap']//div[@data-skin-cd='CLS1']//button[text()='Start with this template']")
	WebElement chooseTemplate;
	
	@FindBy(xpath="//button[@id='btnSaveColor' and contains(text(),'SELECT THIS TEMPLATE')]")
	WebElement chooseTemplateCTA;
	
	//Initializing the Page Objects
 	public ChooseTemplate()
 	{
 		PageFactory.initElements(driver, this);
 	}
 
	//Actions:
 	public String validateChooseTemplatePageTitle()
 	{
 		return driver.getTitle();
 	}
 	
	public Upload CT()
 	{
		chooseTemplateCTA.click();
		//chooseTemplate.click();
 		return new Upload();
 		
 	}

}
