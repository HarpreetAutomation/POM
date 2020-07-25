package com.rh.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.rh.qa.util.TestUtil;
import com.rh.qa.util.WebEventListener;

public class TestBase 
	{
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
	public TestBase()
	
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C://bold-noida-workspace//POM//src//main//java//com//rh//qa//config//config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
			public static void initialization()
			{
				
				String browserName = prop.getProperty("browser");
				if(browserName.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","C://Users//harpreet.bhatia//Desktop//RH_NEW_AUTOMATION//chromedriver//chromedriver.exe");
					driver = new ChromeDriver();
				}
				//else if(browserName.equals("FF"))
				//{
				//System.setProperty("webdriver.gecko.driver","C://Drivers//chromedriver.exe");
				//driver = new FirefoxDriver();
				//}
			

					
			/*	e_driver = new EventFiringWebDriver(driver);
			eventListener =  new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver; */
						 
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//	driver.manage().timeouts().pageLoadTimeout(arg0, arg1)
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			}
	  }
		
	
	
	


