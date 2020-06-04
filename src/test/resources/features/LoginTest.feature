

Feature:  User Should be able to login to Hrms with valid Admin Login
 # User Should be able to login to Hrms with valid Admin Login

  @tag1
  Scenario: Title of your scenario
    Given user open chrome browser
    And Navigate to HRMS Web Application
    When User Enter valid Admin user ID and password
    And user clicks on login button
    Then user login successfull
    And user see welcome message

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
