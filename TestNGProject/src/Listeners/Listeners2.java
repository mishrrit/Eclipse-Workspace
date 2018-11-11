package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class Listeners2 implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result) {
		// runs before the test 
		System.out.println("******Runs before the test******" +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// runs after the test success
		System.out.println(" runs after the test is success "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// runs after the test is failed
		System.out.println(" runs after the test is failed"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// ignore
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(" before the test tag in xml "+context.getName());
		ITestNGMethod method[] = context.getAllTestMethods();
		System.out.println(" this  method will be executed for the test tag");
		for(ITestNGMethod methods:method) {
			System.out.println("Methods available in the classes are :"+methods.getMethodName());
		}
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish -> :"+context.getName());
		
	}

	

}
