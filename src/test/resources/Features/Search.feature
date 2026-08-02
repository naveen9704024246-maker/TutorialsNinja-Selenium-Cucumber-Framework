Feature: Search Functionality

  Background:
    Given user launches the browser

  @Smoke
  Scenario: Search valid product

    When user searches product "iPhone"
    And user clicks on Search button
    Then searched product "iPhone" should be displayed

  @Regression
  Scenario: Search another valid product

    When user searches product "MacBook"
    And user clicks on Search button
    Then searched product "MacBook" should be displayed

  @Regression
  Scenario: Search invalid product

    When user searches product "Nokia123"
    And user clicks on Search button
    Then no product should be found

  @Regression
  Scenario: Search without entering product

    When user searches product ""
    And user clicks on Search button
    Then no product should be found

  @Sanity
  Scenario Outline: Search multiple products

    When user searches product "<product>"
    And user clicks on Search button
    Then search status should be "<status>" for "<product>"

    Examples:
      | product  | status |
      | iPhone   | Pass   |
      | MacBook  | Pass   |
      | Samsung  | Pass   |
      | Nokia123 | Fail   |