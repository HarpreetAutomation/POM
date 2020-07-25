package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class SummaryDescription extends TestBase  
{
	
         	//Page Factor - OR
			@FindBy(xpath="//button[@id='btnSaveAndNext']")
			WebElement nextBtn;
			
			@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
			WebElement summdescback;
			
			@FindBy(xpath="//ul[@id='prewrittenExamplesUL']/li[1]//span[text()='Add']")
			WebElement summDescAddExample;
				
			 //Initializing the Page Objects
		 	public SummaryDescription()
		 	{
		 		PageFactory.initElements(driver, this);
		 	}
	
			public SummaryTips nextClick()
			{
			nextBtn.click();
			return new SummaryTips();
			}
			
			public SummaryTips backClick()
			{
				summdescback.click();
				return new SummaryTips();
			}
			
			public void summDescClick()
			{
				summDescAddExample.click();
				nextBtn.click();
				
			}
		
			public String validateSummaryDescriptionPageTitle()
			{
			return driver.getTitle();
			}
}
