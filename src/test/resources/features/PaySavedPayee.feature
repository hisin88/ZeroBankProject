@paySavedPayee

Feature: Pay Saved Payee
  Description: The purpose of this feature is to test the Pay Saved Payee functionality on Pay Bills

  Background: The user should be logged in, navigate to Account Summary Page and Find Transactions tab
    Given the user can login successfully
    Given the user is on the "Pay Bills" page
    Given the user is on the "Pay Saved Payee" tab

  @wip
  Scenario: Pay Bills Page should have title Zero - Pay Bills
    Then "Pay Bills" Page should have title "Zero - Pay Bills"


  Scenario Outline: Pay operation positive test
    When user enter the following information "<Amount>" "<Date>" "<Description>"
    Then confirmation message should be displayed "<Expected Message>"
    Examples:
      | Amount | Date       | Description | Expected Message                        |
      | 1000   | 2020-09-19 | Shopping    | The payment was successfully submitted. |
      | 1      | 2020-09-26 | Rent        | The payment was successfully submitted. |


  Scenario Outline: Pay operation negative test with expected message
    When user enter the following information "<Amount>" "<Date>" "<Description>"
    Then error message should be displayed "<Expected Message>"
    Examples:
      | Amount | Date       | Description | Expected Message                        |
      | blank  | 2020-09-19 | Shopping    | Please fill out this field.             |
      | 1000   | blank      | Shopping    | Please fill out this field.             |


  Scenario Outline: Pay operation negative test with non-expected message
    When user enter the following information "<Amount>" "<Date>" "<Description>"
    Then confirmation message should not be displayed
    Examples:
      | Amount | Date       | Description |
      | ABC    | 2020-09-19 | Shopping    |
      | $123   | 2020-09-19 | Shopping    |
      | $123   | ABC        | Shopping    |