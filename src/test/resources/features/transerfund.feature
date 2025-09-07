Feature: Transfer Funds
Background:
     Given the user is logged in for transferring funds
     When the user navigates to Transfer Funds page

  Scenario: Transfer funds successfully between two accounts

    And the user enters sufficientAmount "500"
    And clicks on Transfer button
    Then the funds should be transferred successfully
   
   Scenario: Transfer funds with insufficient balance
   
    And the user enters insufficientamount "99999"
    And clicks on Transfer button
    Then an error message "Insufficient Funds" should be displayed