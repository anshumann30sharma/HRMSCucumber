@homework
Feature: Invalid login Homework

  Scenario: Login with invalid credentials
    When I enter invalid UserName and Password and click on login button and see error message
      | UserName | Password   | ErrorMessage        |
<<<<<<< HEAD
      | Admin    | Admin123   | Invalid Credentials |
=======
      | Admin    | Admin123   | Invalid credentials |
>>>>>>> 80c8efae0ad278098a36cba3738a121d1f7b7c90
      | Hello    | Syntax123! | Invalid Credentials |
      
  ##With Data Table we must sendd a value, otherwise we will get following message
	##java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
