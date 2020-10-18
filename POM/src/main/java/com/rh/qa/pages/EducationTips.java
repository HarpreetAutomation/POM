package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class EducationTips extends TestBase{
	
	//Page Factor - OR
 	@FindBy(xpath="//div[@class='steps tips-container']/h1[text()='Tips for your Education section']")	
 	WebElement eductipheader;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
 	WebElement eductipback;
 	
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[2][text()='If you’re still in school, mention your expected graduate date.]")
 	WebElement educsecondtip;
 		
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[3][text()='Only mention your high school degree if you didn't go to college.']")
 	WebElement educthirdtip;
 	
 	@FindBy(xpath="//div[@class='steps tips-container']/ul/li[4][text()='It’s optional to include any honors, awards, scholarships or professional certifications.']")
 	WebElement educfourthtip;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Next']")
	WebElement nextBtn;
 	
 	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
	WebElement backBtn;
 	
 	//Initializing the Page Objects
 	public EducationTips()
 	{
 		PageFactory.initElements(driver, this);
 	}
 	
 	public boolean verifyHeader() {
		return eductipheader.isDisplayed();
	}

	//public boolean verifySecondTip() {
		//return educsecondtip.isDisplayed();
	//}

	public boolean verifyThirdTip() {
		return educthirdtip.isDisplayed();
	}

	public boolean verifyFourthTip() {
		return educfourthtip.isDisplayed();
	}

	public Education verifyBackCTA() {
		backBtn.click();
		return new Education();
	}
	
	public Education verifyNextButton() {
		nextBtn.click();
		return new Education();
	}
	
	public Education verifyBrowserBack() {
		driver.navigate().back();
		return new Education();
	}
}

 	
 	
 

 	
 	
 	
 	
 			
 		
 		