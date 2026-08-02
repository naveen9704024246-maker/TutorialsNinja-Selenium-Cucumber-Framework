Feature: Add To Cart Functionality

  Background:
    Given user launches the browser
    When user clicks on My Account
    And user clicks on Login
    And user enters login email "jvns1@gmail.com"
    And user enters login password "12345"
    And user clicks on Login button
    Then user should login successfully

  @Smoke
  Scenario: Add iPhone to cart

    When user searches cart product "iPhone"
    And user clicks on Cart Search button
    And user adds product to cart
    Then product should be added successfully

  @Regression
  Scenario: Add MacBook to cart

    When user searches cart product "MacBook"
    And user clicks on Cart Search button
    And user adds product to cart
    Then product should be added successfully

  @Regression
  Scenario: Add Samsung SyncMaster to cart

    When user searches cart product "Samsung SyncMaster"
    And user clicks on Cart Search button
    And user adds product to cart
    Then product should be added successfully

  @Regression
  Scenario Outline: Add multiple products

    When user searches cart product "<product>"
    And user clicks on Cart Search button
    And user adds product to cart
    Then cart status should be "<status>"

    Examples:
      | product              | status |
      | iPhone               | Pass   |
      | MacBook              | Pass   |
      | Samsung SyncMaster   | Pass   |

  @Sanity
  Scenario: Verify cart total

    When user searches cart product "iPhone"
    And user clicks on Cart Search button
    And user adds product to cart
    Then shopping cart should contain product