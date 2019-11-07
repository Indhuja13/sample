package com.seleniumtraining.testcases;



	import java.io.IOException;

	import org.apache.log4j.Logger;
	import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	import com.seleniumtraining.pageobjects.LoginPage5;
import com.seleniumtraining.utilities.XLUtils;


	public class TC_001_LoginTest5 extends BaseClass5
	
	{
        @Test(dataProvider="LoginData")
		public void loginTest(String username,String password,String password1) throws IOException, InterruptedException 
		{
				
			/*driver.get(baseURL);
			logger.info("URL is entered");*/
			
			LoginPage5 lp=new LoginPage5(driver);
			
			// Get the cell data directly
			/*String path="/Users/naveenkumarthiyagarajan/Documents/Excel/document2.xlsx";
			String ur=XLUtils.getCellData(path, "Sheet1", 1, 0);
			lp.setUserName(ur);*/
			
			lp.setUserName(username);
			logger.info("Entered UserName");
			Thread.sleep(3000);
			
			lp.clickNext();
			Thread.sleep(3000);
			
			lp.setPassword(password);
			logger.info("Entered Password");
			Thread.sleep(3000);
			
			
			lp.clearPassword();
			logger.info("Cleared Password");
			Thread.sleep(3000);
			
			lp.setPassword(password1);
			logger.info("Entered Password");
			Thread.sleep(3000);
			
			
			lp.clickSubmit();
			logger.info("Landed on HomePage");
			Thread.sleep(3000);
			
			String title=driver.getTitle();
			System.out.println(title);
			Thread.sleep(3000);
			/*if(title.equals("Gmail"))
			{
				Assert.assertTrue(true);
				
			}
			else
			{
				
				Assert.assertTrue(false);
				
			}*/
			
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
		//	String path="/Users/naveenkumarthiyagarajan/Documents/Excel/document3.xlsx";//Multiple sets of data(Username and password)
			
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


