Feature: Login to HRM Application

@InValidCredential
Scenario: Login with invalid credential
 
  Given User launched an HRMLogin page
  When User enters invalid credentials and Login will be unsuccessful with error message
    | Username  | Password   | ErrorMessage        |
    | Admin1    | admin123!$ | Invalid credentials |
