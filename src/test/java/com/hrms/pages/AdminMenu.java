package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AdminMenu {
	
	public AdminMenu() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	//=============Admin Menu================================//
		/**
		 * Admin Menu
		 * 
		 */
		@FindBy (xpath="//a[@id='menu_admin_viewAdminModule']/b")
		public WebElement adminMenu;
		
		/**
		 * User Management Sub menu of Admin Menu.
		 */
		@FindBy (id="menu_admin_UserManagement")
		public WebElement userMgtMenu;
		
		/**
		 * User menu under user management sub menu of Admin
		 */
		
		@FindBy (id="menu_admin_viewSystemUsers")
		public WebElement userMenu;
		
		/**
		 * Job sub menu under Admin Menu
		 */
		@FindBy (id="menu_admin_Job")
		public WebElement jobMenu;
		
		/**
		 * Job Title sub menu of Job under Admin Menu
		 */
		@FindBy (id="menu_admin_viewJobTitleList")
		public WebElement jobTitleMenu;
		
		/**
		 * Pay Grade sub menu of Job under Admin Menu
		 */
		@FindBy (id="menu_admin_viewPayGrades")
		public WebElement payGradeMenu;
		
		/**
		 * Employment Status sub menu of Job under Admin Menu
		 */
		@FindBy (id="menu_admin_employmentStatus")
		public WebElement empStatusMenu;
		
		/**
		 * Job category sub menu of Job under Admin Menu
		 */
		@FindBy (id="menu_admin_jobCategory")
		public WebElement jobCategoryMenu;
		
		/**
		 * Work Shifts sub menu of Job under Admin Menu
		 */
		@FindBy (id="menu_admin_workShift")
		public WebElement workShiftMenu;
		
		
		/**
		 * Organization sub menu under Admin Menu
		 */
		@FindBy (id="menu_admin_Organization")
		public WebElement organizationMenu;
		
		/**
		 * General Information sub menu of 
		 * Organization sub menu under Admin Menu
		 */
		@FindBy (xpath="//a[text()='General Information']")
		public WebElement generalInfoMenu;
		
		/**
		 * Locations sub menu of 
		 * Organization sub menu under Admin Menu
		 */
		@FindBy (xpath="//a[text()='Locations']")
		public WebElement locationsMenu;
		
		/**
		 * Structure sub menu of 
		 * Organization sub menu under Admin Menu
		 */
		@FindBy (xpath = "//a[text()='Structure']")
		public WebElement structureMenu;

		/**
		 * Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_Qualifications")
		public WebElement qualificationsMenu;
		
		/**
		 * Skills Menu of Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewSkills")
		public WebElement skillsMenu;
		
		/**
		 * Education Menu of Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewEducation")
		public WebElement educationMenu;
		
		/**
		 * License Menu of Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewLicenses")
		public WebElement licenseMenu;
		
		/**
		 * Languages Menu of Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewLanguages")
		public WebElement languagesMenu;
		
		/**
		 * MemberShip Menu of Qualifications Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_membership")
		public WebElement membershipMenu;
		
		/**
		 * Nationality Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_nationality")
		public WebElement nationalityMenu;
		
		/**
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_Configuration")
		public WebElement configurationMenu;
		
		
		/**
		 * Email Configuration Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_listMailConfiguration")
		public WebElement emailConfigMenu;
		
		/**
		 * Email Subscriptions Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewEmailNotification")
		public WebElement emailSubscriptionMenu;
		
		/**
		 * Localization Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_localization")
		public WebElement localizationMenu;
		
		/**
		 * Modules Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_viewModules")
		public WebElement modulesMenu;
		
		/**
		 * Social Media Authentication Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_openIdProvider")
		public WebElement SocialMediaMenu;
		
		/**
		 * Register OAuth Client Menu of 
		 * Configuration Sub Menu Under Admin Menu
		 */
		@FindBy (id="menu_admin_registerOAuthClient")
		public WebElement registerClientMenu;
		
}
