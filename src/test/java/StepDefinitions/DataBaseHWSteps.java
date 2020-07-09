package StepDefinitions;

import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import com.hrms.utils.*;
import io.cucumber.java.en.*;

public class DataBaseHWSteps extends CommonMethod {

	public String dbName;
	public String dbfirstName;
	@And("user naviagtes to Employee List Page")
	public void user_naviagtes_to_Employee_List_Page() {
		clickSubMenu(empList.pimMenu, empList.employeeListMenu);
	}

	@When("user search employee by valid id {string}")
	public void user_search_employee_by_valid_id(String string) {
		sendText(empList.empSearchId, string);
		waitAndClick(empList.searchBtn);
	}

	@And("user retrieves employee last name from DataBase with {string}")
	public void user_retrieves_employee_last_name_from_DataBase_with(String string) {
		JDBCUtil.DBConnection();
		Map<String, String> dBnames = JDBCUtil.SingleDBDataMap(string);
		
		if(dBnames.containsKey("emp_firstname")) {
			dbName = dBnames.get("emp_firstname");
		}else if(dBnames.containsKey("emp_lastname")) {
			dbName = dBnames.get("emp_lastname");
		}
		
		
		JDBCUtil.closeDB();

	}

	@Then("User will be able to validate employee lastname {string} against DataBase entry accordingly")
	public void user__validates_employee_lastname_against_DataBase_entry_accordingly(String string) {

		String expectedLastName = string;

		List<WebElement> UIlastName = empList.resultTableData;

		for (WebElement ele : UIlastName) {
			String text = ele.getText();

			if (text.contentEquals(expectedLastName)) {
				Assert.assertEquals("UI & DB Data NOT Matched", text, dbName);
			}

		}

	}

}
