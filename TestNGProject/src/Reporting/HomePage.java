package Reporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	WebDriver driver;
	ExtentTest test;

	public HomePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	public void signup() {
		WebElement signup = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signup.click();
		test.log(LogStatus.INFO, "Clicked on the Signup Link");

	}
	
	public void LoginLink() {
		WebElement loginlink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginlink.click();
		test.log(LogStatus.INFO, "Clicked on the Login Link");
	}
	
	public void EnterUsername(String userid) {
		WebElement username = driver.findElement(By.xpath(".//*[@id='memberLoginDialogemailInputinput']"));
		username.sendKeys(userid);
		test.log(LogStatus.INFO, "Username Entered");
	}
	
	public void EnterPassword(String password) throws InterruptedException {
		WebElement pwd = driver.findElement(By.xpath(".//*[@id='memberLoginDialogpasswordInputinput']"));
		pwd.sendKeys(password);
		test.log(LogStatus.INFO, "Password Entered");
		Thread.sleep(3000);
	}
	
	public void LoginClicked() throws InterruptedException {
		driver.findElement(By.id("memberLoginDialogokButton")).click();
		test.log(LogStatus.INFO, "Logged in Entered");
		Thread.sleep(3000);
	}
	
	public WebElement Logout() {
		WebElement user = driver.findElement(By.xpath(".//*[text()='Log out']"));
		
		
		return user;
		
	}
	
	public void TestLogin(String userid,String password) throws InterruptedException {
		signup();
		LoginLink();
		EnterUsername(userid);
		EnterPassword(password);
		LoginClicked();
		Logout();
		
	}

}
