package TestNg_Asserts;

import org.testng.annotations.Test;

import TestNgSamples.Support;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_EnableTimeOut {
	Support sup = new Support();

	@BeforeClass
	public void beforeClass() {
		System.out.println(" Before Class");
	}

	@Test(enabled = true)
	public void testEnable() {
		System.out.println(" Running Test Enable");
		int result = sup.Diff(5, 4);
		Assert.assertEquals(result, 1);
	}

	@Test(timeOut = 2000)
	public void testTimeOut() throws InterruptedException {
		System.out.println(" Running Test Time Out");

		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		System.out.println(" After Class");
	}

}
