package com.neotech.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class BaseClass 
{
	
	public static WebDriver driver;
	
	public static void setUp()
	{
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		String browser = ConfigsReader.getProperty("browser");
		
		switch (browser.toLowerCase())
		{
			case "chrome":
//				ChromeOptions option = new ChromeOptions();
//				option.addArguments("--headless");
//				
//				driver = new ChromeDriver(option);
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
		
			default:
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		
		driver.manage().window().maximize();
		
		String url = ConfigsReader.getProperty("url");
		driver.get(url);
		
		PageInitializer.initialize();
	}
	
	public static void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}

}
