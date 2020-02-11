package com.single;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.google.common.collect.Table.Cell;

public class Single_ReadData {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\colruyt\\Desktop\\Livetech\\Selenium\\src\\com\\exceloperation\\single.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(file);
	XSSFSheet sheet = workBook.getSheet("sheet1");
	 Row row = sheet.getRow(0);
	 Cell cell = row.getCell(0);
	 String data = cell.getStringCellValue();
	 System.out.println(data);
	   
	   
	   
	 
	
	}

}
