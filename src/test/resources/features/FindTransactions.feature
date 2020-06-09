@findTransactions
@exceptLogin

Feature: Find Transactions in Accounts Activity
  Description: The purpose of this feature is to test the Find Transactions functionality on Accounts Activity

  Background: The user should be logged in, navigate to Account Summary Page and Find Transactions tab
    Given the user is on the login page
    Given the user can login successfully
    Given the user is on the "Account Activity" page
    Given the user is on the "Find Transactions" tab


  Scenario Outline: Search Date Range
    When the user enters date range from "<fromDate>" to "<toDate>"
    And clicks search
    Then results table should only show transactions between "<fromDate>" and "<toDate>"
    And the results should be sorted by most recent date
    Examples:
      | fromDate   | toDate     |
      | 2012-09-01 | 2012-09-06 |
      | 2012-09-02 | 2012-09-06 |


  Scenario Outline: Search description
    When the user enters description "<Search Words>"
    And clicks search
    Then results table should only show descriptions containing "<Search Words>"
    But results table should not show descriptions containing "<Other Words>"
    Examples:
      | Search Words | Other Words |
      | ONLINE       | OTHER       |
      | OFFICE       | OTHER       |


  Scenario Outline: Search description case sensitive/insensitive
    When the user enters description "<Search Words>"
    And clicks search
    Then results table should only show descriptions containing "<Search Words>"
    Examples:
      | Search Words |
      | ONLINE       |
      | online       |

  @wip
  Scenario Outline: Type
    When user selects type "<Search Type>"
    And clicks search
    Then results table should show appropriate result based on "<Search Type>"
    Examples:
      | Search Type |
      | Any         |
      | Deposit     |
      | Withdrawal  |