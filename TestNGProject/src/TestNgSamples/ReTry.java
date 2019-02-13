package TestNgSamples;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			System.out.println(" Retrying test *****"+result.getTestClass().getName());
			retryCount++;
			return true;
		}
		return false;
	}
}
