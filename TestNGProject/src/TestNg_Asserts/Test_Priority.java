package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test_Priority {
  
  @Test(priority =2)
  public void testmethod1() {
	  System.out.println(" Running Test Method - 1");
	  
  }
  
  @Test(priority =1)
  public void testmethod2() {
	  System.out.println(" Running Test Method - 2");
	  
  }
  
  @Test(priority =0)
  public void testmethod3() {
	  System.out.println(" Running Test Method - 3");
	  
  }
  
  @BeforeTest
  public void setup() {
	  System.out.println(" Before Test");
  }

  @AfterTest
  public void clean() {
	  System.out.println(" After Test");
  }

}
