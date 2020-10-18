package com.rh.qa.test;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;
import com.rh.qa.util.ExcelUtil;


public class LoginPageTestJava extends TestBase
	
{
		LoginPage loginpage;
		Dashboard dashboard;
		LandingPage landingpage;
		ExcelUtil eu = new ExcelUtil();
		String sheetname = prop.getProperty("SignInSheetName");
		
		public LoginPageTestJava()
{
			super();
}
	
			@BeforeMethod
		public void setUp()
		{
			try {
				initialization();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LandingPage landingpage = new LandingPage();
			loginpage=landingpage.LandingClick();
			//LoginPage loginpage = new LoginPage();
			//Dashboard dashboard= new Dashboard();
			
		}
		
		//	@Test(priority=1)
	//	public void loginPageTitleTest()
		//{
		//	String title = loginpage.validateLoginPageTitle();
		//	System.out.println(title);
	//		AssertJUnit.assertEquals(title, "Login | ResumeHelp");
			 
	//	}
			@Test(priority=2)
			public void VerifyLogin()
			{
				dashboard =	loginpage.Login(eu.ReadExcel(sheetname, 1, 2), eu.ReadExcel(sheetname, 2, 2));		
			//loginpage.sendKeys(eu.ReadExcel(sheetname, 1, 2));
				eu.WriteExcel(sheetname, 1, 3 , "Pass");
			//	loginpage.sendKeys(eu.ReadExcel(sheetname, 2, 2));
			//	dashboard = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
			}
			

	
			//	@Test(priority=3)
	//	public void loginPagevalidateRHLogo()
	//	{
	//		boolean flag = loginpage.validateRHLogo();
			//assert.assertTrue(flag);			
	//	}
		
		//	@Test(priority=4)
	//	public void loginTest()
	//	{
		//	dashboard = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		//}
		

        @AfterMethod
	    public void tearDown()
		{
			driver.quit();
		}
		
		
				
}
