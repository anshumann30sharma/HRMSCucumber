package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook book;
	private static Sheet sheet;
	public static void openExcel(String filePath) {
		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}
	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	//Creating Cell Header
	public static void createCellHeader(int colIndex, String ColName) {
		sheet.getRow(0).getCell(colIndex).setCellValue(ColName);
		
	}
	
	public static void createCellData(int rowIndex,int colIndex, String data) {
		sheet.getRow(rowIndex).getCell(colIndex).setCellValue(data);
	}
	
	//return a 2D object array of data 
	public static Object[][] excelIntoArray(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		int rows = rowCount();
		int cols = colsCount(0);
		Object[][] data = new Object[rowCount()-1][colsCount(0)];
		//iterating rows
		for(int i = 1; i < rows; i++) {
			//iterating cols
			for(int j = 0; j < cols; j++) {
				data[i-1][j] = cellData(i, j);
			}
		}
		return data;
	}
	
	public static void writeToExcel(String filePath, String sheetName,int rowIndex,int colIndex, String dataValue) {
		openExcel(filePath);
		loadSheet(sheetName);
		createCellHeader(colIndex, dataValue);
		if(rowIndex!=0) {
		createCellData(rowIndex, colIndex, dataValue);
		}
		try {
			FileOutputStream fos=new FileOutputStream(filePath);
			book.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
