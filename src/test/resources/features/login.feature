Feature: Parabank Login


Background:
 Given the user is on the Parabank login page

Scenario: Login with valid credentials
 When the user enters valid credentials
 And clicks the Login button
 Then the user should be redirected to the Account Overview page

Scenario: Login with invalid credentials
 When the user enters invalid credentials
 And clicks the Login button with invalid credentials
 Then an error message should be displayed