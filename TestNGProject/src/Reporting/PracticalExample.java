package Reporting;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilitities.Screenshot;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class PracticalExample {
	WebDriver driver;
	WebElement element;
	String BaseUrl;
	ExtentReports report;
	ExtentTest test;
	String name = this.getClass().getName();
	String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	String LogFile = name + logFileName + ".html";
	HomePage hp;

	@BeforeTest
	public void setup() throws InterruptedException {
		report = new ExtentReports("C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\ExtentReport\\" + LogFile);
		test = report.startTest(" Welcome Text Verfication");
		BaseUrl = "https://www.letskodeit.com";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		hp = new HomePage(driver, test);
		test.log(LogStatus.INFO, "Browser is opened ..");

		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser is maximized ..");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BaseUrl);
		test.log(LogStatus.INFO, "URL Entered ..");

		Thread.sleep(5000);

	}

	@Test
	public void testmethod() throws InterruptedException {

		hp.TestLogin("test@email.com", "abcabc");
		
		WebElement user = null;
		try {
			user = hp.Logout();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(user != null);
		test.log(LogStatus.PASS, " Login Successfull");

	}

	@AfterMethod
	public void teardown(ITestResult testResult) throws IOException {

		String name = this.getClass().getName();
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshot.takeScreenshot(driver, name);
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Login was not Successfull", imagePath);

		}

	}

	@AfterTest
	public void exit() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
