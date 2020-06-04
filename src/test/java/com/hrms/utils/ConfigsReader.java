package com.hrms.utils;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigsReader {
	
	public static Properties prop;
	
	/**
	 * Method for reading Properties file based on given file path.
	 * This method will load the file with Properties instance of "prop".
	 * it method will show FileNotFoundException if File Path is not correct.
	 * @param filePath
	 */
	
	public static void propertiesReader(String filePath) {
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return value of specified key
	 * @param String key
	 * @return String value
	 */
	public static String getProperty(String key) {
		ConfigsReader.propertiesReader(Constants.PROPERITESFILE_PATH);
		return prop.getProperty(key);
	}
	
	
	
	/**
	 * 
	 * This Method will read Excel file from specified path & Sheet Name and
	 * Convert data into List of Map;
	 * @param filePath
	 * @param sheetName
	 * @return List of Map<String, String>
	 */
	
	public static List<Map<String,String>> excelReader(String filePath, String sheetName){
		List<Map<String,String>> mapList=new LinkedList<>();
		Workbook workbook = null;
		try {
			FileInputStream fis=new FileInputStream(filePath);
			workbook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Sheet sheet=workbook.getSheet(sheetName);
		
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getLastCellNum();
		
		for(int r=1;r<row;r++) {
			Map<String,String> map=new LinkedHashMap<>();
			
			for(int c=0;c<col;c++) {
				String key=sheet.getRow(0).getCell(c).getStringCellValue();
				String value=sheet.getRow(r).getCell(c).toString();
				map.put(key,value);
			}
			mapList.add(map);
		}
		
		return mapList;
		
	}

}
