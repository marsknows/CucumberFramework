Feature: Dashboard tabs verification
  @dashboard
  Scenario: Dashboard tab
    When user enter valid admin username and password
    And user clicks on login button
    Then user verfiy the dashboard options available on the page
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|