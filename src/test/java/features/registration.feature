
Feature: Registration Form
Description: As a user, I want to be able to register on site, so that I can use its features

  Background: The user is on My Account Page
    Given The user has navigated to My Account Page
    And The user scrolls down the page
    Then The user should see the correct page title

  Scenario: The user sees the Registration form
    When The user should see the correct page title
    Then The user should see the Registration form
    And The browser should close

  Scenario: User sees the VeryWeak Password warning
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | a1 |
    Then The user should see the VeryWeak password warning
    And The user should see the Register button
    And The Register button should not be clickable
    But The browser should close

  Scenario: User sees the Weak Password warning
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | a1.# |
    Then The user should see the Weak password warning
    And The user should see the Register button
    And The Register button should not be clickable
    But The browser should close

  Scenario: User sees the Medium Password warning
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | AbcdefgHIJK |
    Then The user should see the Medium password warning
    And The user should see the Register button
    And The Register button should be clickable
    But The browser should close

  Scenario: User sees the Strong Password warning
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | WkLPWQvjmcz5QdH |
    Then The user should see the Strong password warning
    And The user should see the Register button
    And The Register button should be clickable
    But The browser should close

  Scenario: User sees InvalidUsername error
    Given User enters personal details:
      | username | email                     | password        |
      | &^@#()=+ | validEmail=123@gmail.com | WkLPWQvjmcz5QdH |
    When The Register Button is clicked
    Then The user should see the InvalidUsername error
    And The user should see the Register button
    But The browser should close

  Scenario Outline: User sees InvalidEmail error
    Given User enters personal details:
      | username   | email    | password   |
      | <username> | <email>  | <password> |
    When The Register Button is clicked
    Then The user should see the InvalidEmail error
    And The user should see the Register button
    But The browser should close

    Examples:
      | username      | email         | password    |
      | alabala12345  | alabala@com   | AbcdefgHIJK |
      | &^@#()=+      | alabala@com   | AbcdefgHIJK |
      | &^@#()=+      | 123123@1234   | AbcdefgHIJK |

  Scenario: Registered user sees the AlreadyRegisteredUsername error
    Given User enters personal details:
      | username     | email                       | password    |
      | alabala123   | validEmail-123456@gmail.com | AbcdefgHIJK |
    When The Register Button is clicked
    Then The user should see the UsernameAlreadyTaken error
    And The user should see the Register button
    But The browser should close

  Scenario: Registered user sees the EmailAlreadyTaken error
    Given User enters personal details:
      | username     | email                | password    |
      | alabala12345 | validEmail@gmail.com | AbcdefgHIJK |
    When The Register Button is clicked
    Then The user should see the EmailAlreadyTaken error
    And The user should see the Register button
    But The browser should close