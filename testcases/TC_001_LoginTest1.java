package com.seleniumtraining.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumtraining.pageobjects.LoginPage1;


public class TC_001_LoginTest1 extends BaseClass1
{

@Test
	public void loginTest() throws IOException, InterruptedException 
  {
		driver.get(baseURL);
		logger.info("URL is entered");
		
		LoginPage1 lp=new LoginPage1(driver);
		lp.setUserName(username);
		logger.info("Entered UserName"); //print in log sheet
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
		
		if(title.equals("Inbox - indhuja.s@tringapps.com - tringapps, Inc. Mail"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			
			Assert.assertTrue(false);
			
		}
		
	}
}