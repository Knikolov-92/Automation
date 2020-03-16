
Feature: Login Form

  Background: User is on My Account Page
    Given User navigates to My Account Page
    Then User should see the LOG In form

  @login
  Scenario: Registered user can log into My Account
    When The user enters their username in the username field
    And The user enters their password in the password field
    And The user click on the Log In button
    Then They should see the greeting message

