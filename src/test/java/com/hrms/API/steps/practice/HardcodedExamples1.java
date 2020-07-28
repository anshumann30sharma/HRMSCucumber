package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.hrms.API.utils.PayloadConstants;

/**
 * This method below will execute @Test annotation in ascending alphabetical
 * order
 * 
 * @author anshu
 *
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples1 {
	/**
	 * Rest Assured
	 *
	 * given - prepare your request when - you are making the call to the endpoint
	 * then - validating
	 *
	 * @param args
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUxNiwidXNlcklkIjoiNzI3In0.sLM88MbaFki2irlJOOPywsj8C2gfFwxPKeYAgzkrbXw";
	static String employeeID;
@Test
	public void sampleTestNotes() {
	
		System.out.println("========SimpleTest Notes=======");
		/**
		 * BaseURI for all calls
		 */
		//RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		/**
		 * JWT required for all calls - expires every 12 hours
		 */
	//	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUxNiwidXNlcklkIjoiNzI3In0.sLM88MbaFki2irlJOOPywsj8C2gfFwxPKeYAgzkrbXw";
		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16490A"); // .log().all();
		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Two ways to print response prettyPrint() method converts JSON object into
		 * String and prints - no need to SOP
		 */
		getOneEmployeeResponse.prettyPrint();
		 String response = getOneEmployeeResponse.body().asString();
		 System.out.println(response);
		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {
		
		System.out.println("===Create Employee==========");
		/**
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"Prince\",\r\n" + "  \"emp_lastname\": \"Tetteh\",\r\n"
						+ "  \"emp_middle_name\": \"H\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"1999-07-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\n" + "}");// .log().all();
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
		/**
		 * jsonPath() to view response body which lets us get the employee ID We store
		 * employee ID as a global variable so that we may we use it with our other
		 * calls
		 *
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		/** optional to print employee ID */
		System.out.println(employeeID);
		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * Verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		/**
		 * Verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Prince"));
		/**
		 * Verifying server using then().header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		/**
		 * Verifying Content-Type using assertThat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
	}

	@Test
	public void bGETcreatedEmployee() {
		System.out.println("=====Get Created Employee==========");
		/**
		 * Preparing request for /getOneEmployee.php Using log().all() to see all
		 * information being sent with request
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
		 * matching exact employeeID’s
		 */
		boolean verifyingEmpoyeeIDsMatch = empID.contentEquals(employeeID);
		System.out.println("Employee ID’s match: " + verifyingEmpoyeeIDsMatch);
		/**
		 * Asserting employee ID’s match
		 */
		Assert.assertTrue(verifyingEmpoyeeIDsMatch);

		/**
		 * Verifying status code is 200
		 */
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
		 * 
		 */
		Assert.assertTrue(emplID.contentEquals(employeeID));
		Assert.assertEquals(employeeID, emplID);
		/**
		 * Verifying employee name match with actual
		 * 
		 */
		Assert.assertTrue(firstName.contentEquals("Prince"));
		// Verifying employee middlename match with actual */
		Assert.assertTrue(middleName.contentEquals("H"));
		// Verifying employee lastname match with actual */
		Assert.assertTrue(lastName.contentEquals("Tetteh"));
		// Verifying employee bday match with actual */
		Assert.assertTrue(emp_bday.contentEquals("1999-07-11"));
		// Verifying employee gender match with actual */
		Assert.assertTrue(gender.contentEquals("Male"));
		/** Verifying employee jobtitle match with actual */
		Assert.assertTrue(jobtitle.contentEquals("Cloud Architect"));

	}
	
//	@Test
	public void cGETallEmployees() {
		System.out.println("===========Get All Employee==========================");
		RequestSpecification getAllEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		Response getAllEmployeeResponse = getAllEmployeeRequest.when().get("/getAllEmployees.php");

		// getAllEmployeeResponse.prettyPrint();
		String allEmployees = getAllEmployeeResponse.body().asString();
		/** below will pass but is incorrect */
		// allEmployees.contains(employeeID);
		JsonPath js = new JsonPath(allEmployees);
		/** Retrieving size of Employees List */
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);
		/**
		 * Print out all employee IDs
		 */
//		for (int i = 0; i < sizeOfList; i++) {
//			/**
//			 * Printing all employee IDs
//			 */
//
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//			System.out.println(allEmployeeIDs);
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
//			
//
//		}
//
	}
	@Test
	public void dPUTupdateCreatedEmployee() {
		
		/**
		 * Preparing request to update created employee
		 * calling static method updateCtreatedEmpBody() from HardcodedConstants class
		 */

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmpBody());

		/**
		 * Storing response into updateCreatedEmployeeResponse
		 */
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/**
		 * Storing response into a String
		 */
	//	String response = updateCreatedEmployeeResponse.prettyPrint();
		
		/**
		 * Asserting using hamcrest matchers equalTo() method to verify employee is updated
		 */
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
		/**
		 * Retrieving response body employee ID using jsontPath()
		 */
		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		/**
		 * Asserting that response body employee ID matches globally stored employee ID 
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));
		
	}
	
	
	@Test
	public void eGETUpdatedEmployee() {
		
		/**
		 * Preparing request to get updated employee
		 */
	RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
	/**
	 * Storing response into getUpdatedEmployeeResponse
	 */
	Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
	
	/**
	 * Printing response 
	 */
	//getUpdatedEmployeeResponse.prettyPrint();
		
	/**
	 * Asserting expected first name 
	 */
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("syntaxUpdatedFirstName"));
		
	/**
	 * Verifying response employee ID is equal to globally stored employee ID 
	 */
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));
	
	}
	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		
	RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).body("{\n" + 
				"  \"employee_id\": \""+ employeeID +"\",\n" + 
				"  \"emp_firstname\": \"syntaxPartiallyUpdatedFirstName\"\n" + 
				"}");
		
	Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
		
	//partiallyUpdatingEmployeeResponse.prettyPrint();
	
	partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);
		
	partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
	}
	@Test
	public void gDELETEemployee() {
		
	RequestSpecification deleteEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
	Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
	
	deleteEmployeeResponse.prettyPrint();
	
	deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
	
	}

}
