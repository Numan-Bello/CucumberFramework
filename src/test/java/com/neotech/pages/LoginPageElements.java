package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods
{
	
	@FindBy(xpath="//input[@id='txtPassword']/../preceding-sibling::div/input")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='txtUsername']/../following-sibling::div/input")
	public WebElement password;
	
	@FindBy(xpath="//div[@class='input-field']/following-sibling::div/button")
	public WebElement loginBtn;
	
	@FindBy(id="txtPassword-error")
	public WebElement passwordError;
	
	@FindBy(css="div.toast-message")
	public WebElement invalidMessage;
	
	public LoginPageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void adminLogin()
	{
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		click(loginBtn);
	}

}
