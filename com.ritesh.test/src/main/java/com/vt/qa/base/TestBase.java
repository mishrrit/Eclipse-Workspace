package com.vt.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.vt.qa.utils.EmailUtility;
import com.vt.qa.utils.TestUtils;
import com.vt.qa.utils.WebEvenetListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEvenetListener eventListener;
	static String FPUrl;
	static String VPUrl;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/vt/qa/config/config.properties");
			prop.load(ip);		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String ChromePath = prop.getProperty("driverpathChrome");
		String FirefoxPath = prop.getProperty("driverpathFirefox");
		/*String QAUrlFP= prop.getProperty("URL_QAFp");
		String QAUrlVP= prop.getProperty("URL_QAVp");
		String IQAUrlFP= prop.getProperty("URL_IQAFp");
		String IQAUrlVP= prop.getProperty("URL_IQAVp");
		String UATUrlFP= prop.getProperty("URL_UATFp");
		String UATUrlVP= prop.getProperty("URL_UATVp");*/
		
		//report = com.vt.qa.utils.ExtentFactory.getInstance();
		
		
		String Browser = prop.getProperty("browser");
		
		if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +ChromePath);
			driver = new ChromeDriver();
		}else if(Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +FirefoxPath);
			driver = new FirefoxDriver();
		}else {
			System.out.println(" No specific browser defined");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEvenetListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Page_Implicit_Wait, TimeUnit.SECONDS);
		
		//String env = prop.getProperty("Environment");
		
		
	    /*if(env.equals("QA")) {
	    	FPUrl = QAUrlFP;
	    	VPUrl = QAUrlVP;
	  	    	
	    }else if(env.equals("IQA")){
	    	FPUrl = IQAUrlFP;
	    	VPUrl = IQAUrlVP;
	    	
	    }else if(env.equals("UAT")) {
	    	FPUrl = UATUrlFP;
	    	VPUrl = UATUrlVP;
	    }else {
	    	System.out.println("No Proper Urls found");
	    }*/
	    
	    driver.get(prop.getProperty("URL"));
	}
	
	public String getUsername() {
		String userName = prop.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String passWord = prop.getProperty("password");
		return passWord;
	}
	
	public String getEmailFrom() {
		String EmailFrom = prop.getProperty("EmailFrom");
		return EmailFrom;
	}
	
	public String getEmailTo() {
		String EmailTo = prop.getProperty("EmailTo");
		return EmailTo;
		}
	
	public String getEmailHostName() {
		String EmailHost = prop.getProperty("EmailHostName");
		return EmailHost;
	}
	
	public String getEmailSMTPPort() {
		String SmtpPort = prop.getProperty("SmtpPort");
		return SmtpPort;
	}
	
	public boolean getSSLHost() {
		String SSLHost = prop.getProperty("SSLConnect");
		if(SSLHost.equals("True")) {
			return true;
		}else 
		return false;
	}
	
	@AfterSuite
	public void SendEmail() throws EmailException, InterruptedException, IOException {
		System.out.println("sending email ");
		EmailUtility email = new EmailUtility();
		//email.SimpleTextEmail();
		Thread.sleep(15000);
		
		
	//	email.SendEmailWithAttachment();
		email.SendHTMLFormattedEmail();
		
		System.out.println("email sent");
		
		
		
		
	}
	
	
	
}
