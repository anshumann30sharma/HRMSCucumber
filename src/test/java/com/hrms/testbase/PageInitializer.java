package com.hrms.testbase;

import com.hrms.pages.*;


public class PageInitializer extends BaseClass {
	
	public static loginPageElements login;
	public static DashboardPageElements dashBoard;
	public static AddEmployee emp;
	public static EmployeeListPage empList;
	public static PersonalDetailsPage  pDetails;
	public static ReportsPageElements report;

	public static void initialize() {
		login = new loginPageElements();
		dashBoard = new DashboardPageElements();
		emp = new AddEmployee();
		empList = new EmployeeListPage();
		pDetails = new PersonalDetailsPage();
		report = new ReportsPageElements();

	}

}
