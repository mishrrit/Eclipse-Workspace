package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Annotations_test1 {
  @Test
  public void testmethod1() {
	  System.out.println(" this is the sample test method 1");
  }
  
  @Test
  public void testmethod2() {
	  System.out.println(" this is the sample test method 2");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(" this runs before every method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(" this runs after every method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(" this runs once before a class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(" this runs once after a class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(" this runs before every test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(" this runns after every test");
  }

}
