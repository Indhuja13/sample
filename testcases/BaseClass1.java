package com.seleniumtraining.testcases;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass1 
{
	
	public String baseURL="https://gmail.com";
	public String username="indhuja.s@tringapps.com";
	public String password="indhu.hearty13";
	public static WebDriver driver;
	//PART2
	public static Logger logger;
	
	
@BeforeClass
	public void setup() 
{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver2");		
		System.setProperty("webdriver.chrome.driver","/home/tringapps-admin/Downloads/chromedriver_linux64 (1)/chromedriver");
		driver=new ChromeDriver();
	//PART2	
		logger = Logger.getLogger("SeleniumTraining"); // Inorder to print in Log folder
		PropertyConfigurator.configure("log4j.properties");
}
@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
