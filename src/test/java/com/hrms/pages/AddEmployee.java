package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployee extends PIMMenu{
	
	public AddEmployee() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	/**
	 * headTitle text="Add Employee"
	 */
	@FindBy (xpath="//h1[text()='Add Employee']")
	public WebElement headTitle;
	
	@FindBy (xpath="//input[@id='firstName']")
	public static WebElement firstName;
	
	@FindBy (xpath="//input[@id='middleName']")
	public WebElement middleName;
	
	@FindBy (xpath="//input[@id='lastName']")
	public static WebElement lastName;
	
	@FindBy (xpath="//input[@id='employeeId']")
	public WebElement employeeId;
	
	@FindBy (xpath="//input[@id='photofile']")
	public WebElement choosePhoto;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	public WebElement cLoginChkbox;
	
	@FindBy(xpath="(//span[text()='Required'])[1]")
	public WebElement fNameErrorMsg;
	
	@FindBy(xpath="(//span[text()='Required'])[2]")
	public WebElement lNameErrorMsg;
	
	/**
	 * User Name WebElement is available
	 * after clicking cLoginChkbox;
	 */
	@FindBy (xpath="//input[@id='user_name']")
	public WebElement userName;
	
	/**
	 * Password WebElement is available
	 * after clicking cLoginChkbox;
	 */
	@FindBy (id="user_password")
	public WebElement password;
	
	/**
	 * Password WebElement is available
	 * after clicking cLoginChkbox;
	 */
	@FindBy (xpath="//input[@id='re_password']")
	public WebElement confirmPwd;
	
	
	/**
	 * Status WebElement is available
	 * after clicking cLoginChkbox;
	 * By default Enabled is selected
	 */
	@FindBy (xpath="//select[@id='status']")
	public WebElement statusDropDown;
	
	/**
	 * Enable option from status drop down
	 */
	
	@FindBy (xpath="//select[@id='status']//option[text()='Enabled']")
	public WebElement selectEnable;
	
	/**
	 * Disable option from status drop down
	 */
	
	@FindBy (xpath="//select[@id='status']//option[text()='Disabled']")
	public WebElement selectDisable;
	
	
	@FindBy (xpath="//form[@id=\"frmAddEmp\"]//span/text()")
	public WebElement pwdHelpText;
	
	@FindBy (xpath="//label[text()='Full Name']")
	public WebElement fullNamelabel;
	
	@FindBy (xpath="//label[text()='Employee Id']")
	public WebElement empIdlabel;
	
	@FindBy (xpath="//label[text()='Photograph']")
	public WebElement photolabel;
	
	@FindBy (xpath="//input[@id='btnSave']")
	public WebElement saveBtn;
	
	@FindBy (xpath="//span[@for='user_name']")
	public WebElement userIDErrorMsg;
	
	@FindBy (xpath="//span[@for='user_password']")
	public WebElement uIdPwdErrorMsg;
	
	@FindBy (xpath="//span[@for='re_password']")
	public WebElement confirmPwdErrorMsg;
	

}
