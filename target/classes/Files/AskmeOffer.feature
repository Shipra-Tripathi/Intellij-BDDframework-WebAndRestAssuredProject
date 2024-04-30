Feature: To Test online website
  Scenario: To verify test links

    Given user should be able to open URL in browser
    And User should be able to navigated on dashboard screen
    When User should be able to click on Home page and search the products and validate title
    And User should be able to click on About us page and validate
    And User should be able to click on breaking news and validate
    When user should receive a message no result found  while searching invalid data in breaking news tab
    Then user should be able to go back to home page