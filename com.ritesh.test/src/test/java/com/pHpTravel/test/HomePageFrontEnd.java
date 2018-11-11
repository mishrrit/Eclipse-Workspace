package com.pHpTravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vt.pHpTravels.pages.HomePage;
import com.vt.pHpTravels.pages.pHp_loGinPage;
import com.vt.qa.base.TestBase;

public class HomePageFrontEnd extends TestBase {
	pHp_loGinPage demo;
	HomePage home;
	

	public HomePageFrontEnd() {
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		demo = new pHp_loGinPage();
		home = demo.DemoPage();

	}

	@Test(priority =1)
	public void PageTitle() {
		String PageTitle =home.LoginPageTittle();

		Assert.assertEquals(PageTitle, "PHPTRAVELS | Travel Technology Partner","Incorrect Page Title" );


	}


	@Test(priority =2)
	public void verifyPhpTravelsLogo() {
		Assert.assertTrue(home.verifyPhpLogo(),"PHPTravels Logo is not displayed");

	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
