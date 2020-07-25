package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class Dashboard extends  TestBase {
	
	@FindBy(xpath="//li[@class='dropdown']/a[contains(text(),'My Documents')]")
	//@CacheLookup 
	WebElement MyDocumentHeading;
	
	@FindBy(xpath="//li[@class='dropdown']/a[contains(text(),'Learning Guides')]")
	WebElement LearningGuideHeading;
	
	@FindBy(xpath="//a[@class='c_dc_Edit_Document']/i[@class='fa fa-edit']")
	WebElement EditResume;
	
	@FindBy(xpath="//div[@class='notify-content']/h3[contains(text(),'Looks like you have')]")
	WebElement DashboardText;

	//Initializing the Page Objects
 	public Dashboard()
 	{
 		PageFactory.initElements(driver, this);
 	}
 	
 	
 	public String verifyDashboardPageTitle(){
 		return driver.getTitle();
 	}
 	
 	public boolean verifyDashboardText()
 	{
 	  return DashboardText.isDisplayed();
 	 
 	}
 	
 	public Finalize clickonEditResume(){
 		Actions action = new Actions(driver);
 		action.moveToElement(EditResume).build().perform();
 		EditResume.click();
 		return new Finalize();
 		
 	}
}
