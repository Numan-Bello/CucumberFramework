package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods
{
	
	@Given("I log in to HRM")
	public void i_log_in_to_hrm() 
	{
	    loginPage.adminLogin();
	}
	@When("I go to PIM tab and click Add Employee")
	public void i_go_to_pim_tab_and_click_add_employee() 
	{
	    click(dashboardPage.PIM);
	    click(dashboardPage.addEmployeeLink);
	}
	@When("when I enter the Employee {string}, {string} and {string}")
	public void when_i_enter_the_employee_and(String firstName, String lastName, String location) 
	{
	    waitForVisibility(addEmployeePage.firstName);
	    
	    sendText(addEmployeePage.firstName, firstName);
	    sendText(addEmployeePage.lastName, lastName);
	    
	    selectDropdown(addEmployeePage.location, location);
	    
	    pause(3);
	}
	@Then("I click the save button")
	public void i_click_the_save_button() 
	{
	    click(addEmployeePage.saveButton);
	}
	@Then("then the Personal Details page is displayed and I validate employee is added")
	public void then_the_peronal_details_page_is_displayed_and_i_validate_employee_is_added() 
	{
	    waitForVisibility(personalDetailsPage.firstName);
	}
	@When("I click on the employee Id and clear it")
	public void i_click_on_the_employee_id_and_clear_it() 
	{
	    sendText(addEmployeePage.employeeId, "");
	}
	@Then("I toggle the employee credentials button")
	public void i_toggle_the_employee_credentials_button() 
	{
	    jsClick(addEmployeePage.loginDetailsToggle);
	}
	@Then("I write the {string}, {string} and {string}")
	public void i_write_the_and(String username, String password, String confirmPassword) 
	{
		waitForVisibility(addEmployeePage.username);
		
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, confirmPassword);
	}

}
