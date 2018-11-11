package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import Listeners.TestNG_Listeners1;

@Listeners(TestNG_Listeners1.class)
public class TestNG_Listeners {
  
  @Test
  public void testmethod1() {
	  System.out.println(" Codes are in testmethod1");
	  Assert.assertTrue(true);
  }
  
  
  @Test
  public void testmethod2() {
	  System.out.println(" Codes are in testmethod2");
	  Assert.assertTrue(true);
  }
  
  @BeforeClass
  public void setup() {
	  System.out.println(" running the setup");
	  
  }

  @AfterClass
  public void clean() {
	  System.out.println(" running the clean up");
  }

}
