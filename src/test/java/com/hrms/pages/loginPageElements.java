package com.hrms.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.hrms.testbase.*;
import com.hrms.utils.*;

public class loginPageElements {

	public loginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(css = "input#txtUsername")
	public static WebElement username;

	@FindBy(id = "txtPassword")
	public static WebElement password;

	@FindBy(id = "btnLogin")
	public static WebElement loginbtn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	public static WebElement logo;

	/**
	 * Text="LOGIN Panel"
	 */
	@FindBy(id = "logInPanelHeading")
	public static WebElement loginPaneltxt;

	/**
	 * for empty username/both msg="Username cannot be empty" wrong
	 * UserName/password msg="Invalid credentials" only Empty password msg="Password
	 * cannot be empty"
	 * 
	 */
	@FindBy(xpath = "//div[@id='divLoginButton']//span")
	public WebElement errorMsg;

	public static void login(String name, String pwd) {
		CommonMethod.sendText(username, name);
		CommonMethod.sendText(password, pwd);
		CommonMethod.click(loginbtn);
	}

	public static void adminlogin() {

		CommonMethod.sendText(username, ConfigsReader.getProperty("HRMUserID"));
		CommonMethod.sendText(password, ConfigsReader.getProperty("HRMPassword"));
		CommonMethod.click(loginbtn);
	}

}
