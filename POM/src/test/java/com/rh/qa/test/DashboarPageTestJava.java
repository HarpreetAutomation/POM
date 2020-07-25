package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.Finalize;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;

public class DashboarPageTestJava extends TestBase {
	
	LandingPage lp;
	LoginPage loginpage;
	Dashboard dashboard;
	Finalize finalpage;
	
	public DashboarPageTestJava()
{
		super();
}
	//testcases should be independent
	//before each test case launch the browser and login
	//after each test case close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		LandingPage lp = new LandingPage();
		lp.LandingClick();
		loginpage = new LoginPage();
		dashboard = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyDashboardpageTitletest()
	{
		String DashboardPageTitle = dashboard.verifyDashboardPageTitle();
		Assert.assertEquals(DashboardPageTitle, "Dashboard | ResumeHelp", "Dashboard Title not matched");
	}
	
	@Test(priority=2)
	public void verifyDashboardTexttest()
	{
		dashboard.verifyDashboardText();
	}
	
	@Test(priority=3)
	public void navigatetoFinalizepage()
	{
		finalpage = dashboard.clickonEditResume();
	}
	
	@AfterMethod
	public void tearDown()
		{
			driver.quit();
		}

}
