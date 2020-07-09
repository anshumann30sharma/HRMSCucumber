package com.syntax.DB;

import java.sql.*;
import java.util.*;

import org.junit.*;

import com.hrms.utils.*;

public class JDBCDemo extends JDBCUtil {

//	String dbUsername = "syntax_hrm";
//	String dbPassword = "syntaxhrm123";
//	JDBC: driver type:hostname:port/dbName
//	String url = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void dataBaseDemo() throws SQLException {
		executeCode("select * from hs_hr_employees");

		System.out.println("EmployeeID "+"\t"+"FirstName " +"\t"+ "LastName"+"\n============================================");
		while (getResultSet().next()) {
			String empID = getResultSet().getString("employee_id");
			String columnData = getResultSet().getString("emp_firstname");
			String columnData1 = getResultSet().getString("emp_lastname");
			System.out.println(empID + "\t\t" + columnData + "\t\t" + columnData1);

		}
	}
	
	// retrieve all the job titles and store them in arraylist and show it in 
	//console it from arraylist

//	@Test
	public void dataBaseDemo1() throws SQLException{

	executeCode("select job_title from ohrm_job_title");

		List<String> jobTitle=new ArrayList<>();
		
		while (getResultSet().next()) {
			jobTitle.add(getResultSet().getString("job_title"));
		}
		
		//Showing/Printing Job Titles from ArrayList
		System.out.println("Job Title"+"\n===========");
		
		for(String s:jobTitle) {
			System.out.println(s);
			
		}

	}

}
