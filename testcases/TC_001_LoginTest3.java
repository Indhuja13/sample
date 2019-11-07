package com.seleniumtraining.testcases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumtraining.pageobjects.LoginPage3;


public class TC_001_LoginTest3 extends BaseClass3
{

	@Test
	public void loginTest() throws IOException, InterruptedException 
	{
			
		
		driver.get(baseURL);
		logger.info("URL is entered");
		
		LoginPage3 lp=new LoginPage3(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		Thread.sleep(3000);
		
		lp.clickNext();
		Thread.sleep(3000);
		
		lp.setPassword(password);
		logger.info("Entered Password");
		Thread.sleep(3000);
		
		lp.clickSubmit();
		logger.info("Landed on HomePage");
		Thread.sleep(3000);
		
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Gmail"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
		   Assert.assertTrue(false);
			
		}
		
	}
}