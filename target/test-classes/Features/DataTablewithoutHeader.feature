Feature: Login to HRM Application

  @ValidCredentials
  Scenario: Login with valid credentials
    Given User is on HRMLogin page
    When User enters valid credentials
      | Admin | admin123 |
    Then User should be able to login successfully and new page open
