
Feature: Login Form

  Background: The user is on the Login Page
    Given The user has navigated to the Login Page
    When The user scrolls down the Login page
    Then The user sees the correct Login page title


  Scenario: The user sees the Login form
    Then The user should see the Login form
    And The browser should close

  @debug
  Scenario Outline: Unsuccessful Login
    Given User enters personal details to login:
      | username   | password   |
      | <username> | <password> |
    When The Login Button is clicked
    Then Login error message with text "<error_message>" should be displayed
    And The user should see the Login button
    But The browser should close

    Examples:
      | username      | password        | error_message                       |
      | &^@#()=+      | WkLPWQvjmcz5QdH | ERROR: The username or password you entered is incorrect. Lost your password? |
      |               | WkLPWQvjmcz5QdH | Error: Username is required.        |
      |               |                 | Error: Username is required.        |
      | rooney123     |                 | ERROR: The password field is empty. |
      | 654321        | AbcdefgHIJK     | ERROR: The username or password you entered is incorrect. Lost your password? |
      | alabala@com   | AbcdefgHIJK     | ERROR: The username or password you entered is incorrect. Lost your password? |
      | 123123@1234   | AbcdefgHIJK     | ERROR: The username or password you entered is incorrect. Lost your password? |
      | validenEmail@gmail.com | 123    | ERROR: The username or password you entered is incorrect. Lost your password? |
      | validenEmail@gmail.com |        | ERROR: The password field is empty. |
      | alabala1234   | WkLPWQvjmcz5QdH | ERROR: The username or password you entered is incorrect. Lost your password? |
      | a             | 1               | ERROR: The username or password you entered is incorrect. Lost your password? |


  Scenario: The user clicks on "Remember Me" checkbox
    When The user clicks on RememberMe checkbox
    Then The checkbox becomes selected
    When The user clicks on RememberMe checkbox
    Then The checkbox becomes unselected
    And The browser should close
