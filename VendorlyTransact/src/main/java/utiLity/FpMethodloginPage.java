package utiLity;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import vendorly.Main.baseClass;
import vtPages.Pages_loginPage;

public class FpMethodloginPage extends baseClass {
	WebDriverWait wait;
	Pages_loginPage Page;

	public FpMethodloginPage() {
		PageFactory.initElements(driver, this);
		//init();
		Page = new Pages_loginPage();
	}

	public void loginPageCheck() throws InterruptedException {
		System.out.println("login");
		driver.get(baseClass.IQA_FPUrl());
		wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(Page.userName));

		Page.userName.sendKeys(baseClass.IQA_FPUsername());
		Page.passWord.sendKeys(baseClass.IQA_FPpassWord());

		wait.until(ExpectedConditions.elementToBeClickable(Page.logIn));
		Page.logIn.click();
		Thread.sleep(10000);

		//Assert.assertEquals(driver.getTitle(), "REALTrans Marketplace");
		
	}

}
