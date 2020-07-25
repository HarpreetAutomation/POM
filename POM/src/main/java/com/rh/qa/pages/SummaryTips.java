package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class SummaryTips extends TestBase {
	
	//Page Factor - OR
	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//div[@class='steps tips-container']/h1[text()='Tips for your Summary section']")	
 	WebElement summtipheader;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
 	WebElement summtipback;
 	
 	//@FindBy(xpath="//div[@class='steps tips-container']/ul/li[2][text()="Keep the phrases short and action-oriented("proven leader", "skilled researcher", etc.)."]
 	//WebElement educsecondtip;
 	
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[2][text()='Make sure you write your summary in present tense.']")
 	WebElement summsecondtip;
 		
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[3][text()='Impress employers by tailoring your summary to the job description.']")
 	WebElement summthirdtip;
 	 	 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
	WebElement backBtn;
		
    //Initializing the Page Objects
 	public SummaryTips()
 	{
 		PageFactory.initElements(driver, this);
 	}
 	
	public SummaryDescription nextClick()
	{
		nextBtn.click();
		return new SummaryDescription();
	}
	
	public boolean verifyHeader()
	{
		return summtipheader.isDisplayed();
	}

	public boolean verifySecondTip() 
	{
    	return summsecondtip.isDisplayed();
	}

    public boolean verifyThirdTip() 
    {
		return summthirdtip.isDisplayed();
	}

	public SkillTips verifyBackCTA() 
	{
		backBtn.click();
		return new SkillTips();
	}
		
	 public SummaryDescription verifyNextButton() 
	{
		nextBtn.click();
		return new SummaryDescription();
	}
		
	public SkillTips verifyBrowserBack() 
	{
		driver.navigate().back();
		return new SkillTips();
	}
}
