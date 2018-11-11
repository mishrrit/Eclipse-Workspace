package TestNg_Asserts;

import org.testng.annotations.DataProvider;


public class DataInputs {
 
	@DataProvider(name = "inputs")
	  public Object[][] DataProvider() {
		  return new Object[][]{
			  {"Ritesh","Rati"},{"Jism","Jaan"}
		  };
		  
	  }
}
