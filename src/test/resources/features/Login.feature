#Author: saifuz.zaman@yahoo.com

Feature: Login

  Scenario: Login with invalid credentials
    When I enter invalid UserName and Password and click on login button and see error message
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid credentials |
      | Hello    | Syntax123! | Invalid credentials |
      
  ##With Data Table we must sendd a value, otherwise we will get following message
	##java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
