Feature: User Registration at Parabank

Scenario: Successful user registration
Given the user is on Home page
When the user clicks on Register
When the user enters valid registration details
And clicks on the Register button
Then the user account should be created successfully