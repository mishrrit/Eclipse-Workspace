package Listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestNG_Listeners1 implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	System.out.println(" Before Invocations :"+testResult.getTestClass().getName()+
			 " => " +method.getTestMethod().getMethodName());	
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println(" After Invocations :"+testResult.getTestClass().getName()+
				 " => " +method.getTestMethod().getMethodName());	
		
	}

}
