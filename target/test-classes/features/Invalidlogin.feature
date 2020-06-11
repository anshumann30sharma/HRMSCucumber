@InvalidLogin @sprint12
Feature: user should see error message with invalid credentials

  @Smoke
  Scenario: Verify if admin is NOT able to login with invalid credentials
  When user enters invalid Admin credentials
  And click on login button
  Then user was able to see error message
  
  @smoke1
  Scenario: Verify if ESS user is NOT able to login with invalid credentials
  When user enters invalid ESS User credentials
  And click on login button
  Then user was able to see error message
  
  @regression
  Scenario: Verify if User is NOT able to login with invalid credentials
  When user enters invalid User credentials
  And click on login button
  Then user was able to see error message
  
  

