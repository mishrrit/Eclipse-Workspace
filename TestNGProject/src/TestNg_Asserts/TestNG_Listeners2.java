package TestNg_Asserts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.Listeners2;



@Listeners(Listeners2.class)
public class TestNG_Listeners2 {
  
  @Test
  public void testmethod1() {
	  System.out.println(" Codes are in TestMethod1\n");
	  Assert.assertTrue(true);
  }
  
  
  @Test
  public void testmethod2() {
	  System.out.println(" Codes are in TestMethod2\n");
	  Assert.assertTrue(true);
  }
  
  @BeforeClass
  public void setup() {
	  System.out.println(" Running the Setup\n");
	  
  }

  @AfterClass
  public void clean() {
	  System.out.println(" Running the Cleanup\n");
  }

}
