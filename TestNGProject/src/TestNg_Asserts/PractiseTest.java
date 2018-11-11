package TestNg_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class PractiseTest {

	WebDriver driver;
	String BaseUrl;

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String browser) throws InterruptedException {
		BaseUrl = "https://letskodeit.teachable.com";

		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Backup\\Selenium\\IEDriverServer_3.9.0\\IEDriverServer.exe");
				
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		System.out.println(" testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get(BaseUrl);
	}

	@Test
	@Parameters({ "username", "password" })
	public void Login(String username, String password) {

		WebElement link = driver.findElement(By.xpath(".//*[@id='navbar']/div/div/div/ul/li[2]/a"));
		link.click();
		WebElement login = driver.findElement(By.id("user_email"));
		login.sendKeys(username);
		WebElement pwd = driver.findElement(By.id("user_password"));
		pwd.sendKeys(password);
		WebElement loginlink = driver.findElement(By.xpath(".//*[@id='new_user']/div[3]/input"));
		loginlink.click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
