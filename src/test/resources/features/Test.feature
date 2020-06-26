Feature: Fetching data from HRMS

  Background: 
    Given user is logged with valid admin credentials
    And Naviagte to Reports Page

  Scenario: invalid login
    When user retrieve all data from the ui
    And user retrieves all the data from database using below query
      | select emp_firstname, emp_lastname, emp_birthday from hs_hr_employees; |
    Then user compare both data and it should match.
    And user logs out
