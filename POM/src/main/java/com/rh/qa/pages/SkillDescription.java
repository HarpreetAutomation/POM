package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class SkillDescription extends TestBase  {
	
		//Page Factor - OR
		@FindBy(xpath="//*[@id='btnSaveAndNext']")
		WebElement nextBtn;
		
		@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
		WebElement skilldescback;
		
		@FindBy(xpath="//ul[@id='prewrittenExamplesUL']/li[1]//span[text()='Add']")
		WebElement skillDescAddExample;
			
	    //Initializing the Page Objects
	 	public SkillDescription()
	 	{
	 		PageFactory.initElements(driver, this);
	 	}
	 	
		public SummaryTips nextClick()
		{
			nextBtn.click();
			return new SummaryTips();
		}
		
		public SkillTips backClick()
		{
			skilldescback.click();
			return new SkillTips();
		}
		
		public String validateSkillDescriptionPageTitle()
	 	{
			return driver.getTitle();
	 	}
		
		public SummaryTips skillDescClick()
		{
			skillDescAddExample.click();
			nextBtn.click();
			return new SummaryTips();
		}

}
