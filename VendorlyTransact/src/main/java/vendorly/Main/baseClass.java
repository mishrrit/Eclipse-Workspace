package vendorly.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utiLity.Utils;

public class baseClass {

	private static Properties prop;
	protected static WebDriver driver;
	// private static WebElement element;

	public baseClass() {
		prop = new Properties();
		try {

			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/resources/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void init() {

		String ChromePath = prop.getProperty("driverpathChrome");
		String FirefoxPath = prop.getProperty("driverpathFirefox");

		String Browser = prop.getProperty("browser");

		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ChromePath);
			driver = new ChromeDriver();
		} else if (Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + FirefoxPath);
			driver = new FirefoxDriver();
		} else {
			System.out.println(" No specific browser defined");
		}

		driver.manage().window().maximize();
		System.out.println("maximize");
		driver.manage().deleteAllCookies();	
		System.out.println("cookiees");
		/*driver.manage().timeouts().implicitlyWait(Utils.ImplicitWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utils.PageTimeOut, TimeUnit.SECONDS);*/
		
		/*String fpURL = prop.getProperty("URL_IQAFp");
		String vpURL = prop.getProperty("URL_IQAVp");*/
		
	}

	public static String IQA_FPUrl() {
		String URL = prop.getProperty("URL_IQAFp");
		return URL;
	}

	public static String IQA_VPUrl() {
		String URL = prop.getProperty("URL_IQAVp");
		return URL;
	}

	public static String IQA_FPUsername() {
		String userName = prop.getProperty("username");
		return userName;
	}

	public static String IQA_FPpassWord() {
		String passWord = prop.getProperty("password");
		return passWord;
	}

}
