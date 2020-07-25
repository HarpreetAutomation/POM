package com.rh.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.Contact;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.Experience;
import com.rh.qa.pages.ExperienceDescription;
import com.rh.qa.pages.ExperienceTips;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;
import com.rh.qa.pages.Upload;
import com.rh.qa.util.TestUtil;

public class ExperiencePageTestJava extends TestBase {
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate Choose;
	Upload UP;
	Contact cnct;
	ExperienceTips exprtips;
	Experience exprform;
	
	String sheetName = "Experience";
	
	public ExperiencePageTestJava()
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
	}
	
	@Test(priority=1, invocationCount=1, expectedExceptions=InterruptedException.class)
		public void validateExperiencePageTitle() throws InterruptedException
		{
		Thread.sleep(7000);
		String title = exprform.validateExperiencePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Experience | ResumeHelp");
		Assert.assertEquals(title, "Experieence | ResumeHelp", "Title is not matched.");
		}
	
		@DataProvider
		public Object[][] getRHTestData()
		{
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}

     	@Test(priority=2, dependsOnMethods="validateExperiencePageTitle", dataProvider="getRHTestData", groups="TextValue")
	    public void validateExperienceDetails(String emp, String address, String city) throws InterruptedException
	    {
		ExperienceDescription expDesc = exprform.ExperienceFormDetails(emp, address, city);
		Thread.sleep(2000);						
		expDesc.expDescClick();
		Thread.sleep(2000);
		}
		 
		@AfterMethod
	    public void tearDown()
		{
			driver.quit();
		}
}
