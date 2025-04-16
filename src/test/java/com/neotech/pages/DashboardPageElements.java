package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class DashboardPageElements 
{
	
	@FindBy(id="ohrm-small-logo")
	public WebElement logo;
	
	@FindBy(id="account-name")
	public WebElement accountName;
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(linkText="Add Employee")
	public WebElement addEmployeeLink;
	
	@FindBy(id="account-job")
	public WebElement accountTab;
	
	@FindBy(id="logoutLink")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//li[@id='menu_news_More']/a")
	public WebElement moreMenuItem;
	
	@FindBy(xpath="//div[@id='menu-content']/ul/li")
	public List<WebElement> menuList;
	
	public DashboardPageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
