package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.Contact;
import com.rh.qa.pages.Education;
import com.rh.qa.pages.EducationDescription;
import com.rh.qa.pages.EducationTips;
import com.rh.qa.pages.Experience;
import com.rh.qa.pages.ExperienceDescription;
import com.rh.qa.pages.ExperienceTips;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.Upload;
import com.rh.qa.util.TestUtil;

public class EducationPageTestJava extends TestBase {
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate Choose;
	Upload UP;
	Contact cnct;
	ExperienceTips exprtips;
	Experience exprform;
	EducationTips educationtips;
	Education educform;
	EducationDescription eduDesc;
	
	String sheetName = "Education";
	
	public EducationPageTestJava()
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
	}
	
	@Test(priority=1, groups="Tips")
	public void verifyEductionTipsHeader()
	{
		educform.verifyBackCTA();
		Assert.assertTrue(educationtips.verifyHeader(), "Header is missing on the page");
		
		Assert.assertTrue(educationtips.verifyThirdTip(), "Third Tip is not correct on the page");
		Assert.assertTrue(educationtips.verifyFourthTip(), "Fourth Tip is not correct on the page");
		educationtips.verifyNextButton();
	}
	
	@Test(priority=2,groups="Title")
	public void validateEducationPageTitle() throws InterruptedException
	{
	Thread.sleep(7000);
	String title = educform.validateEudcationPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Education | ResumeHelp");
	}
	
	@DataProvider
	public Object[][] getRHTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test( priority=3, dataProvider="getRHTestData", groups="TextValue")
	public void validateEducationPageDetails(String name, String city, String state, String FieldStudy) throws InterruptedException
	{
		EducationDescription eduDesc = educform.EducationFormDetails(name, city, state, FieldStudy);
		Thread.sleep(2000);						
		eduDesc.eduDescClick();
		Thread.sleep(2000);
	} 	 
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
