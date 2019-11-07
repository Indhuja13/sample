package com.seleniumtraining.testcases;

	import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumtraining.utilities.ReadConfig;
import com.seleniumtraining.utilities.Reporting1;

	public class BaseClass6 extends Reporting1{
		
		
		public String testCaseName;
		public String testDescription;
		public String testNodes;
		public String authors;
		public String category;
		//PART3
		ReadConfig readconfig=new ReadConfig();
		
		public String baseURL=readconfig.getApplicationURL();
		public String username=readconfig.getUsername();
		public String password=readconfig.getPassword();
		public static WebDriver driver;
		//PART2
		public static Logger logger;
		
		
		@BeforeSuite()
		public void beforeSuite() {
			startResult();
		}

		
		
		@BeforeMethod()
		public void beforeMethod() throws MalformedURLException { 
			test = startTestModule(testCaseName 
					, testDescription);
			test = startTestCase(testNodes);
			test.assignCategory(category);//no need to create it will take automatically
			test.assignAuthor(authors);
		}
		
		@Parameters("browser")
		//@BeforeClass
		//@Test(priority=0)
		@BeforeMethod()
		public void setup(String br) {
			
		//PART2
			logger = Logger.getLogger("SeleniumTraining");
			PropertyConfigurator.configure("Log4j.properties");
			//PART4
			if(br.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","/home/tringapps-admin/Downloads/chromedriver_linux64 (1)/chromedriver");
				driver=new ChromeDriver();
				driver.get(baseURL);
				logger.info("URL is entered");
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
		

		@AfterMethod
		public void afterMethod() throws FileNotFoundException, IOException {
			endResult();
		
		}

		@AfterSuite()
		public void afterSuite() {

			driver.quit();

		}



		@Override
		public long takeScreenShot() {
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
			try {
				File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFiler,
						new File(System.getProperty("user.dir") + "/reports/images/" + number + ".png"));
			} catch (WebDriverException e) {
				System.out.println("The browser has been closed.");
			} catch (IOException e) {
				System.out.println("The snapshot could not be taken");
			}
			return number;
		}
	}


