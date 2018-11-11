package TestNg_Asserts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestNgSamples.Support;

public class Test_Dependency {

	Support sup = new Support();

	@BeforeClass
	public void beforeClass() {
		System.out.println(" Before Class");
	}

	@Test(dependsOnMethods = { "testMethod2" }, alwaysRun = true)
	public void testMethod1() {
		System.out.println(" Running Sample - 1");

	}

	@Test
	public void testMethod2() {
		System.out.println(" Running Sample - 2");
		int result = sup.Sum(1, 2);
		Assert.assertEquals(result, 2);

	}

	@Test(dependsOnMethods = "testMethod1")
	public void testMethod3() {
		System.out.println(" Running Sample - 3");

	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
