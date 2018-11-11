package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class TestNG_DataProvider {
  
  @Test(dataProvider = "inputs")
  public void testMethod(String data1,String data2) {
	  System.out.println(" data pass from the 1st pair  is "+data1);
	  System.out.println(" data pass from the 2nd pair is "+data2);
	  
  }
  
  
  @DataProvider(name = "inputs")
  public Object[][] DataProvider() {
	  return new Object[][]{
		  {"Ritesh","Rati"},{"Jism","Jaan"}
	  };
	  
  }
		  
}
