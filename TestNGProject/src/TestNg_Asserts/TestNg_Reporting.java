package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNg_Reporting {
  
	@Test
  public void testmethod() {
	  Reporter.log(" Running test method-----> Method 1",true);
	  Assert.assertTrue(true);
  }
  
  @Test
  public void testmethod2() {
	  Reporter.log(" Running test method-----> Method 2");
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods="testmethod2")
  public void testmethod3() {
	  Reporter.log(" Running test method-----> Method 3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log(" Running Before Method ");
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log(" Running After Method ");
  }

  @BeforeClass
  public void beforeClass() {
	  Reporter.log(" Running Before Class ");
  }

  @AfterClass
  public void afterClass() {
	  Reporter.log(" Running After Class Method ");
  }

}
