package com.pHpTravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vt.pHpTravels.pages.HomePage;
import com.vt.pHpTravels.pages.LoginPage;
import com.vt.pHpTravels.pages.MyAccountsPage;
import com.vt.pHpTravels.pages.pHp_loGinPage;
import com.vt.qa.base.TestBase;

//import Reporting.ExtentFactory;

public class UserLoginPage extends TestBase {

	pHp_loGinPage demo;
	HomePage home;
	MyAccountsPage myaccount;
	LoginPage userlog;
	

	public UserLoginPage() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		demo = new pHp_loGinPage();
		home = demo.DemoPage();

	}

	@Test(priority=1)
	public void veriyLoginPage() throws InterruptedException {


		myaccount = new MyAccountsPage();

		try {
			userlog =  myaccount.navigatetoLoginPage();
			Assert.assertEquals(driver.getTitle(),"Login","User is not on the Login Page");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		String UserName = getUsername();
		String PassWord = getPassword();
		userlog.loginToPhpTravels(UserName,PassWord);
		Assert.assertEquals(driver.getTitle(),"My Account","User is not logged in");		



	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}


}