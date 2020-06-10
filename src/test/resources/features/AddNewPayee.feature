@addNewPayee
@exceptLogin

Feature: Add new payee under pay bills
  Description: The purpose of this feature is to test the Add New Payee functionality on Pay Bills

  Background: The user should be logged in, navigate to Account Summary Page and Find Transactions tab
    Given the user is on the login page
    Given the user can login successfully
    Given the user is on the "Pay Bills" page
    Given the user is on the "Add New Payee" tab


  Scenario: Add a new payee
    When creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed