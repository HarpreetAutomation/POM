package com.rh.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import com.rh.qa.util.TestUtil;
import com.rh.qa.util.WebEventListener;

public class TestBase 
	{
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	static String filePath = "C:\\Users\\harpreet.bhatia\\git\\POM\\POM\\Screenshot\\";
		
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C://Users//harpreet.bhatia//git//POM//POM//src//main//java//com//rh//qa//config//config.properties");
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
	
	public static WebDriver initialization() throws InterruptedException
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
			
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//	driver.manage().timeouts().pageLoadTimeout(arg0, arg1)
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			tdriver.set(driver);
			return getDriver();
			//return driver;
			
	 }
		public static synchronized WebDriver getDriver()
		{
			return tdriver.get();
		}
		
	public static void takeScreenshot(ITestResult results) throws IOException
		{
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try 
	            {
					FileUtils.copyFile(scrFile, new File(filePath + results.getName() + ".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) 
	            {
					e.printStackTrace();
				}
	    }
	}
		
			
			
			
		
	  
		
	
	
	


