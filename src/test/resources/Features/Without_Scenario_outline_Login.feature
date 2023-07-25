Feature: To test Login Functionality

  @InvalidCredentials1
  Scenario: Login with invalid username and password
    Given User is on Home page
    When User enters username as "Admin1" and password as "admin1"
    Then User should be able to see an "Invalid credentials"

  @InvalidCredentials2
  Scenario: Login with blank username
    Given User is on Home page
    When User enters username as "" and password as "admin123"
    Then User should be able to see as "Required"

  @InvalidCredentials3
  Scenario: Login with invalid credentials
    Given User is on Home page
    When User enters username as "Admin" and password as ""
    Then User should be able to see as "Required"
