package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class XlUtility {
	
	public static FileInputStream fileInput;
	public static Workbook workBook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	
	
	
	public static int getRowCount(String XlFile, String sheetName) throws IOException {
		
		fileInput= new FileInputStream(XlFile);
		workBook=WorkbookFactory.create(fileInput);
		sheet=workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		fileInput.close();
		return rowCount;
	}
	
	public static int getColCount(String XlFile, String sheetName, int rowNum) throws IOException {
		
		fileInput= new FileInputStream(XlFile);
		workBook=WorkbookFactory.create(fileInput);
		sheet=workBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int colCount=row.getLastCellNum();
		workBook.close();
		fileInput.close();
		return colCount;
	}
	
	public static String getCellData(String XlFile, String sheetName, int rowNum, int colNum) throws IOException {
		
		fileInput=new FileInputStream(XlFile);
		workBook=WorkbookFactory.create(fileInput);
		sheet=workBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		String value=cell.toString();
		workBook.close();
		fileInput.close();
		return value;
		
		
	}

}
