package com.rh.qa.excellib.util;

import com.rh.qa.excellib.util.*;

public class ExcelUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/rh/qa/excellib/util/Book1.xlsx");
		String sheetName = "Contact";
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
	
		int rowCount = reader.getRowCount(sheetName);
		System.out.println(rowCount);
		
		reader.addColumn(sheetName, "status");
		
		reader.addSheet("Experience");
		
		if(!   reader.isSheetExist("Experience")){
			reader.addSheet("Experience");	
		}
		reader.setCellData(sheetName, "status", 2, "PASS");
		
		
		
		}
		
		
	}


