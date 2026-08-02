Feature: Registration Functionality

  Background:
    Given user launches the browser
    When user clicks on My Account
    And user clicks on Register

  @Smoke
  Scenario: Register with mandatory fields
    And user enters first name "Naveen"
    And user enters last name "Jerubandi"
    And user enters registration email with random email
    And user enters telephone "9876543210"
    And user enters registration password "12345"
    And user confirms password "12345"
    And user selects Privacy Policy
    And user clicks on Continue button
    Then account should be created successfully

  @Regression
  Scenario: Register with existing email
    And user enters first name "Naveen"
    And user enters last name "Jerubandi"
    And user enters registration email "jvns1@gmail.com"
    And user enters telephone "9876543210"
    And user enters registration password "12345"
    And user confirms password "12345"
    And user selects Privacy Policy
    And user clicks on Continue button
    Then warning message "Warning: E-Mail Address is already registered!" should be displayed

  @Regression
  Scenario: Register without mandatory fields
    And user clicks on Continue button
    Then warning messages should be displayed for all mandatory fields

  @Regression
  Scenario Outline: Register multiple users
    And user enters first name "<firstname>"
    And user enters last name "<lastname>"
    And user enters registration email with random email
    And user enters telephone "<phone>"
    And user enters registration password "<password>"
    And user confirms password "<password>"
    And user selects Privacy Policy
    And user clicks on Continue button
    Then account creation status should be "<status>"

    Examples:
      | firstname | lastname | phone      | password | status |
      | Naveen    | Kumar    | 9876543210 | 12345    | Pass   |
      | Ravi      | Kumar    | 9123456789 | abc123   | Pass   |