package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNgSamples.Support;

public class SoftAssert_test {

	SoftAssert sa = new SoftAssert();
	Support sup = new Support();

	@Test
	public void add() {
		int result = sup.Sum(2, 4);
		sa.assertEquals(result, 5);
		System.out.println(" test method 1--- running ");
		sa.assertAll();
	}

	@Test
	public void difference() {
		int result = sup.Diff(12, 5);
		sa.assertEquals(result, 7);
		System.out.println(" test method 2--- running ");
		

	}
}
