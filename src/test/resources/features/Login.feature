@login


Feature: Only authorized users should be able to login
Description: The purpose of this feature is to test the Login functionality

  @positiveLogin @wip
  Scenario: The user should be able to login with valid credentials
    Then the user should be able to login with valid credentials "username" "password"

  @negativeLogin
  Scenario Outline: The user should NOT be able to login with invalid credentials
    Then the user should NOT be able to login with invalid credentials "<username>" "<password>"
    Examples:
      | username         | password         |
      | username         | invalid password |
      | invalid username | password         |
      | username         | blank password   |
      | blank username   | password         |