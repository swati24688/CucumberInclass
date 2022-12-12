@LoginFeature @Regression
Feature: Techfios billing login functionality validation

@Scenario1 @Smoke
Scenario Outline: User should be able to login with valid credentials
Given User is on techfios login page
When User enters username as "<username>"
When User enters password as "<password>"
And User clicks on signin button
Then User should land on Dashboard page

 Examples:
    |  username          | password |
    | demo@techfios.com  | abc123   |
    | demo2@techfios.com | abc123   |
    | demo@techfios.com  | abc1235  |
    | demo2@techfios.com | abc1235  |                       
    |                    |          |
    
#@Scenario2
#Scenario: User should not be able to login with invalid credentials
#Given User is on techfios login page
#When User enters username as "demo2@techfios.com"
#When User enters password as "abc123"
#And User clicks on signin button
#Then User should land on Dashboard page
#

#@Scenario3 @Smoke
#Scenario: User should not be able to login with invalid credentials
#Given User is on techfios login page
#When User enters username as "demo@techfios.com"
#When User enters password as "abc1235"
#And User clicks on signin button
#Then User should land on Dashboard page

#@Scenario4 @Smoke
#Scenario: User should not be able to login with invalid credentials
#Given User is on techfios login page
#When User enters username as "demo2@techfios.com"
#When User enters password as "abc1235"
#And User clicks on signin button
#Then User should land on Dashboard page

#@Scenario5 @Smoke
#Scenario: User should not be able to login with invalid credentials
#Given User is on techfios login page
#When User enters username as ""
#When User enters password as ""
#And User clicks on signin button
#Then User should land on Dashboard page