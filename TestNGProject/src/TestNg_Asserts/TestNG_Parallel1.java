package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Parallel1 {
 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("TestNg_Parallel1 Before Class");
  }
  
  @Test
  public void testMethod1() throws InterruptedException {
	  System.out.println("TestNGParalell1 - Method 1");
	  Thread.sleep(6000);
	  System.out.println("TestNGParalell1 - Method 1 of 1 is Still running");
  }
  
  @Test
  public void testMethod2() throws InterruptedException {
	  System.out.println("TestNGParalell1 - Method 2");
	  Thread.sleep(6000);
	  System.out.println("TestNGParalell1 - Method 2 of 1 is Still running");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("TestNg_Parallel1 After Class");
  }

}
