Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And clicks on Add Employee button
  @1027
  Scenario: first scenario adding the employee
    When user enters first name middle name and last name
    And user clicks on save button
    Then employee added successfully

  @1028
  Scenario: adding an employee from feature file
    When user enters "island" "boi" and "mars"
    And user clicks on save button
    Then employee added successfully

  @examples
  Scenario Outline: adding an employee from feature file
    When user enters "<firstName>" "<midName>" and "<lastName>" for an employee
    And user clicks on save button
    Then employee added successfully
    Examples:
    |firstName|midName|lastName|
    |Island|Boi|Mars|
    |Mars|Island|Boi|
    |Mar|S|Knows|


  @1027
  Scenario: second scenario of adding employee
    When user enters first name middle name and last name
    And user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: third scenario of adding employee
    When user enters first name middle name and last name
    And user selects checkbox
    When user enters username and password and confirm password
    And user clicks on save button
    Then employee added successfully

  @datatable
  Scenario: adding an employee using data table
    When I add multiple employees and verify that user has been added successfully
    |firstName|midName|lastName|
    |Island|Boi|Mars|
    |Mars|Island|Boi|
    |Mar|S|Knows|
    |King|Mars|Knows|
    |Mario|A|King|

    @excel
    Scenario: Adding an employee from excel file
      When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee

