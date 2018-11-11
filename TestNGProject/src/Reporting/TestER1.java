package Reporting;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestER1 {
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest(" TestER1 --->Verification ");
	}

	@Test
	public void testMethod1() {
		test.log(LogStatus.INFO, "TestER1 is Initiated ");
		test.log(LogStatus.INFO, "TestER1 is running ");
		test.log(LogStatus.INFO, "TestER1 is Ends ");
	}

	@AfterClass
	public void afterClass() {
		
		report.endTest(test);
		report.flush();
	}

}
