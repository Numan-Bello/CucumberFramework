@Login
Feature: Login Functionality

  @regression
  Scenario: Valid Login to HRM
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in

  
  @smoke
  Scenario: Invalid Login to HRM
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that Invalid Credentials is displayed


  @homework
  Scenario Outline: Login using Scenario Outline and Example Table
    When user enters login info "<username>" and "<password>"
    And I click on login button
    Then Welcome "<firstname>" message is displayed

    Examples: 
      | username | password  | firstname | fullname        |
      | rccc6    | Secret123 | Henry     | Henry Clarkson  |
      | rccc7    | Secret123 | John      | John Murphy     |
      | rccc8    | Secret123 | Rebecca   | Rebecca Willson |
      | rccc9    | Secret123 | Diana     | Diana Thompson  |
      
  @homework
  Scenario: Login using Data-table
  	When user enters username and password and clicks on login
  	  | username | password  | firstname | fullname        |
      | rccc6    | Secret123 | Henry     | Henry Clarkson  |
      | rccc7    | Secret123 | John      | John Murphy     |
      | rccc8    | Secret123 | Rebecca   | Rebecca Willson |
      | rccc9    | Secret123 | Diana     | Diana Thompson  |
