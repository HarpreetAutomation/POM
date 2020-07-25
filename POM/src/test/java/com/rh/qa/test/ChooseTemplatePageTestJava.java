package com.rh.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;


public class ChooseTemplatePageTestJava extends TestBase
{
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate CT;
	
	
	public ChooseTemplatePageTestJava()
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
	public void CTPageTitleTest() throws InterruptedException
	{
		CT= new ChooseTemplate();
		try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	    	CT = hiwpage.HIWclick();
	    	
	    	try
	        {
	            Thread.sleep(7000);
	        }
	        catch (InterruptedException e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		String title = CT.validateChooseTemplatePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Choose Template | ResumeHelp");
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}
