package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LeaveMenu {
	
	public LeaveMenu() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//=============Leave Menu================================//
	
		/**
		 * Leave Menu
		 */
		@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']/b")
		public WebElement leaveMenu;
		
		/**
		 * Entitlements sub menu of Leave Menu
		 */
		@FindBy (id="menu_leave_Entitlements")
		public WebElement entitlementMenu;
		
		/**
		 * Add Entitlements menu of Entitlements sub menu under Leave Menu
		 */
		@FindBy (id="menu_leave_addLeaveEntitlement")
		public WebElement addEntitlementMenu;
		
		/**
		 * Employee Entitlements menu of Entitlements sub menu under Leave Menu
		 */
		@FindBy (id="menu_leave_viewLeaveEntitlements")
		public WebElement empEntitlementMenu;
		
		/**
		 * Reports menu under Leave Menu
		 */
		@FindBy (id="menu_leave_Reports")
		public WebElement leaveReportsMenu;
		
		/**
		 * Leave Entitlements and Usage Report menu of Reports menu 
		 * under Leave Menu
		 */
		@FindBy (id="menu_leave_viewLeaveBalanceReport")
		public WebElement leaveEntitleUsageMenu;
		
		/**
		 * Configure Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_Configure")
		public WebElement configureMenu;
		
		/**
		 * Leave Period Menu of Configure Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_defineLeavePeriod")
		public WebElement leavePeriodMenu;
		
		/**
		 * Leave Types Menu of Configure Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_leaveTypeList")
		public WebElement leaveTypeMenu;
		
		/**
		 * Work Week Menu of Configure Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_defineWorkWeek")
		public WebElement workWeekMenu;
		
		/**
		 * Holidays Menu of Configure Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_viewHolidayList")
		public WebElement holidaysMenu;
		
		/**
		 * Leave List Menu under Leave Menu
		 */
		@FindBy (id="menu_leave_viewLeaveList")
		public WebElement leaveListMenu;
		
		/**
		 * Assign Leave menu under Leave Menu
		 */
		@FindBy (id="menu_leave_assignLeave")
		public WebElement assignLeaveMenu;

}
