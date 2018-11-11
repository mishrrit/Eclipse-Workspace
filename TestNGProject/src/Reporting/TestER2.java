package Reporting;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestER2 {
	ExtentReports report1;
	ExtentTest test1;

	@BeforeClass
	public void beforeClass() {
		report1 = ExtentFactory.getInstance();
		test1 = report1.startTest(" TestER2 --->Verification ");
	}

	@Test
	public void testmethod2() {
		test1.log(LogStatus.INFO, "TestER2 is Initiated ");
		test1.log(LogStatus.INFO, "TestER2 is running ");
		test1.log(LogStatus.INFO, "TestER2 is Ends ");
	}

	@AfterClass
	public void afterClass() {
		report1.endTest(test1);
		report1.flush();
	}

}
