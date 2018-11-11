package com.vt.pHpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vt.qa.base.TestBase;

public class MyAccountsPage extends TestBase {
	
	//MyAccountsPage myAccount;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav navbar-right\"]//ul[@class=\"nav navbar-nav navbar-side navbar-right sidebar go-left\"]//li[@id=\"li_myaccount\"]/ul/li/a[@href='https://www.phptravels.net/login']")
	WebElement loginLink;
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav navbar-right\"]//ul[@class=\"nav navbar-nav navbar-side navbar-right sidebar go-left\"]//li[@id=\"li_myaccount\"]/a")
	WebElement myAccount;
	
	@FindBy(xpath ="//*[@id='body-section']/div/div[1]/div/div[1]/h3")
	WebElement mylogin;
	
	public MyAccountsPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage navigatetoLoginPage() throws InterruptedException {
	System.out.println("inside navigateLoginpage");
	
	Actions action = new Actions(driver);
	
	
	System.out.println(myAccount.isDisplayed());
	action.moveToElement(myAccount).build().perform();
	myAccount.click();
	Thread.sleep(4000);
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(myAccount));
			

	action.moveToElement(loginLink).build().perform();
	loginLink.click();
	
	WebDriverWait wait1 = new WebDriverWait(driver,10);
	wait1.until(ExpectedConditions.visibilityOf(myAccount));
	return new LoginPage();
	}
	

}
