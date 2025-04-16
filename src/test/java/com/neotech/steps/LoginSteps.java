package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods
{
	
	@Given("I navigated to HRM website")
	public void i_navigated_to_hrm_website() 
	{
	    setUp();
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() 
	{
		sendText(loginPage.username, ConfigsReader.getProperty("username"));   
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() 
	{
	    sendText(loginPage.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() 
	{
	    click(loginPage.loginBtn);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() 
	{
	    String expected = "Jacqueline White";
	    String actual = dashboardPage.accountName.getText();
	    
	    if (actual.equals(expected))
	    {
	    	System.out.println("Test Passed!");
	    }
	    else
	    {
	    	System.out.println("Test Failed!");
	    }
	}
	
	@Then("I quit the browser")
	public void i_quit_the_browser()
	{
		tearDown();
	}
	
	@When("I enter an invalid password")
	public void i_enter_an_invalid_password()
	{
		sendText(loginPage.password, "abc2");
	}
	
	@Then("I validate that Invalid Credentials is displayed")
	public void i_validate_that_invalid_credentials_is_displayed()
	{
		boolean actual = loginPage.invalidMessage.isDisplayed();
		
		if (actual)
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
	}
	
	@When("user enters login info {string} and {string}")
	public void user_enters_login_info_and(String username, String password) 
	{
	    sendText(loginPage.username, username);
	    sendText(loginPage.password, password);
	}
	
	@When("I click on login button")
	public void i_click_on_login_button() 
	{
	    click(loginPage.loginBtn);
	}
	
	@Then("Welcome {string} message is displayed")
	public void welcome_message_is_displayed(String firstname) 
	{
	    String expected = firstname;
	    String actual = dashboardPage.accountName.getText();
	    
	    if (actual.contains(firstname))
	    {
	    	System.out.println(actual);
	    	Assert.assertNotEquals("The name does match!", expected, actual);
	    }
	    else
	    {
	    	System.out.println("Test failed!");
	    }
	}
	
	@When("user enters username and password and clicks on login")
	public void user_enters_username_and_password_and_clicks_on_login(DataTable dataTable) 
	{
	    List<Map<String, String>> employeeCredentials = dataTable.asMaps();
	    
	    for (Map<String, String> employee : employeeCredentials)
	    {
	    	System.out.println("Logging in with: " + employee.get("fullname"));
	    	
	    	String username = employee.get("username");
	    	String password = employee.get("password");
	    	String fullname = employee.get("fullname");
	    	
	    	sendText(loginPage.username, username);
	    	sendText(loginPage.password, password);
	    	
	    	click(loginPage.loginBtn);
	    	
	    	String expected = fullname;
		    String actual = dashboardPage.accountName.getText();
		    
		    Assert.assertEquals("The name does NOT match!", expected, actual);
		    
		    click(dashboardPage.accountTab);
		    click(dashboardPage.logoutBtn);
	    }
	}

}
