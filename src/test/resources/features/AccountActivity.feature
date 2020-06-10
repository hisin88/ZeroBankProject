@accountActivity


Feature: Account Activity
  Description: The purpose of this feature is to test the Account Activity Page functionality

  Background:
    Given the user can login successfully
    Given the user is on the "Account Activity" page

  Scenario: Account Activity Page should have title Zero - Account Activity
    Then "Account Activity" Page should have title "Zero - Account Activity"

