package com.rh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class Education extends TestBase{
	
	//Page Factor - OR
	//Initializing the Page Objects
	
	@FindBy(xpath="//div[@class='outer-wrapper']/h1[text()='Education']")
	WebElement educformheader;
	
	@FindBy(xpath="//div[@class='outer-wrapper']/p[text()='Where did you go to school?']")
	WebElement educformsubheader;
	
	@FindBy(xpath="//div[@class='cta-container clearfix']/a[text()='Back']")
	WebElement educformback;
	
	@FindBy(xpath="//label[text()='School Name']")
	WebElement educformschoollabel;
	
	@FindBy(xpath="//input[@id='txtSchool']")
	WebElement educformschooltext;
	
	@FindBy(xpath="//label[text()='City']")
	WebElement educformcitylabel;
	
	@FindBy(xpath="//input[@id='txtCity']")
	WebElement educformcitytext;
	
	@FindBy(xpath="//label[text()='State']")
	WebElement educformstatelabel;
	
	@FindBy(xpath="//input[@id='txtState']")
	WebElement educformstatetext;
	
	@FindBy(xpath="//select[@id='ddlDegree']/parent::div/parent::div/label[text()='Degree']")
	WebElement educformdegreelabel;
	
	@FindBy(xpath="//select[@id='ddlDegree']/following-sibling::div/span[text()='Select Your Degree']")
	WebElement educformdegreedropdown;
	
	@FindBy(xpath="//select[@id='ddlDegree']/following-sibling::div//ul//li[text()='+ Enter your own Degree']")
	WebElement educdegree;
	
	@FindBy(xpath="//input[@id='txtOwnDegree']")
	WebElement educdegreevalue;
	
	@FindBy(xpath="//span[text()='Graduation Date']")
	WebElement educgraduatedatelabel;
	
	@FindBy(xpath="//select[@id='ddlStartMonth']/following-sibling::div")
	WebElement educmonth;
	
	
	@FindBy(xpath="//select[@id='ddlStartMonth']/following-sibling::div//ul//li[text()='Jan']")
	WebElement educmonthvalue;
	
	@FindBy(xpath="//span[@id='errStartDateMsg' and text()='Please provide both Month and Year']")
	WebElement educgradyearvalidation;
	
	@FindBy(xpath="//select[@id='ddlStartYear']/following-sibling::div")
	WebElement educyear;
	
	@FindBy(xpath="//select[@id='ddlStartYear']/following-sibling::div//ul//li[text()='2017']")
	WebElement educyearvalue;

	
	@FindBy(xpath="//div[@id='divFieldOfStudy']//label[text()='Field of Study']")
	WebElement educfieldofstudylabel;
	
	@FindBy(xpath="//input[@id='txtFieldOfStudy']")
	WebElement educfieldofstudyvalue;

	@FindBy(id="btnSaveAndNext")
	WebElement btnSave;
	
	public Education()
	{
	 		PageFactory.initElements(driver, this);
	}
	
	public SkillTips Next()
	{
		btnSave.click();
	 		return new SkillTips();
	}
	
	 	
	public EducationReviewPage clickNext()
	{
		btnSave.click();
	 		return new EducationReviewPage();
	}
	
	public EducationTips verifyBackCTA() {
		educformback.click();
		return new EducationTips();
	}

	public String validateEudcationPageTitle()
 	{
 		return driver.getTitle();
 	}

	public EducationReviewPage verifyBrowserBack() {
		driver.navigate().back();
		return new EducationReviewPage();
	}
	
	public EducationDescription EducationFormDetails(String name, String city, String state, String FieldStudy)
	{
		educformschooltext.sendKeys(name);
		educformcitytext.sendKeys(city);
		educformstatetext.sendKeys(state);
		educfieldofstudyvalue.sendKeys(FieldStudy);
	
		btnSave.click();
		
		return new EducationDescription();
		
	}
	
	

}
