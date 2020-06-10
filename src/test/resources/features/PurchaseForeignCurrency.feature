@purchaseForeignCurrency

Feature: Purchase Foreign Currency
  Description: The purpose of this feature is to test the Purchase Foreign Currency functionality on Pay Bills

  Background: The user should be logged in, navigate to Account Summary Page and Find Transactions tab
    Given the user can login successfully
    Given the user is on the "Pay Bills" page
    Given the user is on the "Purchase Foreign Currency" tab


  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed


  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed