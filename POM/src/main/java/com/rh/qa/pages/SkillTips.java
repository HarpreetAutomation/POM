package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class SkillTips extends TestBase {
	//Page Factor - OR
 	@FindBy(xpath="//div[@class='steps tips-container']/h1[text()='Tips for your Skills section']")	
 	WebElement skilltipheader;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
 	WebElement skilltipback;
 	
 	//@FindBy(xpath="//div[@class='steps tips-container']/ul/li[2][text()="Keep the phrases short and action-oriented("proven leader", "skilled researcher", etc.)."]
 	//WebElement educsecondtip;
 		
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[3][text()='Make sure to use bullets instead of complete sentences.']")
 	WebElement skillthirdtip;
 	
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[4][text()='The perfect length is between 2-4 phrases per skill (you can elaborate in the interview).']")
 	WebElement skillfourthtip;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Next']")
	WebElement nextBtn;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
	WebElement backBtn;
 	
 	 //Initializing the Page Objects
 	public SkillTips()
 	{
 		PageFactory.initElements(driver, this);
 	}
 	
 	public boolean verifyHeader() {
		return skilltipheader.isDisplayed();
	}

	public boolean verifyThirdTip() {
		return skillthirdtip.isDisplayed();
	}

	public boolean verifyFourthTip() {
		return skillfourthtip.isDisplayed();
	}

	public Education verifyBackCTA() {
		backBtn.click();
		return new Education();
	}
	
	public SkillDescription verifyNextButton() {
		nextBtn.click();
		return new SkillDescription();
	}
	
	public Education verifyBrowserBack() {
		driver.navigate().back();
		return new Education();
	}
		
   	public SkillDescription nextClick()
	{
		nextBtn.click();
		return new SkillDescription();
	}
}
