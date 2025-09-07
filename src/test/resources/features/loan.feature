Feature: Apply for Loan
Background:
    Given the user is logged in for loan request
    When the user navigates to Request Loan page

  Scenario: Apply for loan with valid details
    And the user enters loan amount "10000" and down payment "2000"
    And selects an account for loan
    And submits the loan request
    Then the loan should be approved successfully
    
   Scenario: Loan denied due to insufficient balance
    And the user enters loan amount "50000", down payment "1000", and account number "12345"
    And clicks on Apply Now button
    Then the loan should be denied with message "Loan denied"