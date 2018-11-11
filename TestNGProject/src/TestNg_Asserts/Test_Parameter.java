package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test_Parameter {
  
	@BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class is running");
	  }
	  
	  @Test
	  @Parameters ( {"browser","vehicle"})
	  public void testMethod1(String browser, String vehicle) throws InterruptedException {
		  System.out.println("Running Test Method 1");
		  Thread.sleep(6000);
		  System.out.println("The browser being is use is "+browser);
		  System.out.println("The vehicle being is use is "+vehicle);
	  }
	  
	  @Test
	  @Parameters ({"animals","age"})
	  public void testMethod2(String animals, int age) throws InterruptedException {
		  System.out.println("Running Test method 2");
		  Thread.sleep(6000);
		  System.out.println("The browser being is use is "+animals);
		  System.out.println("The age of the animals is "+age);
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("After Class is running");
	  }
}
