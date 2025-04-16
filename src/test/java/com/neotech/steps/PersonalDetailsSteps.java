package com.neotech.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalDetailsSteps extends CommonMethods
{
	
	@When("user enters employee first name {string} and last name {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) 
	{
		waitForVisibility(addEmployeePage.firstName);

		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
	}
	
	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String DriverLicense, String ExpirationDate, String Smoker, String Gender, String Nationality) 
	{
	    waitForVisibility(personalDetailsPage.personalDetailsForm);
	    
	    sendText(personalDetailsPage.driverLicense, DriverLicense);
	    
	    pause(1);
	   
	    String[] dateParts = ExpirationDate.split("-"); 
	    
	    click(personalDetailsPage.licenseExpirationDate);
	    
	    selectDropdownByClicking(personalDetailsPage.licenseExpirationYearInput, personalDetailsPage.licenseExpirationYearOptions, dateParts[0]);
	    
	    int month = Integer.parseInt(dateParts[1]);
	    
	    click(personalDetailsPage.licenseExpirationMonthInput);
	    click(personalDetailsPage.licenseExpirationMonthOptions.get(month - 1));
	    
	    int day = Integer.parseInt(dateParts[2]);
	    
	    selectCalendarDate(personalDetailsPage.licenseExpirationDays, day + "");
	    
	    pause(1);
	    
	    if (Smoker.equals("Yes"))
	    {
	    	click(personalDetailsPage.smokerCheckbox);
	    }
	    
	    pause(1);
	    
//	    click(personalDetailsPage.genderInput);
//	    click(driver.findElement(By.xpath("//span[text()='"+Gender+"']")));
	    
	    selectDropdownByClicking(personalDetailsPage.genderInput, personalDetailsPage.genderOptions, Gender);
	    selectDropdownByClicking(personalDetailsPage.nationalityInput, personalDetailsPage.nationalityOptions, Nationality);
	}
	
	/**
	 * This method will click on the input tag of  a dropdown and then get all the options, then 
	 * would compare and click on the given option value.
	 * 
	 * @param input
	 * @param options
	 * @param value
	 */
	public void selectDropdownByClicking(WebElement input, List<WebElement> options, String value)
	{
		click(input);
		
		for (WebElement option : options)
	    {
	    	if (option.getText().equals(value))
	    	{
	    		click(option);
	    		break;
	    	}
	    }
	    
	    pause(1);
	}
	
	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() 
	{
	    click(personalDetailsPage.saveButton);
	}

}
