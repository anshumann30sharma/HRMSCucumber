@searchEmployee @sprint13
Feature: Employee Search
  
  @smoke2 
  Scenario: Search Employee by ID
 
    Given user is logged with valid admin credentials
    And Naviagte to Employee List Page
    When user enters valid employee ID in Id Text box
    And Click on Search button
    Then User will be able to view correct employee information
  
  #@regression
  #Scenario: Search Employee by name
    #Given user is logged with valid admin credentials
    #And Naviagte to Employee List Page
    #When user enters valid employee firstName and Last Name in Employee Name Text box
    #And Click on Search button
    #Then User will be able to view correct employee information
  

