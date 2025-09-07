Feature: Open New Account

Scenario: Successfully open a new Checking account
    Given the user is logged in for opening a new account
    When the user navigates to Open New Account page
    And selects account type "CHECKING"
    And submits the request
    Then a new account should be opened successfully
