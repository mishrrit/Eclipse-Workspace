package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestNg_ISuiteListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println(" Before Suite Run ");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println(" After Suite Run");
		
	}

}
