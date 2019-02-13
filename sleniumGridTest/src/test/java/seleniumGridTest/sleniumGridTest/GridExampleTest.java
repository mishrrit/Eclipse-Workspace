package seleniumGridTest.sleniumGridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExampleTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities des = new DesiredCapabilities();
		des.setBrowserName("chrome");
		des.setPlatform(Platform.WIN10);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(des);
		
		String Url = "http://www.google.com";
		RemoteWebDriver driver = new RemoteWebDriver(new URL(Url),options);
		
		
		System.out.println(driver.getTitle());
		
		
		

	}

}
