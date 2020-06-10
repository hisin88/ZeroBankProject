@showTransactions


Feature: Navigating to specific accounts in Accounts Activity
Description: The purpose of this feature is to test the Accounts Summary functionality

  Background: The user should be logged in and navigate to Account Activity Page
    Given the user can login successfully
    Given the user is on the "Account Activity" page


  Scenario: Account dropdown default option should be "Savings"
    Then Account dropdown default option should be "Savings"


  Scenario: Account dropdown should have the following options
    Then Account dropdown should have the following options
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |
      | Savings      |


  Scenario: Account dropdown should have the following options
    Then Transactions table should have the following options
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |