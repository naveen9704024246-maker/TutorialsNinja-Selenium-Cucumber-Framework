Feature: Product Search Functionality

  Scenario: Verify product search with valid product name
    Given user is on the TutorialsNinja home page
    When user enters product name "iPhone" in the search box
    And user clicks the search button
    Then search results should be displayed