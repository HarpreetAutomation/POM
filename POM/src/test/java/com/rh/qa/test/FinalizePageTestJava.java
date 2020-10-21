package com.rh.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.Contact;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.Finalize;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;

public class FinalizePageTestJava extends TestBase {
	
	LandingPage lp;
	LoginPage loginpage;
	Dashboard dashboard;
	Finalize finalpage;
	Contact contact;
	
	
	public FinalizePageTestJava()
{
		super();
}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		LandingPage lp = new LandingPage();
		lp.LandingClick();
		loginpage = new LoginPage();
		dashboard = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		finalpage = dashboard.clickonEditResume();
		contact = finalpage.selectContactSection();
	}
		
	@AfterMethod
	public void tearDown()
		{
			driver.quit();
		}
}
