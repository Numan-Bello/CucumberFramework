#Author: NeoTech Academy
Feature: Add Employee Feature
  I want to test Add Employee Functionality

  Background: 
    Given the user is logged in with valid credentials
    And user navigates to AddEmployee page

  @AddEmployee
  Scenario: Add Employee with first and last name
    When user enters employee first name and last name 
    And user selects a location
    And user clicks on save button
    Then validates that employee is added successfully

  @second
  Scenario Outline: Add Employee with parametarized first and last name
    When user enters employee "<firstName>" and "<lastName>"
    And user selects a location
    And user clicks on save button
    Then validates that "<fullname>" is added successfully

    Examples: 
      | firstName | lastName | fullname          |
      | Cristiano | Ronaldo  | Cristiano Ronaldo |

  @third
  Scenario: Add Employee with parametarized first and last name
    When user enters employee "Alex" and "Cedano"
    And user selects a location
    And user clicks on Create Login Details
    And user provides credentials
    And user clicks on save button
    Then validates that "Alex Cedano" is added successfully

  @fourth
  Scenario: Add Employee with parametarized first and last name
    When user enters employee "Harry" and "Phillips"
    And user selects a location
    And user clicks on Create Login Details
    And user provides credentials "harrryyy04433" "Harr@123" and "Harr@123"
    And user clicks on save button
    Then validates that "Harry Phillips" is added successfully

  #To perform DDT using Scenario Outline and Examples keyword
  @scenarioOutline
  Scenario Outline: Adding multiple employees with scenario outline
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user selects a location "<Location>"
    And user clicks on save button
    Then validate that "<FirstName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName | Location                         |
      | Joe       | R          | Biden    | New York Sales Office            |
      | Donald    | J          | Trump    | Chinese Development Center       |
      | Barrack   | H          | Obama    | South African Development Center |

  #To perform DDT using Datatable
  @usingDataTable
  Scenario: Adding multiple employees with Datatable
    When user enters employee details and clicks on save and validates it is added
      | FirstName | MiddleName | LastName |
      | May       | A          | Musk     |
      | Ahmet     | N          | Putin    |
      | Secil     | U          | Can      |
  
  @excelDataTable    
  Scenario: Adding multiple employees from Excel
  	When user enters employee data from "Employee" Excel sheet and saves the employee
