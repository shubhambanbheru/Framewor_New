package com.guru.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.io.FileHandler;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src =new File("C:\\Users\\shubh\\OneDrive\\Desktop\\data.xlsx");
		
		try {
			FileInputStream fis =new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("File not found"+e.getMessage());
			
		}
		
		
	}
	
	public String getStringdata(String sheetname,int row,int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericdata(String sheetname,int row,int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

	
}
