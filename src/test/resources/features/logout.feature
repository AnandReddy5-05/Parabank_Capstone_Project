Feature: Logout

  Scenario: User logs out successfully
    Given the user is logged in for logout
    When the user clicks on Logout button
    Then the user should be redirected to the login page
