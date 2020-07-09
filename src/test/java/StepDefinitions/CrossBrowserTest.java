package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.loginPageElements;
import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethod;
import com.hrms.utils.Constants;

import io.cucumber.java.en.*;

public class CrossBrowserTest extends CommonMethod {
	
	@Given("User Opens HRMS in Different {string}")
	public void user_Opens_HRMS_in_Different(String string) {
		
		setUp1(string);

	}

	@When("user enters valid Admin Credentials and click login Button")
	public void user_enters_valid_Admin_Credentials_and_click_login_Button() {
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitAndClick(login.username);
		loginPageElements.adminlogin();
	}

	@Then("User Verifies log in Successful")
	public void user_Verifies_log_in_Successful() {
		String expected = "Welcome Admin";
		String actual=dashBoard.welcome.getText();
		Assert.assertEquals("Test failed", expected, actual);
		
	}



}
