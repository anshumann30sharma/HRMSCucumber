package StepDefinitions;

import java.util.*;
import java.util.Map.*;
import org.junit.*;
import org.testng.asserts.*;
import com.hrms.utils.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginFeatureSteps extends CommonMethod {

	@When("I enter invalid UserName and Password and click on login button and see error message")
	public void i_enter_invalid_and_and_see(DataTable dataTable) {

		List<Map<String, String>> credentials = dataTable.asMaps();
		SoftAssert soft = new SoftAssert();
		for (Map<String, String> m : credentials) {
			String uid = m.get("UserName");
			String pwd = m.get("Password");
			String expectedmsg = m.get("ErrorMessage");

			sendText(login.username, uid);
			sendText(login.password, pwd);
			click(login.loginbtn);
			wait(2);
			// =======================Validation===========//
			String actualmsg = login.errorMsg.getText();

//			Assert.assertEquals("Test Case Failed", expectedmsg, actualmsg);

			soft.assertEquals(actualmsg, expectedmsg, "Test Case Failed");
			soft.assertAll();
		}

	}

	@When("User entered valid {string} and {string}")
	public void user_entered_valid_and(String userName, String password) {
		sendText(login.username, userName);
		sendText(login.password, password);
	}

	@And("click on login button")
	public void clickLogInbutton() {
		click(login.loginbtn);
	}
	
	@Then("{string} will be able to see a Greeting with {string}")
	public void will_be_able_to_see_a_Greeting_with_word(String userName, String firstName) {
		String actualMessage=dashBoard.welcome.getText();
		
		Assert.assertTrue(userName+"NOT successfully logged in", actualMessage.contains(firstName));

	}

}