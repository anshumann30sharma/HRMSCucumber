package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PIMMenu {

	public PIMMenu() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	// =============PIMMenu Menu================================//
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']/b")
	public static WebElement pimMenu;

	/**
	 * Configuration sub Menu of PIMMenu
	 */

	@FindBy(xpath = "//a[@id='menu_pim_Configuration']")
	public WebElement configMenu;

	/**
	 * Sub Menu of configuration Menu
	 */
	@FindBy(id = "menu_pim_configurePim")
	public WebElement optionalFieldMenu;

	@FindBy(xpath = "//a[@id='menu_pim_listCustomFields']")
	public WebElement customFieldMenu;

	@FindBy(xpath = "//a[@id='menu_admin_pimCsvImport']")
	public WebElement dataImportFieldMenu;

	@FindBy(xpath = "//a[@id='menu_pim_viewReportingMethods']")
	public WebElement reportingMethodsMenu;

	@FindBy(xpath = "//a[@id='menu_pim_viewTerminationReasons']']")
	public WebElement terminationReasonMenu;

	/**
	 * EmployeeList Menu Sub Menu of PIMMenu
	 */
	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
	public WebElement employeeListMenu;

	/**
	 * Add Employee Menu Sub Menu Of PIMMenu
	 */
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmpMenu;

	/**
	 * Reports Menu Sub Menu of PIMMenu
	 */

	@FindBy(xpath = "(//a[contains(@id, 'Reports')])[1]")
	public static WebElement reportsMenu;
	


}
