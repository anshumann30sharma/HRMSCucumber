package com.hrms.utils;

import java.sql.*;
import java.util.*;

import org.junit.*;

public class JDBCUtil {

	/**
	 * DataBase Login Credentials
	 */
	private static String dbUsername = "syntax_hrm";
	private static String dbPassword = "syntaxhrm123";
	// JDBC: driver type:hostname:port/dbName
	private static String url = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	/**
	 * variables to interact with DataBase Declared as private to use only within
	 * this JDBC Utility class
	 */
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static ResultSetMetaData rsMetadata;
	private static DatabaseMetaData dbMetaData;

	/**
	 * This Method is for Establishing DB Connection before every Test runs. It also
	 * creates statement object.
	 */
	@BeforeClass
	public static void DBConnection() {

		try {
			connection = DriverManager.getConnection(url, dbUsername, dbPassword);
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection NOT successful");
		}
	}

	/**
	 * This Method will take DB Query as String and will Run it.
	 * 
	 * @param query
	 */
	public static void executeCode(String query) {
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method returns resultSet of executed Query
	 * 
	 * @return
	 */
	public static ResultSet getResultSet() {
		return resultSet;
	}

	/**
	 * This is a getter for connection objects.
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		return connection;
	}

	public static void DBInfo() {

		String driverName = null, driverVersion = null, dbVersion = null, dbProductName = null;
		try {
			dbMetaData = connection.getMetaData();
			driverName = dbMetaData.getDriverName();
			dbVersion = dbMetaData.getDatabaseProductVersion();
			dbProductName = dbMetaData.getDatabaseProductName();
			driverVersion = dbMetaData.getDriverVersion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DataBase & Driver information" + "\n===============================");
		System.out.println("Driver Name 	:\t" + driverName);
		System.out.println("Driver Version 	:\t" + driverVersion);
		System.out.println("DB Version 	:\t" + dbVersion);
		System.out.println("DB Product Name :\t" + dbProductName);
	}

	/**
	 * This is a getter for Database Metadata object
	 * 
	 * @return
	 */
	public static DatabaseMetaData getDbMetaData() {
		return dbMetaData;
	}

	/**
	 * This Method will create ResultSetMetaData Object after Running
	 * "executeCode()" method;
	 * 
	 * @throws SQLException
	 */
	public static void initializeRsMetadata() {
		try {
			rsMetadata = getResultSet().getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This getter will return ResultSetMetaData object after running
	 * 'executeCode()' method. without running executeCode Method this getter will
	 * return NullPointer Exception;
	 * 
	 * @return ResultSetMetaData object
	 */
	public static ResultSetMetaData getRsMetadata() {
		initializeRsMetadata();
		return rsMetadata;
	}

	/**
	 * This Method is to Store Query Data in List of Maps
	 * 
	 * @param SQL Query as String
	 * @return List<Map<String, String>>;
	 */
	public static List<Map<String, String>> dataListMap(String Query) {
		List<Map<String, String>> dataList = new ArrayList<>();
		try {
			executeCode(Query);
			initializeRsMetadata();
			int colNum = getRsMetadata().getColumnCount();
			while (getResultSet().next()) {
				Map<String, String> dMap = new LinkedHashMap<>();
				for (int i = 1; i <= colNum; i++) {
					String colName = getRsMetadata().getColumnName(i);
					String data = getResultSet().getObject(i).toString();
					dMap.put(colName, data);
				}
				dataList.add(dMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public static Map<String, String> SingleDBDataMap(String query) {
		Map<String, String> singleMap = new LinkedHashMap<>();

		try {
			executeCode(query);
			initializeRsMetadata();
			int colNum = getRsMetadata().getColumnCount();

			while (getResultSet().next()) {
				for (int i = 1; i <= colNum; i++) {
					String key = getRsMetadata().getColumnLabel(i);
					String value = getResultSet().getString(i);
					singleMap.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleMap;
	}

	@AfterClass
	public static void closeDB() {

		try {
			if (!resultSet.isClosed()) {
				resultSet.close();
			} else if (!statement.isClosed()) {
				statement.close();
			} else if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
