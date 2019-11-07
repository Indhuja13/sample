    
package com.seleniumtraining.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	WebDriver driver;
	
	public LoginPage1(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[.='Indhuja Sakthivel']")
	WebElement mail;
	
	public void clickMail()
	{
		mail.click();
	}
		
	@FindBy(name="identifier")
	WebElement txtUserName;
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="(.//span[.='Next'])")
	WebElement btnLogin;
	@FindBy(xpath="//span[.='Next']")
	WebElement btnLogin1;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;

	public void clickNext() {
		btnLogin.click();
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
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