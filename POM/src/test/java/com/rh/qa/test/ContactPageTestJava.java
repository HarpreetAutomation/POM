package com.rh.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rh.qa.base.TestBase;
import com.rh.qa.pages.ChooseTemplate;
import com.rh.qa.pages.Contact;
import com.rh.qa.pages.Dashboard;
import com.rh.qa.pages.HIWPage;
import com.rh.qa.pages.LandingPage;
import com.rh.qa.pages.LoginPage;
import com.rh.qa.pages.Upload;
import com.rh.qa.util.ExcelUtil;
import com.rh.qa.util.TestUtil;
import com.rh.qa.excellib.util.*;


public class ContactPageTestJava extends TestBase {
	
	LandingPage lp;
	HIWPage hiwpage;
	ChooseTemplate Choose;
	Upload UP;
	Contact cnct;
	//ExcelUtil eu = new ExcelUtil();
	//String sheetname = prop.getProperty("ContactSheetName");

	
	//Xls_Reader reader = new Xls_Reader("./src/main/java/com/rh/qa/excellib/util/Book1.xlsx");
	 String sheetName = "Contact";
	
	public ContactPageTestJava()
	{
		super();
	}
	//Pre-condition annotation
	//@BeforeSuite
	//@BeforeClass
	//@BeforeTest
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
	}
		
		@Test(priority=1, groups="Title")
		public void validateContactPageTitleTest() throws InterruptedException
		{
		Thread.sleep(7000);
		String title = cnct.validateContactPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Contact | ResumeHelp");
		}
		
		@DataProvider
		public Object[][] getRHTestData()
		{
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test( priority=2, dataProvider="getRHTestData", groups="TextValue", dependsOnMethods="validateContactPageTitleTest")
		public void validateContactDetails(String name, String address, String city, String state, String zipcode)
		{
			cnct.ContactDetails(name, address, city, state, zipcode);
		} 
	
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
