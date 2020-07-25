package com.rh.qa.util;

// @author HarpreetBhatia 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rh.qa.base.TestBase;

public class ExcelUtil extends TestBase 
{
   public String Filepath;
   public String Filename;
	File fileobj;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	
	public ExcelUtil()
	{
		try {
		Filepath = System.getProperty("user.dir"); 
	//	System.out.println(Filepath);
		Filename = Filepath+"\\src\\main\\java\\com\\rh\\qa\\testdata\\ContactPomFinal.xlsx";
	//	System.out.println(Filename);
		fileobj = new File(Filename);
		fis = new FileInputStream(fileobj);
		wb = new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}	
	}
		
		public String ReadExcel(String sheetname, int row, int cellnum)
		{
			System.out.println(Filepath);
			System.out.println(Filename);
			System.out.println(sheetname);
			sheet = wb.getSheet("Contact");
			String data = sheet.getRow(row).getCell(cellnum).getStringCellValue();
			return data;
			}
		
		public String getStringData(String sheetname, int row, int cellnum)
		{
			System.out.println(sheetname);
			sheet = wb.getSheet(sheetname);
			XSSFCell cell = sheet.getRow(row).getCell(cellnum);
			String data = sheet.getRow(row).getCell(cellnum).getStringCellValue();
			return data;
			}
		
		public String WriteExcel(String sheetname, int row, int cellnum, String data)
		{
			try{
			sheet = wb.getSheet(sheetname);
			fos = new FileOutputStream(fileobj);
			sheet.getRow(row).createCell(cellnum).setCellValue(data);
			//String data = sheet.getRow(row).getCell(cellnum).getStringCellValue();
			wb.write(fos);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			return data;
			}
}


