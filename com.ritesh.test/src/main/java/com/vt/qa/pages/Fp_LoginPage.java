package com.vt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.qa.base.TestBase;

public class Fp_LoginPage extends TestBase{


	//PageFactory Model
	@FindBy(name="j_username")
	WebElement UserName;

	@FindBy(name="j_password")
	WebElement PassWord;

	@FindBy(className="btn btn-primary")
	WebElement SubmitButton;


	public Fp_LoginPage() 
	{
		PageFactory.initElements(driver,this);
	}

	public String LoginPageTittle() {
		return driver.getTitle();
	}

	public Fp_HomePage Login(String user,String pass)
	{
		UserName.sendKeys(user);
		System.out.println("inside");
		PassWord.sendKeys(pass);
		SubmitButton.click();
		return new Fp_HomePage();
	}

	


}
