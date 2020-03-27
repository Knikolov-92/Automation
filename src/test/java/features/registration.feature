
Feature: Registration Form
Description: As a user, I want to be able to register on site, so that I can use its features

  Background: The user is on the Registration Page
    Given The user has navigated to the Registration Page
    When The user scrolls down the Registration page
    Then The user sees the correct Registration page title


  Scenario: The user sees the Registration form
    Then The user should see the Registration form
    And The browser should close


  Scenario Outline: Password Warning
    Given User enters personal details:
      | username   | email    | password   |
      | <username> | <email>  | <password> |
    Then Warning message with text "<password_warning>" should be displayed
    And The user should see the Register button
    And The Register button should be enabled: "<button_clickable>"
    And The Password Hint should be displayed: "<hint_displayed>"
    But The browser should close

    Examples:
      | username     | email                | password       | password_warning                              | button_clickable | hint_displayed |
      |              | validEmail@gmail.com | a1             | Very weak - Please enter a stronger password. | no               | yes            |
      | alabala12345 |                      | a1.#           | Weak - Please enter a stronger password.      | no               | yes            |
      | alabala12345 | validEmail@gmail.com | AbcdefgHIJK    | Medium                                        | yes              | no             |
      |              |                      | WkLPWQvjmcz5QdH| Strong                                        | yes              | no             |


  Scenario: User navigates to privacy policy page
    Given Privacy policy link is clicked
    Then The user should see the privacy policy page in new tab
    When The window is closed
    Then The user sees the correct Registration page title
    And The user should see the Register button
    But The browser should close


  Scenario Outline: Unsuccessful Registration
    Given User enters personal details to register:
      | username   | email    | password   |
      | <username> | <email>  | <password> |
    When The Register Button is clicked
    Then Registration error message with text "<error_message>" should be displayed
    And The user should see the Register button
    But The browser should close

    Examples:
      | username      | email                         | password        | error_message                                |
      | &^@#()=+      | validenEmail-=+12@example.com | WkLPWQvjmcz5QdH | Error: Please enter a valid account username.|
      |               | validenEmail-=+12@example.com | WkLPWQvjmcz5QdH | Error: Please enter a valid account username.|
      |               | alabala@com                   | WkLPWQvjmcz5QdH | Error: Please provide a valid email address. |
      | rooney123     | alabala@com                   |                 | Error: Please provide a valid email address. |
      | rooney123     | validenEmail-=+12@example.com |                 | Error: Please enter an account password.     |
      | rooney123     |                               | AbcdefgHIJK     | Error: Please provide a valid email address. |
      | rooney123     | alabala@com                   | AbcdefgHIJK     | Error: Please provide a valid email address. |
      | &^@#()=+      | alabala@com                   | AbcdefgHIJK     | Error: Please provide a valid email address. |
      | &^@#()=+      | 123123@1234                   | AbcdefgHIJK     | Error: Please provide a valid email address. |
      | alabala1234   | validenEmail-=+12@example.com | AbcdefgHIJK     | Error: An account is already registered with that username. Please choose another. |
      | rooney123     | validenEmail@gmail.com        | AbcdefgHIJK     | Error: An account is already registered with your email address. Please log in. |
      | abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890 | validenTestEmail+=1@example.com | AbcdefgHIJK | Error: Username may not be longer than 60 characters. |
      | abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890 |                   | AbcdefgHIJK     | Error: Please provide a valid email address. |
      | abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890 |                   |                 | Error: Please provide a valid email address. |


  Scenario Outline: Successful Registration
    Given User enters valid, randomized personal details:
      | username   | email    | password   |
      | <username> | <email>  | <password> |
    When The Register Button is clicked
    Then The successful registration page should be displayed
    When BackToSite link is clicked
    Then User should be on correct default URL
    But The browser should close

    Examples:
      | username      | email          | password |
      | validusername | validTestEmail | password |