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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNg_Reporting1 {
	WebDriver driver;
	WebElement element;
	String BaseUrl;
	ExtentReports report;
	ExtentTest test;
	String name = this.getClass().getName();
	String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	String LogFile = name + logFileName + ".html";

	@BeforeTest
	public void setup() throws InterruptedException {
		report = new ExtentReports("C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\ExtentReport\\" + LogFile);
		test = report.startTest(" Welcome Text Verfication");
		BaseUrl = "https://www.letskodeit.com";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
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
		WebElement signup = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signup.click();

		test.log(LogStatus.INFO, "Clicked on the Signup Link");

		WebElement loginlink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginlink.click();
		test.log(LogStatus.INFO, "Clicked on the Login Link");

		WebElement username = driver.findElement(By.xpath(".//*[@id='memberLoginDialogemailInputinput']"));
		username.sendKeys("test1email.com");
		test.log(LogStatus.INFO, "Username Entered");

		WebElement password = driver.findElement(By.xpath(".//*[@id='memberLoginDialogpasswordInputinput']"));
		password.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Password Entered");
		Thread.sleep(3000);
		driver.findElement(By.id("memberLoginDialogokButton")).click();
		test.log(LogStatus.INFO, "Logged in Entered");
		Thread.sleep(3000);

		WebElement user = null;
		try {
			user = driver.findElement(By.xpath(".//*[text()='Log out']"));
			System.out.println(user);
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
