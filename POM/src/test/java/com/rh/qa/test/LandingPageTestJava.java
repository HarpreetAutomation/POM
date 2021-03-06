package com.rh.qa.test;
//Testclass
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rh.qa.ExtentReportListener.TestAllureReportListener;
import com.rh.qa.base.TestBase;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;
@Listeners(
		{TestAllureReportListener.class}
	)
public class LandingPageTestJava extends TestBase 
	
	{
		LandingPage Lpage;
		HIWPage hiwpage;
		public LandingPageTestJava()
    {
			super();
    }
		@BeforeMethod
		public void setUp() throws InterruptedException
		{
			initialization();
			Lpage = new LandingPage();
	    }
		
		@Test(priority=1)
		public void landingPageTitleTest()
		{
			String title = Lpage.validateLandingPageTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Resume Help: Instantly Create Your Resume Online");
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
