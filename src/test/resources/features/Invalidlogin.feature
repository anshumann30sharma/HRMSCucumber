Feature--strict: user should see error message with invalid credentials
 
   Scenario: Verify if admin is NOT able to login with invalid credentials
    Given User opens chrome browser and navigated to HRMS web Application
    When user enters invalid Admin credentials
    And click on log in button
    Then user was able to see error message

	   Scenario: Verify if ESS user is NOT able to login with invalid credentials
    Given User opens chrome browser and navigated to HRMS web Application
    When user enters invalid ESS User credentials
    And click on log in button
    Then user was able to see error message

	   Scenario: Verify if User is NOT able to login with invalid credentials
    Given User opens chrome browser and navigated to HRMS web Application
    When user enters invalid User credentials
    And click on log in button
    Then user was able to see error message