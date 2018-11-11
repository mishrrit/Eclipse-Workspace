package TestNg_Asserts;

import org.testng.annotations.Test;
import Listeners.TestNg_ISuiteListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;

@Listeners(TestNg_ISuiteListener.class)
public class TestNG_Listener3 {
 
	@Test
  public void testMethod1() {
		System.out.println(" Running test method--> TestMethod 1");
  }
	
	@Test
	  public void testMethod2() {
			System.out.println(" Running test method -->TestMethod2");
	  }	

  @BeforeClass
  public void setup() {
	  System.out.println(" Setup has started running ");
  }

  @AfterClass
  public void Cleanup() {
	  System.out.println(" Cleanup has cleaned the project");
  }

}
