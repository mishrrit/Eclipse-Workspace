package TestNg_Asserts;
import TestNgSamples.Support;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Test {

	@Test
	public void TestMethod1() {
		Support obj = new Support();

		int result = obj.Sum(1, 2);
		System.out.println(" Test Method ----> Run 1 ");
		Assert.assertEquals(result, 3);

	}
	
	@Test
	public void TestMethod2() {
		Support sup = new Support();

		int result = sup.Diff(2, 1);
		System.out.println(" Test Method ----> Run 2 ");
		Assert.assertEquals(result, 1);

	}
	
	@Test
	public void TestMethod3() {
		Support sup = new Support();

		String result = sup.name("Ritesh", "Mishra");
		System.out.println(" Test Method ----> Run 3 ");
		Assert.assertEquals(result, "RiteshMishra");
		

	}
	
	
	@Test
	public void TestMethod4() {
		Support sup = new Support();

		boolean result = sup.logic("Ritesh", "Mishra");
		System.out.println(" Test Method ----> Run 4 ");
		Assert.assertEquals(result, false);
		

	}
}
