Feature: Login validation
  @smoke @sprint1
  Scenario: Valid admin login
    When user enter valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
  @regression @sprint2
  Scenario: Valid ess login
    When user enter valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in
  @smoke
  Scenario: Valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user see invalid credentials message on login page