Feature: Adding Employee

  #@employee
  #Scenario Outline:
  #Given I log in to HRM
  #When I go to PIM tab and click Add Employee
  #And when I enter the Employee "<firstName>", "<lastName>" and "<location>"
  #Then I click the save button
  #And then the Personal Details page is displayed and I validate employee is added
  #
  #Examples:
  #| firstName | lastName | location              |
  #| Chris     | Tucker   | New York Sales Office |
  #
  #@employee
  #Scenario Outline:
  #Given I log in to HRM
  #When I go to PIM tab and click Add Employee
  #And when I enter the Employee "<firstName>", "<lastName>" and "<location>"
  #And I click on the employee Id and clear it
  #Then I click the save button
  #And then the Personal Details page is displayed and I validate employee is added
  #
  #Examples:
  #| firstName | lastName | location         |
  #| Gavin     | Fischer  | Sheffield Office |
  Background: 
    Given the user is logged in with valid credentials
    And user navigates to AddEmployee page

  @forHomework
  Scenario Outline: Adding multiple employees with scenario outline
    When user enters employee "<firstName>" and "<lastName>"
    And user selects a location "<location>"
    And user clicks on Create Login Details
    And user provides credentials "<username>" "<password>" and "<confirmPassword>"
    And user clicks on save button
    Then validate that "<firstName>" and "<lastName>" is added successfully

    Examples: 
      | firstName | lastName | location              | username | password  | confirmPassword |
      | Henry     | Clarkson | German Regional HQ    | rccc6    | Secret123 | Secret123       |
      | John      | Murphy   | Sheffield Office      | rccc7    | Secret123 | Secret123       |
      | Rebecca   | Willson  | London Office         | rccc8    | Secret123 | Secret123       |
      | Diana     | Thompson | New York Sales Office | rccc9    | Secret123 | Secret123       |
