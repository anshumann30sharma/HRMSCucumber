package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements {
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//div[@id='branding']//img")
	public static WebElement logo;
	


}
