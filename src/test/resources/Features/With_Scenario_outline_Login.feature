Feature: To test Login Functionality

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    Given User is on Home page
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see as "<errorMessage>"

    Examples: 
      | username | password | errorMessage |
      |          | admin123 | Required     |
      | Admin    |          | Required     |
