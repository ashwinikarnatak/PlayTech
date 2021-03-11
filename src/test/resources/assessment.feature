Feature: To Order a T-Shirt and update the personal information

  Scenario: To Order a T-Shirt and update the personal information
    Given User logs in via "Chrome" using valid credentials
    When User orders a T-Shirt
    Then User verifies the order in Order History
    Then User updates First Name in My Account
    And Close the browser