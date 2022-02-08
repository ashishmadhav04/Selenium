Feature: Google Search

  Scenario: Navigate to google page and try to type winter olympics
    Given Navigate to google page
    When Type keyword "winter olympics" in the search box
    Then i am able to close the browser

  Scenario: Navigate to google page and try to type 2021
    Given Navigate to google page
    When Type keyword "2021" in the search box
    Then Wait for 1000 milliseconds
    And i am able to close the browser

  Scenario Outline: Navigate to google page and try searching for different things
    Given Navigate to google page
    When Type keyword "<keyword>" in the search box
    Then Wait for <time> milliseconds
    And i am able to close the browser


    Examples:
    | keyword | time |
    | covid | 3000 |
    | canada news | 7000  |