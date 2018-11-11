package com.vt.pHpTravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.qa.base.TestBase;

public class UserAccountPage extends TestBase{
	
	public UserAccountPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//*[@id=\"body-section\"]/div/div[1]/div/div[1]/h3")
	WebElement userAccount;
	
	public String userLoggedIn() {
		return driver.getTitle();
	}
	
}
