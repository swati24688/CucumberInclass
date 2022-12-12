@OtherLoginFeature @Regression
Feature: Techfios other login functionality validation

Background:
     Given User is on techfios login page

@OtherScenario1
 Scenario: User should be able to login with valid credentials(Other)
   When User enters username as "demo@techfios.com"
   When User enters password as "abc123"
   And User clicks on signin button
   Then User should land on Dashboard page

@OtherScenario2
 Scenario: User should not be able to login with invalid credentials(Other)
   When User enters username as "demo2@techfios.com"
   When User enters password as "abc123"
   And User clicks on signin button
   Then User should land on Dashboard page

@OtherScenario3 @Smoke
 Scenario: User should not be able to login with invalid credentials(Other)
   When User enters username as "demo@techfios.com"
   When User enters password as "abc124"
   And User clicks on signin button
   Then User should land on Dashboard page