package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethod;
import com.hrms.utils.ConfigsReader;


public class loginPageElements {
	
	public loginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
		
	@FindBy(id="txtUsername")
	public static WebElement username;
	
	@FindBy(id="txtPassword")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement loginbtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public static WebElement logo;
	
	/**
	 * Text="LOGIN Panel"
	 */
	@FindBy(id="logInPanelHeading")
	public static WebElement loginPaneltxt;
	
	/**
	 * for empty username/both msg="Username cannot be empty"
	 * wrong UserName/password msg="Invalid credentials"
	 * only Empty password msg="Password cannot be empty"
	 * 
	 */
	@FindBy(xpath="//div[@id='divLoginButton']//span")
	public WebElement errorMsg;
	
	
	
	public static void login( String name, String pwd) {
		CommonMethod.sendText(username, name);
		CommonMethod.sendText (password, pwd);
		CommonMethod.click(loginbtn);
	}
	
	public static void adminlogin() {
		String userID = ConfigsReader.getProperty("HRMUserID");
		String pwd = ConfigsReader.getProperty("HRMPassword");
		CommonMethod.sendText(username, userID);
		CommonMethod.sendText (password, pwd);
		CommonMethod.click(loginbtn);
	}

	
}
