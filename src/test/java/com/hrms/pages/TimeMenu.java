package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class TimeMenu {
	
	
	public TimeMenu() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//=============Time Menu================================//
	
	/**
	 * Time Menu
	 */
	@FindBy(xpath="//a[@id='menu_time_viewTimeModule']/b")
	public WebElement timeMenu;

}
