Feature: To Order a product and update the personal information

  Scenario: To Order a product and update the personal information
    Given User logs in via "Chrome" using valid credentials
    When User orders a T-Shirt
    Then User verify in Order History
    Then User updates First Name in My Account
    Then Close the browser