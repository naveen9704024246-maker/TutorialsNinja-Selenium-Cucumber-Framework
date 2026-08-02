Feature: Login Functionality
# Git Practice Session 1
  Background:
    Given user launches the browser
    When user clicks on My Account
    And user clicks on Login

  @Smoke
  Scenario: Login with valid credentials
    And user enters login email "jvns1@gmail.com"
    And user enters login password "11111"
    And user clicks on Login button
    Then user should login successfully

  @Regression
  Scenario: Login with invalid email
    And user enters login email "abc@gmail.com"
    And user enters login password "12345"
    And user clicks on Login button
    Then user should see warning message "Warning: No match for E-Mail Address and/or Password."

  @Regression
  Scenario: Login with invalid password
    And user enters login email "jvns1@gmail.com"
    And user enters login password "11111"
    And user clicks on Login button
    Then user should see warning message "Warning: No match for E-Mail Address and/or Password."

  @Regression
  Scenario Outline: Login with multiple credentials
    And user enters login email "<email>"
    And user enters login password "<password>"
    And user clicks on Login button
    Then login status should be "<status>"

    Examples:
      | email           | password | status |
      | jvns1@gmail.com | 12345    | Pass   |
      | abc@gmail.com   | 12345    | Fail   |
      | jvns1@gmail.com | 11111    | Fail   |