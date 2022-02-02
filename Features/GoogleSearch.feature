Feature: Gmail forgot username
  Scenario: Navigate to gmail page and try to get the password
    Given Navigate to gmail page
    When I type keywoard ashish in the search box and then hit Forgot email link
    Then It takes me to the next page and i verify the title
    And i am able to close the browser

  Scenario: Navigate to gmail page and try to get the lost password
    Given Navigate to gmail page
    When I type keywoard ashish in the search box and then hit Forgot email link
    Then It takes me to the next page and i verify the title
    And i am able to close the browser