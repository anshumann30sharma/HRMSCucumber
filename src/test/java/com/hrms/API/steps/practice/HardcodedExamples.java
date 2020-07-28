package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

//import org.apache.hc.core5.http.ContentType;
/**
 * This method below will execute @Test annotation in ascending alphabetical
 * order
 * 
 * @author
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

	/**
	 * Rest Assured given- prepare your request when- you are making call to end
	 * point then- validating
	 * 
	 * @param args
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUxNiwidXNlcklkIjoiNzI3In0.sLM88MbaFki2irlJOOPywsj8C2gfFwxPKeYAgzkrbXw";
	static String employeeID;

	public void sampleTestNotes() {
		System.out.println("========SimpleTest Notes=======");
	}
		/**
		 * BaseURI for all calls
		 */
   @Test
	public void aPOSTcreateEmployee() {
		String body1 = "{\r\n" + 
				"  \"emp_firstname\": \"Prince\",\r\n" + 
				"  \"emp_lastname\": \"Tetteh\",\r\n" + 
				"  \"emp_middle_name\": \"P\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1999-07-11\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
				"}";
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(body1).log().all();

		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		createEmployeeResponse.prettyPrint();
		/**
		 * jsonPath () to view reponse body which lets us get the employee ID
		 */

		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		/** optional to print employee ID */
		System.out.println(employeeID);
		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * Verifying message using equalTo() method-manually static package import
		 * static org.hamcrest.Matches.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		/**
		 * Verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Prince"));
		/**
		 * Verifying server using then().header()
		 */
		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		/**
		 * Verifying Content-Type using assertThat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Length", "390");

	}

	@Test
	public void getOneEmployee() {

		System.out.println("====get one Employee=======");
		/**
		 * JWT required for calls- expires every 12 hours
		 */
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUxNiwidXNlcklkIjoiNzI3In0.sLM88MbaFki2irlJOOPywsj8C2gfFwxPKeYAgzkrbXw";
		/**
		 * Preparing /getOneEmployeeRequest.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", ":application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);// .log().all();
		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Two ways to print response prettyPrint()method converts JSON object into
		 * String and prints -no need to SOP
		 */
		getOneEmployeeResponse.prettyPrint();
		String response=getOneEmployeeResponse.body().asString();
		 System.out.println(response);

		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void bGETcreatedEmployee() {
		/**
		 * Preparing request for /getOneEmployee.php Using log().all() to see all
		 * information
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		/**
		 * Making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Printing response using prettyPrint()
		 */
		String response = getCreatedEmployeeResponse.prettyPrint();
		/**
		 * Storing response employeeID into empID which will be used for verification
		 * against stored global employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		/**
		 * matching exact employeeID's
		 */
		boolean verifyingEmpoyeeIDsMatch = empID.equalsIgnoreCase(employeeID);
		System.out.println("Employee ID's match : " + verifyingEmpoyeeIDsMatch);
		/**
		 * Asserting employee ID's match
		 */
		Assert.assertTrue(verifyingEmpoyeeIDsMatch);

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		/**
		 * Using json class to retrieve values from response as a String
		 */
		JsonPath js = new JsonPath(response);

		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String emp_bday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobtitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID);
		System.out.println(firstName);
		/**
		 * Verifying employee ID's match
		 */
		Assert.assertTrue(emplID.contentEquals(employeeID));
		Assert.assertEquals(employeeID, emplID);
		/** Verifying employee name match with actual */
		Assert.assertTrue(firstName.contentEquals("Prince"));
		/** Verifying employee middlename match with actual */
		Assert.assertTrue(middleName.contentEquals("P"));
		/** Verifying employee lastname match with actual */
		Assert.assertTrue(lastName.contentEquals("Tetteh"));
		/** Verifying employee bday match with actual */
		Assert.assertTrue(emp_bday.contentEquals("1999-07-11"));
		/** Verifying employee gender match with actual */
		Assert.assertTrue(gender.contentEquals("Male"));
		/** Verifying employee jobtitle match with actual */
		Assert.assertTrue(jobtitle.contentEquals("Cloud Architect"));

	}

//@Test
	public void cGETallEmployees() {
		RequestSpecification getAllEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		Response getAllEmployeeResponse = getAllEmployeeRequest.when().get("/getAllEmployees.php");

		// getAllEmployeeResponse.prettyPrint();
		String allEmployees = getAllEmployeeResponse.body().asString();
		/** below will pass but is incorrect */
		// allEmployees.contains(employeeID);
		JsonPath js = new JsonPath(allEmployees);
		/** Retrieving size of Employees List */
//		int sizeOfList = js.getInt("Employees.size()");
//		System.out.println(sizeOfList);
//		/**
//		 * Print out all employee IDs
//		 */
//		for (int i = 0; i < sizeOfList; i++) {
//			/**
//			 * Printing all employee IDs
//			 */
//
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//			// System.out.println(allEmployeeIDs);
//			
//			/**
//			 * If statement inside for loop to find stored employee ID and break the loop when found
//			 */
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				
//				System.out.println("employee ID: " + employeeID + " is present in body");
//				String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//			}
		}
	
	@Test
	public void dPUTupdateCreatedEmployee() {
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "            \"employee_id\": \"" + employeeID + "\"r\n"
						+ "            \"emp_firstname\": \"Ram\",\r\n" + "            \"emp_middle_name\": \"R\",\r\n"
						+ "            \"emp_lastname\": \"Jason\",\r\n"
						+ "            \"emp_birthday\": \"2020-07-11\",\r\n"
						+ "            \"emp_gender\": \"Male\",\r\n"
						+ "            \"emp_job_title\": \"Cloud Architect\",\r\n"
						+ "            \"emp_status\": \"Worker\"\r\n" + "        }");

		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/getAllEmployees.php");
		/*
		 * Storing response into a String
		 */
	//	String response = updateCreatedEmployeeResponse.prettyPrint();
			/**
			 * Asserting using hamcrest matchers equalTo()	method to verify employee is updated
			 */
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
			/**
			 * Retrieving response
			 */
				String empID=updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0],employee_id");
	
				Assert.assertTrue(empID.contentEquals(employeeID));
	}
	@Test
	public void eGETUpdatedEmployee() {
		RequestSpecification getUpdatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID).log().all();
				Response getUpdatedEmployeeResponse=	getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
	getUpdatedEmployeeResponse.prettyPrint();

	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("syntaxUpdatedFirstName"));
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo("employeeID"));
	
	}
	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		String body1= "{\r\n" + 
				"  \"employee_id\": \"{{empID}}\",\r\n" + 
				"  \"emp_firstname\": \"Prince1\",\r\n" + 
				"  \"emp_lastname\": \"Ram\"\r\n" + 
				"}";//need to finish writing  body
		RequestSpecification getUpdatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization", token).body(body1);	    
	}
}
