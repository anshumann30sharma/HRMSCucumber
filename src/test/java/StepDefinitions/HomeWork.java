package StepDefinitions;

import java.util.*;
import org.testng.asserts.*;
import com.hrms.utils.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class HomeWork extends CommonMethod {

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

}
