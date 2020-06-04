
Feature: Employee Search
  
  Scenario: Search Employee by ID
   Given user Navigate to HRMS Web Application
    And user is logged with valid admin credentials
    And Naviagte to Employee List Page
    When user enters valid employee ID in Id Text box
    And Click on Search button
    Then User will be able to view correct employee information

  Scenario: Search Employee by name
   Given user Navigate to HRMS Web Application
    And user is logged with valid admin credentials
    And Naviagte to Employee List Page
    When user enters valid employee firstName and Last Name in Employee Name Text box
    And Click on Search button
    Then User will be able to view correct employee information
  

