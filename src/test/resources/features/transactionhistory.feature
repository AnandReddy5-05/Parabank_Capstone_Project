Feature: View Transaction History

  Scenario: User views transaction history
    Given the user is logged in for viewing transactions
    When the user navigates to Accounts Overview page
    And selects the first account
    Then the transaction history should be displayed
