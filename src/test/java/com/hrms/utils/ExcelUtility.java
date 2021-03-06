package com.hrms.utils;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

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

	// Creating Cell Header
	public static void createCellHeader(int colIndex, String ColName) {
		sheet.getRow(0).getCell(colIndex).setCellValue(ColName);

	}

	public static void createCellData(int rowIndex, int colIndex, String data) {
		sheet.getRow(rowIndex).getCell(colIndex).setCellValue(data);
	}

	// return a 2D object array of data for DataProvide in TextNG
	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		openExcel(filePath);
		loadSheet(sheetName);
		int rows = rowCount();
		int cols = colsCount(0);
		Object[][] data = new Object[rowCount() - 1][colsCount(0)];
		// iterating rows
		for (int i = 1; i < rows; i++) {
			// iterating cols
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = cellData(i, j);
			}
		}
		return data;
	}

	/**
	 * This method is for writing in Excel Test Data File
	 * 
	 * @param filePath  of Excel Test Data
	 * @param sheetName of Test data
	 * @param rowIndex  of Test Data for Header
	 * @param colIndex  of Empty colum
	 * @param dataValue from the web application to save in Excel
	 */
	public static void writeToExcel(String filePath, String sheetName, int rowIndex, int colIndex, String dataValue) {
		openExcel(filePath);
		loadSheet(sheetName);
		createCellHeader(colIndex, dataValue);
		if (rowIndex != 0) {
			createCellData(rowIndex, colIndex, dataValue);
		}
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			book.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method is for converting Excel data into List of Maps
	 * @param filePath of Excel Data File
	 * @param sheetName of Excel Data File
	 * @return List of Map as a String
	 */
	public static List<Map<String, String>> excelIntoListOfMap(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);
		
		List<Map<String, String>> mapList = new ArrayList<>();

		Map<String, String> excelMap;

		for (int row = 1; row < rowCount(); row++) {

			excelMap = new LinkedHashMap<>();

			for (int col = 0; col < colsCount(row); col++) {

				String key = cellData(0, col);
				String value = cellData(row, col);

				excelMap.put(key, value);
			}
			mapList.add(excelMap);
		}
		return mapList;
	}
}
