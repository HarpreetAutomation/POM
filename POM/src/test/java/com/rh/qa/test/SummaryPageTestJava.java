package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.Contact;
import com.rh.qa.pages.Education;
import com.rh.qa.pages.EducationTips;
import com.rh.qa.pages.Experience;
import com.rh.qa.pages.ExperienceTips;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.SkillDescription;
import com.rh.qa.pages.SkillTips;
import com.rh.qa.pages.SummaryDescription;
import com.rh.qa.pages.SummaryTips;
import com.rh.qa.pages.Upload;

public class SummaryPageTestJava extends TestBase {
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate Choose;
	Upload UP;
	Contact cnct;
	ExperienceTips exprtips;
	Experience exprform;
	EducationTips educationtips;
	Education educform;
	SkillTips skilltips;
	SkillDescription skill;
	SummaryTips summarytips;
	SummaryDescription summary;
	
	public SummaryPageTestJava()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		LandingPage lp = new LandingPage();
		hiwpage = lp.Landing();
		Choose = hiwpage.HIWclick();
		Thread.sleep(2000);
		UP = Choose.CT();	
		Thread.sleep(2000);
		cnct = UP.cnct();
		Thread.sleep(2000);
		exprtips = cnct.cnct();
		Thread.sleep(2000);
		exprform = exprtips.ExpTipsNext();
		Thread.sleep(2000);
		exprform = exprform.expClick();
		Thread.sleep(2000);
		educationtips = exprform.expSkipPopUp();
		Thread.sleep(2000);
		educform = educationtips.verifyNextButton();
		Thread.sleep(2000);
		skilltips = educform.Next();
		Thread.sleep(2000);
		skill = skilltips.nextClick();
		Thread.sleep(2000);
		summarytips = skill.nextClick();
		Thread.sleep(2000);
		summary = summarytips.nextClick();
		Thread.sleep(2000);
		
	}
	/*public void verifyEductionTipsHeader()
	{
		Assert.assertTrue(educationtips.verifyHeader(), "Header is missing on the page");
	}
	
	public void verifyEductionSecondTips()
	{
		Assert.assertTrue(educationtips.verifySecondTip(), "Header is missing on the page");
	}
	
	public void verifyEductionThirdTips()
	{
		Assert.assertTrue(educationtips.verifyThirdTip(), "Header is missing on the page");
	}
	
	public void verifyEductionFourthTips()
	{
		Assert.assertTrue(educationtips.verifyFourthTip(), "Header is missing on the page");
	}*/
	
	@Test(priority=1)
	public void validateSummaryDescriptionPageTitle() throws InterruptedException
	{
	Thread.sleep(7000);
	String title = summary.validateSummaryDescriptionPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Summary Description | ResumeHelp");
	}
	
	
	@Test(priority=2)
	public void verifySkillTipsHeader()
	{
		summary.backClick();
		Assert.assertTrue(summarytips.verifyHeader(), "Header is missing on the page");
		Assert.assertTrue(summarytips.verifySecondTip(),"Third tip is not correct on the page");
		Assert.assertTrue(summarytips.verifyThirdTip(), "Fourth Tip is not correct on the page");
		skilltips.nextClick();
	}
	
	@Test( priority=3, dataProvider="getRHTestData", groups="TextValue")
	public void validateSummaryPageDetails() throws InterruptedException
	{
		summary.summDescClick();
		Thread.sleep(2000);						
	} 	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
