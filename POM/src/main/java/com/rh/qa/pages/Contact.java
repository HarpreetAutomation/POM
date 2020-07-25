package com.rh.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rh.qa.base.TestBase;
import com.rh.qa.excellib.util.Xls_Reader;

import com.rh.qa.excellib.util.*;

public class Contact extends TestBase {
	
/*	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/rh/qa/excellib/util/Book1.xlsx");
		String sheetName = "Contact";
		int rowCount = reader.getRowCount(sheetName);
		
		for(int rowNumber=2; rowNumber<=3; rowNumber++){
			
			
		}
		
	}*/
	
	
	
	
	   
	
	@FindBy(id="btnSaveAndNext")
	WebElement contactSave;
	
	@FindBy(xpath="//div[@class='input-element']/*[@id='txtName']")
	WebElement contactName;
	
	
	
	@FindBy(xpath="//div[@class='input-element']/*[@id='txtAddress']")
	WebElement contactAddress;
	
	@FindBy(xpath="//*[@id='txtCity']")
	WebElement contactCity;
	
	@FindBy(xpath="//*[@id='txtState']")
	WebElement contactState;
	
	@FindBy(xpath="//*[@id='txtZipCode']")
	WebElement contactZipcode;
	
	//Initializing the Page Objects
	public Contact()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateContactPageTitle()
 	{
 		return driver.getTitle();
 	}
	
    public ExperienceTips cnct()
	{
		contactSave.click();
		return new ExperienceTips();
	}
 
   public void EnterName(String name)
   {
	driver.findElement(By.id("//div[@class='input-element']/*[@id='txtName']"));
   }
   
   public void createNewContactDetails(String nm, String add, String city, String st, String Zcd)
   {
   	contactName.sendKeys(nm);
   	contactAddress.sendKeys(add);
   	contactCity.sendKeys(city);
   	contactState.sendKeys(st);
   	contactZipcode.sendKeys(Zcd);
   	
   }	
   
   public ExperienceTips ContactDetails(String nm, String add, String city, String st, String Zcd)
	{
		contactName.sendKeys(nm);
	   	contactAddress.sendKeys(add);
	   	contactCity.sendKeys(city);
	   	contactState.sendKeys(st);
	   	contactZipcode.sendKeys(Zcd);
	   	contactSave.click();
		
		return new ExperienceTips();
		
	}
	
}
