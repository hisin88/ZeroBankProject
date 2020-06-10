@showTransactions

Feature: Navigating to specific accounts in Accounts Activity
Description: The purpose of this feature is to test the Accounts Summary functionality

  Background: The user should be logged in and navigate to Account Summary Page
    Given the user can login successfully
    Given the user is on the "Account Summary" page

  Scenario Outline: The user should be able to redirect to the selected account activity page
    When the user clicks on "<Account Type>" link on the Account Summary page
    Then "<Account Type>" should be selected on the Account Activity page
    Examples:
      | Account Type |
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |