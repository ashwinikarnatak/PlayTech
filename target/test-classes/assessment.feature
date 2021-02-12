Feature: To ensure the legal age functionality on the sites

  Scenario: To ensure the legal age functionality on the site
    Given User is on the Playtech page
    When User enters the invalid age
    Then User is displayed with an error message
    When User enters the valid age
    Then User is navigated to About Us page
    Then User verifies that Number of Employees is "5900"
    And User verifies that Number of countries Playtech has offices in is "19"
    And User verifies that count of Global licensees is "140"
    And User verifies that Regulated Jurisdictions are "20"
    Then Close the browser
