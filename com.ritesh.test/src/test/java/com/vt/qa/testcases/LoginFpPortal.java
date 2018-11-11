package com.vt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vt.qa.base.TestBase;
import com.vt.qa.pages.Fp_HomePage;
import com.vt.qa.pages.Fp_LoginPage;

public class LoginFpPortal extends TestBase {
	Fp_LoginPage fplogin;
	Fp_HomePage fpHomePage;

	public LoginFpPortal (){
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		fplogin = new Fp_LoginPage();
		fpHomePage = fplogin.Login(prop.getProperty("username"),prop.getProperty("password"));
	}


	
	@Test
	public void loginFp() {
		String title = fpHomePage.LoginPageTittle();
		System.out.println(title);
		//Assert.assertEquals(title, "Vendorly Transact","HomePage title not matched");

	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


	








}
