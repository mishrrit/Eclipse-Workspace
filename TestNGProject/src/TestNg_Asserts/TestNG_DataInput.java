package TestNg_Asserts;

import org.testng.annotations.Test;

public class TestNG_DataInput {
  @Test(dataProvider = "inputs",dataProviderClass =DataInputs.class)
  public void testmethod(String data1,String data2) {
	  System.out.println(" data pass from the 1st pair  is "+data1);
	  System.out.println(" data pass from the 2nd pair is "+data2);
  }
}
