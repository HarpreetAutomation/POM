package com.rh.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rh.qa.base.TestBase;

public class Experience extends TestBase{
	
	//Page Factor - OR
		@FindBy(xpath="//*[@id='btnSaveAndNext']")
		WebElement expSaveNext;
			
		@FindBy(xpath="//*[@id='btnskip']")
		WebElement expSkip;
		
		@FindBy(xpath="//*[@id='txtEmployer']")
		WebElement expEmployer;
		
		@FindBy(xpath="//*[@id='txtCity']")
		WebElement expCity;
		
		@FindBy(xpath="//*[@id='txtJobTitle']")
		WebElement expJobtitle;
		
		@FindBy(xpath="//div[@id='div_ddlStartMonth' and contains(@class,'nice-select wide')]")
		WebElement expStartMonth;
		
		@FindBy(xpath="//select[@id='ddlStartMonth']/following-sibling::div[@class='nice-select wide drop-up open']/ul/li[text()='Jan']")
        WebElement expStartMonthVal;
		
	    @FindBy(xpath="//div[@id='div_ddlEndMonth' and contains(@class,'nice-select wide')]")
		WebElement expEndMonth;
	
	    @FindBy(xpath="//select[@id='ddlEndMonth']/following-sibling::div[@class='nice-select wide drop-up open']/ul/li[text()='Jan']")
        WebElement expEndMonthVal;
	    
	    @FindBy(xpath="//select[@id='ddlStartYear']/following-sibling::div[contains(@class,'nice-select wide')]/span")
	    WebElement expstartyear;
	    
	    @FindBy(xpath="//select[@id='ddlStartYear']/following-sibling::div[contains(@class,'nice-select wide drop-up open')]//ul/li[text()='2018']")
	    WebElement expstartyearval;
	    	    
	    @FindBy(xpath="//select[@id='ddlEndYear']/following-sibling::div[contains(@class,'nice-select wide')]/span")
	    WebElement expendyear;
	    
	    @FindBy(xpath="//select[@id='ddlEndYear']/following-sibling::div[contains(@class,'nice-select wide drop-up open')]//ul/li[text()='2020']")
	    WebElement expendyearval;
	    
		  
		
						
		//Initializing the Page Objects
	 	public Experience()
	 	{
	 		PageFactory.initElements(driver, this);
	 	}
	 	
	 	public String validateExperiencePageTitle()
	 	{
	 		return driver.getTitle();
	 	}
				
		public Experience expClick()
		{
			expSaveNext.click();
			return new Experience();
		}
		
		public EducationTips expSkipPopUp()
		{
			expSkip.click();
			return new EducationTips();
		}
		
		public ExperienceDescription ExperienceDetails(String emp, String add, String city) throws InterruptedException
		{
			expEmployer.sendKeys(emp);
			expCity.sendKeys(add);
			expJobtitle.sendKeys(city);
			expStartMonth.click();
			Thread.sleep(2000);
			expStartMonthVal.click();
			Thread.sleep(2000);
			
			expstartyear.click();
			Thread.sleep(2000);
			expstartyearval.click();
			Thread.sleep(2000);
			
			expEndMonth.click();
			Thread.sleep(2000);
			expEndMonthVal.click();
			Thread.sleep(2000);
			
			expendyear.click();
			Thread.sleep(2000);
			expendyearval.click();
			Thread.sleep(2000);
			
			
			expSaveNext.click();
			
			return new ExperienceDescription();
			
		}
		
		public ExperienceDescription ExperienceFormDetails(String emp, String add, String city) throws InterruptedException
		{
			expEmployer.sendKeys(emp);
			expCity.sendKeys(add);
			expJobtitle.sendKeys(city);
			expStartMonth.click();
			Thread.sleep(2000);
			expStartMonthVal.click();
			Thread.sleep(2000);
			
			expstartyear.click();
			Thread.sleep(2000);
			expstartyearval.click();
			Thread.sleep(2000);
			
			expEndMonth.click();
			Thread.sleep(2000);
			expEndMonthVal.click();
			Thread.sleep(2000);
			
			expendyear.click();
			Thread.sleep(2000);
			expendyearval.click();
			Thread.sleep(2000);
			
			expSaveNext.click();
			
			return new ExperienceDescription();
			
		}
		
		public ExperienceDescription ExperienceClick() throws InterruptedException
		{
			
			expSaveNext.click();
			return new ExperienceDescription();
		}
		
	
		
		
		
}
