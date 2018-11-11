package com.pHpTravel.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vt.pHpTravels.pages.HomePage;
import com.vt.pHpTravels.pages.pHp_loGinPage;
import com.vt.qa.base.TestBase;
import com.vt.qa.utils.ExcelReadUtility;



public class HomePageHotelsTab extends TestBase {
	pHp_loGinPage demo;
	HomePage home;
	
	ExcelReadUtility excel;


	public HomePageHotelsTab() {
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		demo = new pHp_loGinPage();
		home = demo.DemoPage();

	}

	@DataProvider
	public Object[][] getData() {
		Object [][] data = ExcelReadUtility.ReadFromExcel();
		return data;


	}
	@Test(priority=1,dataProvider="getData")
	public void verifyHotelSearch(String CitySearch) throws InterruptedException {

		WebDriverWait wait =new WebDriverWait(driver,10);

		boolean verifyCitySearch = home.HotelSearch(CitySearch);


		home.HotelCheckinDate();


		home.HotelCheckOutDate();

		home.TravellersList(3, 3);

		home.clickOnSearchButton();


	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}



}
