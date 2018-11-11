package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNG_ItestDemo {
	@Test
	public void testmethod1() {
		System.out.println("Method 1 is running ");
		Assert.assertTrue(false);
		System.out.println("  Method returned false");

	}

	@Test
	public void testmethod2() {
		System.out.println("Method 2 is running ");
		Assert.assertTrue(true);
		System.out.println("  Method returned true");
	}

	@SuppressWarnings("static-access")
	@AfterMethod
	public void beforeClass(ITestResult test) {
		if (test.getStatus() == test.SUCCESS) {
			System.out.println("Test Success :" + test.getMethod().getMethodName());

		} else if (test.getStatus() == test.FAILURE) {
			System.out.println("test Failure :" + test.getMethod().getMethodName());
		}
	}

}
