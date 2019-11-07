package com.seleniumtraining.pageobjects;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class LoginPage5 {

		WebDriver driver;
		
		public LoginPage5(WebDriver driver)
		{
			this.driver=driver;
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
		}
		public void clickSignout() {
			signout.click();
		}
		public void clickAnotherAccount() {
			otheraccount.click();
		}
		public void clickMail() {
			mail.click();
		}
		public void clickNext() {
			btnLogin.click();
		}
		
		public void setUserName(String uname)
		{
			txtUserName.sendKeys(uname);
		}
		
		public void setPassword(String pwd) 
		{
			txtPassword.sendKeys(pwd);
			
		}
		
		public void clearPassword()
		{
			txtPassword.clear();
		}

		public void clickSubmit()
		{
			btnLogin.click();
		}
		
		public void clickLogout()
		{
			lnkLogout.click();
		}
	}



