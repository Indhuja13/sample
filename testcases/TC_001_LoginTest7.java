package com.seleniumtraining.testcases;


	import java.io.IOException;

	import org.apache.log4j.Logger;
	import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	import com.seleniumtraining.pageobjects.LoginPage5;
import com.seleniumtraining.pageobjects.LoginPage7;
import com.seleniumtraining.utilities.XLUtils;


	public class TC_001_LoginTest7 extends BaseClass7
	{

		@BeforeTest()
		public void setValues() {

			testCaseName = "Gmail Login";
			testDescription = "Able to Login Gmail successfully";
			testNodes = "WEB-CHROME";
			category = "Regression";
			authors = "Naveen";	

		}
		@Test(dataProvider="LoginData")
		public void loginTest(String username,String password) throws IOException, InterruptedException 
		{
			driver.get(baseURL);
			//logger.info("URL is entered");	
			LoginPage7 lp=new LoginPage7(driver,test);
			
			lp.setUserName(username);
			//logger.info("Entered UserName");
			Thread.sleep(3000);
			
			lp.clickNext();
			Thread.sleep(3000);
			
			lp.setPassword(password);
			//logger.info("Entered Password");
			Thread.sleep(3000);
			
			
			lp.clickSubmit();
			//logger.info("Landed on HomePage");
			Thread.sleep(3000);
			
			String title=driver.getTitle();
			System.out.println(title);
			Thread.sleep(3000);	
			lp.clickSign();
			Thread.sleep(3000);
			System.out.println("Clicked Sign");
			
			lp.clickSignout();
			Thread.sleep(3000);
			System.out.println("Clicked Signout");
			Thread.sleep(2000);
			
			lp.clickAnotherAccount();
			Thread.sleep(3000);
			System.out.println("Clicked another account");
			
			Thread.sleep(3000);
					
	}	
		
		
		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path="/home/tringapps-admin/Downloads/data.xlsx";
		
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
		
		
	}

