#Search an employee in hrms by id
#get the last name  from the table
#validate ui last name against db

Feature: Back-End Databaase Testing
  I want to use this template for vaidating UI & DataBase Entry

  @DbTest
   Scenario: Name Validations against DB
    Given user is logged with valid admin credentials
    And Naviagte to Employee List Page
    When user enters valid employee ID "6961" in Id Text box
    And Click on Search button
    Then User will be able to validate employee firstName "Md" against DataBase entry accordingly

