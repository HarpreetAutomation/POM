package com.rh.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;

import com.rh.qa.base.TestBase;

import io.qameta.allure.Attachment;

public class TestAllureReportListener extends TestBase implements ITestListener
{
	

	private static String getTestMethodName(ITestResult iTestResult) 
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) 
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) 
	{
		return html;
	}

	//@Override
	public void onStart(ITestContext iTestContext) 
	{
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", TestBase.getDriver());
	}

	public void onFinish(ITestContext iTestContext)
	{
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	public void onTestStart(ITestResult iTestResult) 
	{
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	public void onTestSuccess(ITestResult iTestResult) 
	{
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	public void onTestFailure(ITestResult iTestResult) 
	{
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = TestBase.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver)
		{
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			String methodName = getTestMethodName(iTestResult);
			//saveScreenshotPNG(driver);
			try {
				takeScreenshot(iTestResult);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");		
	}



	public void onTestSkipped(ITestResult iTestResult) 
	{
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) 
	{
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}
