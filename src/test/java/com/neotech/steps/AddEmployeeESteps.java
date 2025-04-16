package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeESteps extends CommonMethods 
{

	@Given("user navigates to AddEmployee page")
	public void method1() 
	{
		click(dashboardPage.PIM);
		click(dashboardPage.addEmployeeLink);
	}

	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() 
	{
		waitForVisibility(addEmployeePage.firstName);

		sendText(addEmployeePage.firstName, "Lionel");
		sendText(addEmployeePage.lastName, "Messi");
	}

	@When("user selects a location")
	public void user_selects_a_location() 
	{
		selectDropdown(addEmployeePage.location, "New York Sales Office");
	}

	@When("user clicks on save button")
	public void user_clicks_save_button() 
	{
		pause(2);

		click(addEmployeePage.saveButton);
	}

	@Then("validates that employee is added successfully")
	public void validates_that_employee_is_added_successfully() 
	{
		waitForVisibility(personalDetailsPage.firstName);

		String expected = "Lionel Messi";
		String actual = personalDetailsPage.fullName.getText();

		Assert.assertEquals("The employee name does NOT match!", actual, expected);
	}

	@When("user enters employee {string} and {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) 
	{
		waitForVisibility(addEmployeePage.firstName);

		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
	}

	@Then("validates that {string} is added successfully")
	public void validates_that_is_added_successfully(String fullname) 
	{
		waitForVisibility(personalDetailsPage.firstName);

		String expected = fullname;
		String actual = personalDetailsPage.fullName.getText();

		Assert.assertEquals("The employee name does NOT match!", expected, actual);
	}

	@When("user clicks on Create Login Details")
	public void user_clicks_on_create_login_details() 
	{
		jsClick(addEmployeePage.loginDetailsToggle);
	}

	@When("user provides credentials")
	public void user_provides_credentials() 
	{
		sendText(addEmployeePage.username, "delPiero56");
		sendText(addEmployeePage.password, "Juventus@123");
		sendText(addEmployeePage.confirmPassword, "Juventus@123");
	}

	@When("user provides credentials {string} {string} and {string}")
	public void user_provides_credentials_and(String username, String password, String confirmPassword) 
	{
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, confirmPassword);
	}

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String firstName, String middleName, String lastName) 
	{
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.middleName, middleName);
		sendText(addEmployeePage.lastName, lastName);
	}

	@When("user selects a location {string}")
	public void user_selects_a_location(String location) 
	{
		selectDropdown(addEmployeePage.location, location);
	}

	@Then("validate that {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstName, String lastName) 
	{
		waitForVisibility(personalDetailsPage.fullName);
		
		String expected = firstName + " " + lastName;
		String actual = personalDetailsPage.fullName.getText();
		
		Assert.assertEquals("The employee name does NOT match", expected, actual);
	}
	
	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details(DataTable dataTable) 
	{
		//asLsits() method returns a List for every row (including the header)
	    //System.out.println(dataTable.asLists());
	    
	    //asMaps() method returns a List of Maps for every data row (without including the header)
	    //System.out.println(dataTable.asMaps());
		
		List<Map<String, String>> employeeList = dataTable.asMaps();
		
		for (Map<String, String> employee : employeeList)
		{
			System.out.println(employee);
			
			String fName = employee.get("FirstName"); 
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");
			
			sendText(addEmployeePage.firstName, fName);
			sendText(addEmployeePage.middleName, mName);
			sendText(addEmployeePage.lastName, lName);
			
			selectDropdown(addEmployeePage.location, "New York Sales Office");
			
			pause(1);
			
			click(addEmployeePage.saveButton);
			
			waitForVisibility(personalDetailsPage.fullName);
			
			String expectedName = fName + " " + lName;
			String actualName = personalDetailsPage.fullName.getText();
			
			Assert.assertEquals("The employee name does NOT match", expectedName, actualName);
			
			pause(1);
			
			click(dashboardPage.addEmployeeLink);
		}
		tearDown();
	}
	
	@When("user enters employee data from {string} Excel sheet and saves the employee")
	public void user_enters_employee_data_from_excel_sheet_and_saves_the_employee(String sheetName) 
	{
	    String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel 1.xlsx";
	    
	    List<Map<String, String>> excelData = ExcelUtility.excelIntoListOfMaps(path, sheetName);
	    
	    for (Map<String, String> employee : excelData)
	    {
	    	String fname = employee.get("FirstName");
	    	String lname = employee.get("LastName");
	    	String location = employee.get("Location");
	    	String user = employee.get("Username");
	    	String pass = employee.get("Password");
	    	
	    	sendText(addEmployeePage.firstName, fname);
	    	sendText(addEmployeePage.lastName, lname);
	    	
	    	selectDropdown(addEmployeePage.location, location);
	    	
	    	jsClick(addEmployeePage.loginDetailsToggle);
	    	
	    	sendText(addEmployeePage.username, user);
	    	sendText(addEmployeePage.password, pass);
	    	sendText(addEmployeePage.confirmPassword, pass);
	    	
	    	pause(2);
	    	
	    	click(addEmployeePage.saveButton);
	    	
	    	waitForVisibility(personalDetailsPage.personalDetailsForm);
	    	
	    	String expectedText = fname + " " + lname;
	    	String actualText = personalDetailsPage.fullName.getText();
	    	
	    	Assert.assertEquals("Employee NOT added!", expectedText, actualText);
	    	
	    	click(dashboardPage.addEmployeeLink);
	    }
	}

}
