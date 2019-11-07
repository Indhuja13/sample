package com.seleniumtraining.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.seleniumtraining.utilities.ReadConfig;

public class BaseClass2 {
	//PART3
	ReadConfig readconfig=new ReadConfig();
	public String chromepath =readconfig.getChromePath();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	//PART2
	public static Logger logger;
	
	
	@BeforeClass
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());	
		//System.setProperty("webdriver.chrome.driver","/home/tringapps-admin/Downloads/chromedriver_linux64 (1)/chromedriver");
		driver=new ChromeDriver();
	//PART2	
		logger = Logger.getLogger("SeleniumTraining");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}