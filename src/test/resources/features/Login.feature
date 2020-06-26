#Author: saifuz.zaman@yahoo.com
@Sprint1
Feature: Login
  
  Description: The purpose of this feature file is to Test log in functionality with valid and invalid Credentials
  Acceptance Criteria: User should be able to login with Valid Credentials only.

  @smoke
  Scenario: User should see error message with invalid credentials
    When I enter invalid UserName and Password and click on login button and see error message
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid credentials |
<<<<<<< HEAD
      | Hello    | Syntax123! | Invalid credentials |
=======
      | Saif123  | Saif123    | Invalid credentials |
      | Hello    | Syntax123! | Invalid credentials |

  ##With Data Table we must send a value, otherwise we will get following message
  ##java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
  
  #@smoke
  #Scenario Outline: User Should be able to login to HRMS with valid Credentials
    #Given User is navigated to Hrms Web Application
    #When User entered valid "<UserName>" and "<Password>"
    #And click on login button
    #Then "<UserName>" will be able to see a Greeting with "<FirstName>"
#
    #Examples: 
      #| UserName | Password        | FirstName |
      #| Admin    | Hum@nhrm123     | Admin     |
      #| Saif123  | Ayaan@rayyan123 | Md        |

>>>>>>> 13794bda4fa56a3f9483e69dbf247e7abf7b5a3d
      
      