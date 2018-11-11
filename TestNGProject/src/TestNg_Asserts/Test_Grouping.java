package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Test_Grouping {
  
	
  @BeforeClass(alwaysRun =true)
  public void beforeClass() {
	  System.out.println("  Before Class Running ");
  }
  
  @Test(groups = {"wild","king"})
  public void testTiger() {
	  System.out.println("Running test - Tiger ");
  }

  @Test(groups = {"wild","animals"})
  public void testJaguar() {
	  System.out.println("Running test - Jaguar ");
  }
  
  @Test(groups = {"wild","animals"})
  public void testPanther() {
	  System.out.println("Running test - Panther ");
  }
  
  @Test(groups = {"pet","animals"})
  public void testCow() {
	  System.out.println("Running test - Cow ");
  }
  
  @Test(groups = {"pet","animals"})
  public void testGoat() {
	  System.out.println("Running test - Goat ");
  }
  
  
  @AfterClass(alwaysRun =true)
  public void afterClass() {
	  System.out.println("  After Class Running ");
  }

}
