package com.syntax.DB;

import java.sql.*;
import org.junit.*;

import com.hrms.testbase.JDBCUtil;

public class MetaData extends JDBCUtil {

//	@Test
	public void dbMetaData() throws SQLException {
//		DatabaseMetaData dbMetaData = getConnection().getMetaData();
//		String driverName = dbMetaData.getDriverName();
//		String dbVersion = dbMetaData.getDatabaseProductVersion();
//		String dbProductName = dbMetaData.getDatabaseProductName();
//		System.out.println("Driver Name 	:\t" + driverName);
//		System.out.println("DB Version 	:\t" + dbVersion);
//		System.out.println("DB Product Name :\t" + dbProductName);
		DBInfo();
		System.out.println("Major Driver Version: "+getDbMetaData().getDriverMajorVersion());
	}

	// Query==>Display all the info about employee whose emp_number is 6961;

	@Test
	public void resultSetMetadata() throws SQLException {

		executeCode("select * from hs_hr_employees where emp_number=6961");
		
		int colNumbers = getRsMetadata().getColumnCount();

		System.out.println("Total Column= " + colNumbers);

//		Getting column header name by Column index
		String colNames = getRsMetadata().getColumnName(1);
		System.out.println("First Column Name is : "+colNames);

		//Printing/getting all column names through 'for loop';
		System.out.println("DBColumn / Data field names"+"\n====================");
		for (int i = 1; i <= colNumbers; i++) {
			colNames = getRsMetadata().getColumnName(i);
			System.out.println(colNames);

		}
	}
	
	// hw get the resultset metadata store it in the arraylist and retrieve it from arraylist 
	// also get column type name get the table names

}
