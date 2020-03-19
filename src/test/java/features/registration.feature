
Feature: Registration Form
Description: As a user, I want to be able to register on site, so that I can use its features

  Background: The user is on My Account Page
    Given The user has navigated to My Account Page
    Then The user should see the correct page title

  Scenario: The user sees the Registration form
    When The user scrolls down the page
    Then The user should see the Registration form

  Scenario: User sees InvalidUsername error
    Given User enters personal details:
      | username | email                     | password        |
      | &^@#()=+ | validEmail=123@gmail.com | WkLPWQvjmcz5QdH |
    When The Register Button is clicked
    Then The user should see the InvalidUsername error
    And The user should see the Register button

  Scenario: User sees InvalidEmail error
    Given User enters personal details:
      | username     | email       | password    |
      | alabala12345 | alabala@com | AbcdefgHIJK |
    When The Register Button is clicked
    Then The user should see the InvalidEmail error
    And The user should see the Register button

  Scenario: Registered user sees the AlreadyRegisteredUsername error
    Given User enters personal details:
      | username     | email                       | password    |
      | alabala123   | validEmail-123456@gmail.com | AbcdefgHIJK |
    When The Register Button is clicked
    Then The user should see the UsernameAlreadyTaken error
    And The user should see the Register button

  Scenario: Registered user sees the EmailAlreadyTaken error
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | AbcdefgHIJK |

    When The Register Button is clicked
    Then The user should see the EmailAlreadyTaken error
    And The user should see the Register button