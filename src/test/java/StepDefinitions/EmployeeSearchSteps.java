package StepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.hrms.pages.PIMMenu;
import com.hrms.utils.CommonMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethod {

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
		login.adminlogin();
	}

	@And("Naviagte to Employee List Page")
	public void naviagte_to_Employee_List_Page() {
		clickSubMenu(empList.pimMenu, empList.employeeListMenu);
	}

	@When("user enters valid employee ID in Id Text box")
	public void user_enters_valid_employee_ID_in_Id_Text_box() {
		sendText(empList.empSearchId, "6961");
	}

	@When("Click on Search button")
	public void click_on_Search_button() {
		jsClick(empList.searchBtn);
	}

	@Then("User will be able to view correct employee information")
	public void user_will_be_able_to_view_correct_employee_information() {

		// ================Validation===================//
		wait(5);
		String expectedId = "6961";

		List<WebElement> result = empList.resultTableData;

		for (int i = 0; i < result.size(); i++) {
			String actual = result.get(i).getText();
			System.out.println("actual text---> " + actual);
			wait(3);

			Assert.assertEquals("Test Case Failed", actual, expectedId);
			break;
		}
	}

	@When("user enters valid employee firstName and Last Name in Employee Name Text box")
	public void user_enters_valid_employee_firstName_and_Last_Name_in_Employee_Name_Text_box() {
		jsClick(empList.empNamesrc);
		wait(2);
		sendTextWithSpace(empList.empNamesrc, "Md Saifuzzaman", Keys.SPACE);
		wait(2);

	}

}
