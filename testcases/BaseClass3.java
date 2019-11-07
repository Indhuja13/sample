package com.seleniumtraining.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.seleniumtraining.utilities.ReadConfig;

public class BaseClass3 {
	//PART3
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	//PART2
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
	//PART2
		logger = Logger.getLogger("SeleniumTraining");
		PropertyConfigurator.configure("Log4j.properties");
		//PART4
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/home/tringapps-admin/Downloads/chromedriver_linux64 (1)/chromedriver");
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
