package StepDefinitions;



import org.junit.Assert;

import com.hrms.utils.CommonMethod;

import io.cucumber.java.en.*;


public class InvalidLoginTest extends CommonMethod {
	
	@When("user enters invalid Admin credentials")
	public void enteringInvalidCredentials() {
		sendText(login.username, "Admin");
		sendText(login.password, "hum@nHrm123");
	}

	@And("click on login button")
	public void clickLogInbutton() {
		
		click(login.loginbtn);
	}

	@Then("user was able to see error message")
	public void verifyErrormessage() {
		wait(3);
		String expectedMsg="Invalid credentials";
		
		String actualMsg=login.errorMsg.getText();
		
		Assert.assertEquals("Test Case Failed", expectedMsg, actualMsg);
		
	}

	@When("user enters invalid ESS User credentials")
	public void invalid_ESS_User_credentials() {
		sendText(login.username, "Saif123");
		sendText(login.password, "RayyanAyaan123");

	}
	
	@When("user enters invalid User credentials")
	public void user_enters_invalid_User_credentials() {
		sendText(login.username, "XYZ123");
		sendText(login.password, "XYZ123");
	}
}