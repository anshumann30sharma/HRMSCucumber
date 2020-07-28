package com.hrms.API.utils;

import com.hrms.API.steps.practice.HardcodedExamples1;

import APIStepDefinitions.APIWorkflowAllSteps;
import org.json.JSONObject;
public class PayloadConstants{
	/**
	 * Create employee body
	 * @return
	 */
public static String CreatedEmpBody() {
	 String createEmployeeBody="{\r\n" + 
			"  \"emp_firstname\": \"Prince\",\r\n" + 
			"  \"emp_lastname\": \"Tetteh\",\r\n" + 
			"  \"emp_middle_name\": \"string\",\r\n" + 
			"  \"emp_gender\": \"M\",\r\n" + 
			"  \"emp_birthday\": \"1999-07-11\",\r\n" + 
			"  \"emp_status\": \"Employee\",\r\n" + 
			"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
			"}";
		return createEmployeeBody;
	}
/**
 * Creating payload using JSONObject and returning it as a String
 * @return
 */
	public static String createEmployeePayload() {
		JSONObject obj=new JSONObject();
		
		obj.put("emp_firstname", "Prince");
		obj.put("emp_lastname", "Tetteh");
		obj.put("emp_middle_name", "string");
		obj.put("emp_birthday", "1999-07-11");
		obj.put("emp_gender", "M");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Cloud Architect");
	return obj.toString();
	}
	public static String updateCreatedEmpBody() {
	String updateBody="{\r\n" + 
			"  'employee_id': ''+APIWorkflowAllSteps.employeeID+',\r\n" + 
			"  'emp_firstname': 'Ram',\r\n" + 
			"  'emp_lastname': 'Jason',\r\n" + 
			"  'emp_middle_name': 'R',\r\n" + 
			"  'emp_gender': 'M',\r\n" + 
			"  'emp_birthday': '2020-07-11',\r\n" + 
			"  'emp_status': 'Worker',\r\n" + 
			"  'emp_job_title': 'Cloud Architect'\r\n" + 
			"}";
	return updateBody;
	
}
}
