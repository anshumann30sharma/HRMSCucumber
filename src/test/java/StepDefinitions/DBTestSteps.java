package StepDefinitions;

import java.util.*;
import java.util.Map.Entry;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.testbase.JDBCUtil;
import com.hrms.utils.CommonMethod;

import io.cucumber.java.en.*;

public class DBTestSteps extends CommonMethod {

	@When("user enters valid employee ID {string} in Id Text box")
	public void user_enters_valid_employee_ID_in_Id_Text_box(String string) {
		sendText(empList.empSearchId, string);
	}

	@Then("User will be able to validate employee firstName {string} against DataBase entry accordingly")
	public void user_will_be_able_to_validate_DataBase_entry_accordingly(String string) {
		// ================Validation===================//
		JDBCUtil.DBConnection();
		wait(2);
		String expectedId = string;
		String query = "select emp_firstname from hs_hr_employees where emp_number=6961;";

		List<WebElement> result = empList.resultTableData;

		List<Map<String, String>> dbData = JDBCUtil.dataListMap(query);

		for (int i = 0; i < result.size(); i++) {
			String dbFirstName = null;
			String UIFirstName = result.get(i).getText();
			System.out.println("actual text---> " + UIFirstName);
			wait(3);
			for (Map<String, String> mData : dbData) {

				for (Entry<String, String> e : mData.entrySet()) {
//					String colName = e.getKey();
					dbFirstName = e.getValue();
				}
			}
			if (UIFirstName.equalsIgnoreCase(expectedId)) {
				Assert.assertEquals("Test Case Failed", UIFirstName, dbFirstName);
				break;
			}
		}
		JDBCUtil.closeDB();
	}

}
