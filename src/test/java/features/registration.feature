
Feature: Registration Form
Description: As a user, I want to be able to register on site, so that I can use its features

  Background: The user is on My Account Page
    Given The user has navigated to My Account Page
    Then The user should be on the correct URL

  Scenario: The user sees the Registration form
    When The user scrolls down the page
    Then The user should see the Registration form
