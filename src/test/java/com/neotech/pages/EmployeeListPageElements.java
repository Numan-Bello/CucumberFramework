package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;

public class EmployeeListPageElements extends CommonMethods
{
	
	@FindBy(xpath="//span[text()='Employee List']")
	public WebElement employeeList;
	
	@FindBy(xpath="//table[@id='employeeListTable']/tbody/tr")
	public List<WebElement> rows;
	
	@FindBy(id="employee_name_quick_filter_employee_list_value")
	public WebElement searchBox;
	
	@FindBy(id="quick_search_icon")
	public WebElement searchIcon;
	
	public EmployeeListPageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

}
