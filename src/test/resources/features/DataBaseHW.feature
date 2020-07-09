#Search an employee in hrms by id
#get the last name  from the table
#validate ui last name against db
Feature: Back-End Databaase Testing
  I want to use this template for vaidating UI & DataBase Entry

  @DbHW
  Scenario Outline: Name Validations against DB
    Given user is logged with valid admin credentials
    And user naviagtes to Employee List Page
    When user search employee by valid id "<employee_id>"
    And user retrieves employee last name from DataBase with "<sqlQuery>"
    Then User will be able to validate employee lastname "<emp_LastName/firstname>" against DataBase entry accordingly

    Examples: 
      | employee_id | emp_LastName/firstname | sqlQuery                                                           |
      |        6961 | Md                     | select emp_firstname from hs_hr_employees where emp_number=6961;   |
      | 9148A       | Atageldiyeva           | select emp_lastname from hs_hr_employees where emp_number='9148A'; |
