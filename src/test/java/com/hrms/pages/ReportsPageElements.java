package com.hrms.pages;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import com.hrms.testbase.*;
import com.hrms.utils.CommonMethod;

public class ReportsPageElements extends PIMMenu {

	public ReportsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath = "//h1[text()='Employee Reports']")
	public WebElement reportPanelHeader;

	@FindBy(id = "search_search")
	public WebElement reportSearchTxtBox;

	@FindBy(name = "_search")
	public WebElement searchBtn;

	@FindBy(name = "_reset")
	public WebElement resetBtn;

	@FindBy(id = "btnAdd")
	public static WebElement addBtn;

	@FindBy(id = "btnDelete")
	public WebElement deleteBtn;

	@FindBy(xpath = "//a[text()='Report Name']")
	public WebElement reportNameHeader;

	@FindBy(id = "ohrmList_chkSelectAll")
	public WebElement chkBoxSelectAll;

	@FindBy(xpath = "//td[@class='left']")
	public List<WebElement> reportNameTable;

	@FindBy(name = "chkSelectRow[]")
	public List<WebElement> chkBoxRNTable;

	@FindBy(linkText = "Run")
	public List<WebElement> runReportLink;

	@FindBy(xpath = "//a[text()='Edit']")
	public List<WebElement> editReportLink;

	/**
	 * Define Report Page Label
	 */
	@FindBy(xpath = "//h1[text()='Define Report']")
	public WebElement defineRPLabel;

	@FindBy(xpath = "//label[text()='Report Name']")
	public WebElement reportNameLabel;

	@FindBy(css = "input#report_report_name")
	public WebElement reportNameTextBox;

	@FindBy(xpath = "//label[text()='Selection Criteria']")
	public WebElement sCriteriaDDLabelName;

	@FindBy(id = "report_criteria_list")
	public WebElement reportSelectionCriteria1DD;

	/**
	 * 1st Selection Criteria option values:
	 * 
	 * 1-Employee Name 
	 * 2-Pay Grade 
	 * 3-Education 
	 * 4-Employment Status 
	 * 5-Service Period
	 * 6-Joined Date 
	 * 7-Job Title 
	 * 8-Language 
	 * 9-Skill 10-Age Group 11-Sub Unit
	 * 12-Gender 13-Location
	 * 
	 */
	@FindBy(xpath = "//select[contains(@id,'criteria')]/option")
	public List<WebElement> selectCriteriaDDOptions;

	@FindBy(id = "btnAddConstraint")
	public WebElement addBtnConstraint;

	@FindBy(xpath = "//*[contains(text(),'Selected Criteria')]")
	public WebElement sC2DDLabelName;

	@FindBy(xpath = "(//*[starts-with(text(),'Include')])[2]")
	public WebElement sC2DDIncludeLabelName;

	@FindBy(xpath = "(//*[@id='report_include_comparision'])[2]")
	public WebElement selectedCriteria2DD;

	/**
	 * options for selectedCriteria2DD: 
	 * value="1"==>Current Employees Only
	 * value="2"==>Current and Past Employees 
	 * value="3"==>Past Employees Only
	 */
	@FindBy(xpath = "//select[@id='report_include_comparision' and @class='valid']/option")
	public WebElement selectedCriteria2DDoptions;

	@FindBy(xpath = "//label[text()='Display Field Groups']")
	public WebElement dspFieldGroupLabelName;

	@FindBy(id = "report_display_groups")
	public WebElement dspFieldGroupDD;

	/**
	 * dspFieldGroupDD options=16
	 * 
	 * value="display_group_1"==>Personal value="display_group_2"==>Contact Details
	 * value="display_group_3"==>Emergency Contacts
	 * value="display_group_4"==>Dependents value="display_group_15"==>Memberships
	 * value="display_group_10"==>Work Experience
	 * value="display_group_11"==>Education value="display_group_12"==>Skills
	 * value="display_group_13"==>Languages value="display_group_14"==>License
	 * value="display_group_9"==>Supervisors value="display_group_8"==>Subordinates
	 * value="display_group_7"==>Salary value="display_group_6"==>Job
	 * value="display_group_5"==>Immigration value="display_group_16"==>Custom
	 * Fields
	 */
	@FindBy(xpath = "//select[@id='report_display_groups']/option")
	public List<WebElement> dspFieldGroupDDOptions;

	@FindBy(id = "btnAddDisplayGroup")
	public WebElement addDispGpBtn;

	@FindBy(xpath = "//label[text()='Display Fields']")
	public WebElement displayFieldLabel;

	@FindBy(id = "report_display_field_list")
	public WebElement displayFieldDD;

	/**
	 * displayFieldDD Options
	 * 
	 * value="display_field_9"==>Employee Id value="display_field_10"==>Employee
	 * Last Name value="display_field_11"==>Employee First Name
	 * value="display_field_12"==>Employee Middle Name
	 * value="display_field_13"==>Date of Birth
	 * value="display_field_14"==>Nationality value="display_field_15"==>Gender
	 * value="display_field_17"==>Marital Status value="display_field_18"==>Driver
	 * License Number value="display_field_19"==>License Expiry Date
	 * value="display_field_97"==>Other Id
	 */
	@FindBy(id = "report_display_field_list")
	public WebElement displayFieldDDOptions;

	@FindBy(id = "btnAddDisplayField")
	public WebElement addDisplayFieldBtn;

	@FindBy(id = "btnSave")
	public WebElement saveBtnDefineRP;

	@FindBy(id = "btnCancel")
	public WebElement cancelBtnDefineRP;

	@FindBy(xpath = "//*[@id='display_groups']/li[1]")
	public WebElement messageHeader;

	/**
	 * "*Required Field" message
	 */

	@FindBy(xpath = "//*[@class='required line']")
	public WebElement messageHeaderMsg;

	/**
	 * ************************************************************************
	 * ***Following WebElements will be enabled after Clicking ADD Button*******
	 * ************************************************************************
	 */

	/**
	 * Selection Criteria 1 DropDown List
	 */

	@FindBy(xpath = "//label[text()='Employee Name']")
	public WebElement employeeNameLabel;

	@FindBy(id = "employee_name_empName")
	public WebElement employeeNameTextBox;

	@FindBy(xpath = "//label[@for='report_employment_status']")
	public WebElement employmentStatusLabel;

	@FindBy(xpath = "//select[@id='report_employment_status']")
	public WebElement employmentStatusDD;

	/**
	 * Employment status DD Options:
	 * 
	 * value="0"==>selected="selected"==>All value="1"==>Employee
	 * value="5"==>Freelance value="7"==>Gig economy value="4"==>Independent
	 * contractor value="9"==>Internee value="10"==>Part Time Employee
	 * value="11"==>Seasonal Employee value="3"==>Self-Employee value="12"==>Summer
	 * Time Employee value="8"==>Super Contractor value="2"==>Worker
	 * value="6"==>Zero hours contract
	 */
	@FindBy(xpath = "//select[@id='report_employment_status']/option")
	public List<WebElement> employmentStatusDDOptions;

	@FindBy(xpath = "//label[@for='report_pay_grade']")
	public WebElement payGradeLabelName;

	@FindBy(xpath = "//select[@id='report_pay_grade']")
	public WebElement payGradeDDBox;

	/**
	 * value selected="selected"==>"-- Select --" value="1"==>Level 1
	 * value="2"==>Level 2 value="7"==>level 3 value="5"==>level 4
	 * 
	 */
	@FindBy(xpath = "//select[@id='report_pay_grade']/option")
	public List<WebElement> payGradeDDOptions;

	@FindBy(xpath = "//label[@for='report_job_title']")
	public WebElement jobTitleLabelName;

	/**
	 * JobTitle in DropDown List
	 * value="0"==>All
	 * value="11"==>Accountant
	 * value="23"==>API Tester
	 * value="9"==>Application Developer
	 * value="22"==>Automation Engineer
	 * value="21"==>CEO
	 * value="12"==>Chief Financial Officer
	 * value="1"==>Cloud Architect
	 * value="2"==>Cloud Consultant
	 * value="3"==>Cloud Product and Project Manager
	 * value="13"==>Controller
	 * value="25"==>CTO
	 * value="7"==>Data Quality Manager
	 * value="8"==>Database Administrator
	 * value="10"==>Developer
	 * value="20"==>Graphic Designer
	 * value="24"==>Instructor
	 * value="4"==>IT Analyst
	 * value="6"==>IT Support Manager
	 * value="15"==>Jr Production Manager
	 * value="18"==>Jr Sales Manager
	 * value="5"==>Network Administrator
	 * value="14"==>Production Manager
	 * value="26"==>QA Tester
	 * value="16"==>Sales&Marketing Manager
	 * 
	 */
	@FindBy(xpath = "//select[@id='report_job_title' and @class='valid']/option")
	public List<WebElement> jobTitleDDList;

	
	@FindBy(id = "display_group_1")
	public WebElement personalHeaderChkBox;
	
	@FindBy(id = "display_group_7")
	public WebElement salaryHeaderChkBox;
	
	@FindBy(linkText="Run")
	public WebElement runLink;
	
	
	public static void navigateToDefineReportPage() {
		CommonMethod.clickSubMenu(PIMMenu.pimMenu,PIMMenu.reportsMenu);
		CommonMethod.click(addBtn);
	}
}
