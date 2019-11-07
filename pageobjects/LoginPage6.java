package com.seleniumtraining.pageobjects;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.seleniumtraining.testcases.BaseClass6;


	public class LoginPage6 extends BaseClass6{

		//WebDriver driver;
		
		public LoginPage6(WebDriver driver,ExtentTest test)
		{
			this.driver=driver;
			this.test = test;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[@class='gb_Ba gbii']")
		WebElement sign;
		
		@FindBy(xpath="//a[.='Sign out']")
		WebElement signout;
		
		@FindBy(xpath="(.//div[.='Use another account'])[3]")
		WebElement otheraccount;
		
		@FindBy(xpath="//div[.='Naveenkumar Thiyagarajan']")
		WebElement mail;
			
		@FindBy(name="identifier")
		WebElement txtUserName;
		
		@FindBy(name="password")
		WebElement txtPassword;
		
		@FindBy(xpath="(.//span[.='Next'])")
		WebElement btnLogin;
		@FindBy(xpath="//span[.='Next']")
		WebElement btnLogin1;
		
		
		@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		WebElement lnkLogout;

		public void clickSign() {
			sign.click();
			reportStep("The element : " + sign + "is clicked Successfully", "PASS");
		}
		public void clickSignout() {
			signout.click();
			reportStep("The element : " + signout + "is clicked Successfully", "PASS");
		}
		
		public void clickAnotherAccount() {
			otheraccount.click();
			reportStep("The element : " + otheraccount + "is clicked Successfully", "PASS");
		}
		
		public void clickMail() {
			mail.click();
			reportStep("The element : " + mail + "is clicked Successfully", "PASS");
		}
		
		public void clickNext() {
			btnLogin.click();
			reportStep("The element : "+ btnLogin + "is clicked Successfully", "PASS");
		}
		
		
		public void setUserName(String uname)
		{
			txtUserName.sendKeys(uname);
			reportStep("The element : " + uname + " is entered Successfully", "PASS");
		}
		
		public void setPassword(String pwd) 
		{
			txtPassword.sendKeys(pwd);
			reportStep("The element : " + pwd + " is entered Successfully", "PASS");
			
		}
		
		public void clearPassword()
		{
			txtPassword.clear();
			reportStep("The entered password is deleted Successfully", "PASS");
		}

		public void clickSubmit()
		{
			btnLogin.click();
			reportStep("The element : " + btnLogin + "is clicked Successfully", "PASS");
		}
		
		
		public void clickLogout()
		{
			lnkLogout.click();
			reportStep("The element : " + lnkLogout + "is clicked Successfully", "PASS");
		}
		}
	


