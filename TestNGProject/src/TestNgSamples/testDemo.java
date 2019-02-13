package TestNgSamples;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilitities.ReadExcel;

public class testDemo {

	@BeforeSuite
	public static void beforeSuite() {
		System.out.println(" Before Suite");
	}

	/*@BeforeSuite
	public static void beforeSuite1() {
		System.out.println(" Before Suite1");
	}*/

	@BeforeTest
	public static void beforeTest() {
		System.out.println(" Before Test");
	}

	/*@BeforeTest
	public static void beforeTest1() {
		System.out.println(" Before Test1");
	}*/

	@BeforeClass
	public static void beforeClass() {
		System.out.println(" Before Class");
	}

	/*@BeforeClass
	public static void beforeClass1() {
		System.out.println(" Before Class1");
	}*/

	@BeforeMethod
	public static void beforeMethod() {
		System.out.println(" Before Method");
	}
	
	@DataProvider(name ="data")
	public static Object[][] DataProvider1() {
		 return new Object[][]{
			  {"Ritesh","Rati"},{"Jism","Jaan"}
		  };

	}
	
	
	@Test(description = "test class", groups = { "bikes" }, priority = 1, enabled = true)
	@Parameters({ "empname", "empwife" })
	public static void test1(String empname, String empwife) throws Exception {
		System.out.println(" Strin1 is " + empname);
		System.out.println(" String 2 is " + empwife);
		ReadExcel.ReadExcelData("C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\src\\TestNgSamples\\InputSheet.xlsx", "Orders");
	}

	@Test(groups = { "cars" }, priority = 2, enabled = true, dependsOnMethods = "test3",singleThreaded =false,dataProvider="data")
	@Parameters({"odbc"})
	public static void test2(String obj1,String obj2,@Optional("mysql") String odbc) {
		System.out.println(" Test2"+obj1);
		System.out.println(" Test2"+obj2);
		System.out.println(" test odbc "+odbc);
	}

	@Test(groups = {"bikes" }, priority = 3)
			//, invocationCount = 1, invocationTimeOut = 2000, timeOut = 2000, successPercentage = 10)
	public static void test3() {
		System.out.println(" Test3");
		Assert.assertTrue(false);
	}

	@AfterSuite
	public static void AfterSuite() {
		System.out.println(" After Suite");
	}

	@AfterTest
	public static void AfterTest() {
		System.out.println(" After test");
	}

	@AfterClass
	public static void AfterClass() {
		System.out.println(" After Class");
	}

	@AfterMethod
	public static void AfterMethod() {
		System.out.println(" After Method");
	}

	/*@AfterSuite
	public static void AfterSuite1() {
		System.out.println(" After Suite1");
	}

	@AfterTest
	public static void AfterTest1() {
		System.out.println(" After test1");
	}

	@AfterClass
	public static void AfterClass1() {
		System.out.println(" After Class");
	}

	@AfterMethod
	public static void AfterMethod1() {
		System.out.println(" After Method1");
	}*/
}


