package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;

public class HIWPageTestJava extends TestBase 
{
	LandingPage lp;
	HIWPage hiwpage;
	public HIWPageTestJava()
{
		super();
}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		LandingPage lp = new LandingPage();
		hiwpage = lp.Landing();
	}
	
	@Test(priority=1)
	public void HIWPageTitleTest()
	{
		String title = hiwpage.validateHIWPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "How It Works | ResumeHelp");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
