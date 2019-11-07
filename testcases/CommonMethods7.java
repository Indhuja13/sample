package com.seleniumtraining.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.seleniumtraining.utilities.ReadConfig;
import com.seleniumtraining.utilities.Reporting1;

public class CommonMethods7 extends Reporting1 {
	
	public  WebDriver driver;
	
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	
	//public static WebDriver driver;
	//PART2
	public static Logger logger;
	
	
	@Parameters("browser")
	//@BeforeClass
	//@Test(priority=0)
	@BeforeMethod()
	public void setup(String br) {
		
	//PART2
		logger = Logger.getLogger("SeleniumTraining");
		PropertyConfigurator.configure("log4j.properties");
		//PART4
		if(br.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","/Users/naveenkumarthiyagarajan/Downloads/chromedriver2");
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
	
	
	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The element : " + text + " is clicked Successfully", "PASS");
			logger.info("The element : " + text + " is clicked Successfully");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + text + " is not clicked", "FAIL");
			logger.info("The element : " + text + " is not clicked Successfully");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
			logger.info("WebDriverException" + e.getMessage());
		}

	}

	public void setValue(WebElement ele, String data) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			ele.sendKeys(data);
			sleep(2000);
			text = ele.getText();
			reportStep("The word : " + data + " is entered Successfully", "PASS");
			logger.info("The word : " + data + " is entered Successfully");
		} catch (InvalidElementStateException e) {
			reportStep("The word: " + data + " is not entered successfully", "FAIL");
			logger.info("The word : " + data + " is not entered Successfully");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
			logger.info("WebDriverException" + e.getMessage());
		}

	}

	public void clickVisible(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(ele));
			text = ele.getText();
			ele.click();
			reportStep("The element : " + text + " is clicked Successfully", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + text + " is not clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
		}

	}

	public void clickusingjava(WebElement ele) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", ele);
	}

	public boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				reportStep("The element " + ele + " is displayed", "PASS");
			} else {
				reportStep("The element " + ele + " is not displayed", "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
		return true;
	}

	public void verifyEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				reportStep("The element " + ele + " is selected", "PASS");
			} else {
				reportStep("The element " + ele + " is not selected", "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
	}

	public boolean verifyChecked(WebElement ele) {
		try {
			if (ele.isSelected()) {

				reportStep("The element " + ele + " is selected", "PASS");
				System.out.println("Live Radar is checked");
			} else {
				reportStep("The element " + ele + " is not selected", "FAIL");
				System.out.println("Live Radar is not checked");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
		return true;
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed", "PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser: \n Error: " + e.getMessage(), "FAIL", false);
		}
	}

	public void sleep(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*@Override
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
	}*/
	
	@Override
	public long takeScreenShot() {
		System.out.println("Screenshot called.....s");
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
