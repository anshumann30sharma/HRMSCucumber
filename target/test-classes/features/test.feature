Feature: User Should be able to HRMS application with valid Admin user Credentials

  Scenario: Valid Admin login
    Given user open chrome browser
    And Navigate to HRMS Web Application
    When User Enter valid Admin user ID and password
    And user clicks on login button
    Then user login successfull
    And user see welcome message
