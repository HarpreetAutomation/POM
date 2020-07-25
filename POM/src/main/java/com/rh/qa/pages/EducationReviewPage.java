package com.rh.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;

public class EducationReviewPage extends TestBase{

	@FindBy(xpath="//div[@class='outer-wrapper']/h1[text()='Education']/following-sibling::p[text()='Where did you go to school?']")
	WebElement educationHeaderSubHeader;
	
	@FindBy(xpath="//button[@id='btnSaveAndNext' and text()='Save & Next']")
	WebElement educationCTA;
	
	public EducationReviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHeader()
	{
		return educationHeaderSubHeader.isDisplayed();
	}
	
	public void clickEducationCTA() {
		educationCTA.click();
	}
	
	
}
