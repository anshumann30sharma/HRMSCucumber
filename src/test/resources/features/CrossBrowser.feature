Feature: Cross Browser Testing for HRMS Login
  I want to use this template for my CrossBrowser Testing

  @CB2
  Scenario Outline: HRMS Login Test Cross Browser
    Given User Opens HRMS in Different "<Browser>"
    When user enters valid Admin Credentials and click login Button
    Then User Verifies log in Successful

    Examples: 
      | Browser |
      | chrome  |
      | firefox |
      | edge    |
      | ie      |
