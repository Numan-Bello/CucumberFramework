package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class PersonalDetailsPageElements 
{
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="employeeId")
	public WebElement employeeId;
	
	@FindBy(id="pim.navbar.employeeName")
	public WebElement fullName;
	
	@FindBy(id="pimPersonalDetailsForm")
	public WebElement personalDetailsForm;
	
	@FindBy(id="licenseNo")
	public WebElement driverLicense;
	
	@FindBy(xpath="//label[text()='License Expiry Date']/following-sibling::span[1]/child::span/child::i")
	public WebElement licenseExpirationDate;
	
	@FindBy(xpath="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licenseExpirationYearInput;
	
	@FindBy(xpath="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']//li")
	public List<WebElement> licenseExpirationYearOptions;
	
	@FindBy(xpath="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licenseExpirationMonthInput;
	
	@FindBy(xpath="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']//li")
	public List<WebElement> licenseExpirationMonthOptions;
	
	@FindBy(xpath="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//td")
	public List<WebElement> licenseExpirationDays;
	
	@FindBy(xpath="//label[text()='Smoker']")
	public WebElement smokerCheckbox;
	
	@FindBy(xpath="//div[@id='emp_gender_inputfileddiv']//span[@class='caret']")
	public WebElement genderDropdown; //id="emp_gender";
	
	@FindBy(xpath="//div[@id='emp_gender_inputfileddiv']/div/input")
	public WebElement genderInput;
	
	@FindBy(xpath="//div[@id='emp_gender_inputfileddiv']//li")
	public List<WebElement> genderOptions;
	
	@FindBy(xpath="//div[@id='nation_code_inputfileddiv']//span[@class='caret']")
	public WebElement nationalityDropdown;
	
	@FindBy(xpath="//div[@id='nation_code_inputfileddiv']//input")
	public WebElement nationalityInput;
	
	@FindBy(xpath="//div[@id='nation_code_inputfileddiv']//li")
	public List<WebElement> nationalityOptions;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement saveButton;
	
	public PersonalDetailsPageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

}
