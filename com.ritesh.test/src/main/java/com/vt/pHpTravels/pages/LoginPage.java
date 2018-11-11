package com.vt.pHpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vt.qa.base.TestBase;

public class LoginPage extends TestBase{
	WebDriverWait wait;
	
	Actions action= new Actions(driver);
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div[5]/div/div[1]/input")
	WebElement userName;


	@FindBy(xpath="//input[@name=\"password\"]")
	public WebElement passWord;

	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[1]/div[5]/button")
	public WebElement loginButton;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);
	}

	public UserAccountPage loginToPhpTravels(String UserName,String PassWord) throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		System.out.println("************Enter the UserName***************************");
		
		action.moveToElement(userName).build().perform();
		userName.sendKeys(UserName);
		
		
		System.out.println("************Enter the Password***************************");
		
		action.moveToElement(passWord).build().perform();
		passWord.sendKeys(PassWord);
		System.out.println(" PassWord entered");
		
		System.out.println("************Click on the Login Button***********************");
		action.moveToElement(loginButton).build().perform();
		loginButton.click();
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 10);
		//wait.wait(5000);
		System.out.println(driver.getTitle());
		
		return new UserAccountPage();

	}

}
