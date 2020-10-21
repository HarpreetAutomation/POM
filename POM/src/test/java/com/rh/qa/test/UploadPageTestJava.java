package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.Upload;


public class UploadPageTestJava extends TestBase
{
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate Choose;
	Upload UP;
	
	
	public UploadPageTestJava()
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
	}
	
	@Test(priority=1)
	public void UploadPageTitleTest() throws InterruptedException
	{
		
		/*Choose= new ChooseTemplate();
		try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		Choose = hiwpage.HIWclick();
	    	
	    	try
	        {
	            Thread.sleep(7000);
	        }
	        catch (InterruptedException e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } */
		Thread.sleep(7000);
		String title = UP.validateUploadPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Upload | ResumeHelp");
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}

