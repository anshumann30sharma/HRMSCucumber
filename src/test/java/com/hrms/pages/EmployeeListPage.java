package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPage extends PIMMenu {
	

	public EmployeeListPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

//	WebElement empVerify= Driver.findBy( (xpath="//h1[text()='"+AddEmployee.firstName+" "+AddEmployee.lastName+"']")
	
	@FindBy (id="empsearch_id")
	public WebElement empSearchId;
	
	@FindBy (id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy (xpath="(//table[@id='resultTable']//td/a)[2]")
	public WebElement empSrcFirstName;
	
	@FindBy (xpath="//table[@id='resultTable']//td/a")
	public List<WebElement> resultTableData;
	
	@FindBy (xpath="(//table[@id='resultTable']//td/a)[1]")
	public WebElement resultTableId;
	
	@FindBy (id="empsearch_employee_name_empName")
	public WebElement empNamesrc;
	
	@FindBy(xpath="//*[@class='ac_even ac_over']/strong")
	public WebElement empDspName;
	
	/**
	 * Can be access by clicking save Button in Add Employee page
	 * Or by Clicking employee name in Employee information Page
	 */
	
	@FindBy (xpath="//div[@id='profile-pic']/h1")
	public WebElement photoName;
}
