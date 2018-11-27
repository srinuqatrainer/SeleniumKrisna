package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_WriteOperation {

	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\TestDataFiles\\KrishanSingleTestDataFile.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		Row r=sheet.createRow(2);
		Cell c=r.createCell(3);
		
		c.setCellValue("Hello");
		
		FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"\\src\\com\\TestDataFiles\\KrishanSingleTestDataFile1.xlsx");
		workBook.write(file1);

	}

}
