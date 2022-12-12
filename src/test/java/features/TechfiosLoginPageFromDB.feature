@LoginFromDBFeature @Regression
Feature: Techfios billing login functionality validation with driving the data from MySQL DB

@Scenario1 
Scenario: User should be able to login with valid credentials from DB
Given User is on techfios login page
When User enters "username" from techfios database
When User enters "password" from techfios database
And User clicks on signin button
Then User should land on Dashboard page
