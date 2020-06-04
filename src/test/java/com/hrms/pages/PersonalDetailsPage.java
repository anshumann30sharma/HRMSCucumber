package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPage extends EmployeeListPage {

	
	@FindBy (xpath="//select[@id='personal_cmbNation']")
	public WebElement nationalityDD;
	
	@FindBy (name="personal[optGender]")
	public List<WebElement> genderRadioGroup;
	
	public PersonalDetailsPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
