package com.hrms.testbase;

import java.sql.*;

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

//	/**
//	 * This is a getter for connection objects.
//	 * @return
//	 */
//	public static Connection getConnection() {
//		return connection;
//	}

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

	@AfterClass
	public static void closeDB() {

		try {
			if (!connection.isClosed()) {
				connection.close();
			} else if (!statement.isClosed()) {
				statement.close();
			} else if (!resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
