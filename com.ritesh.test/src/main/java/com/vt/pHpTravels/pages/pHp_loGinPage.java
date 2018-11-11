package com.vt.pHpTravels.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vt.qa.base.TestBase;

public class pHp_loGinPage extends TestBase{

	//Page Factory Model
	@FindBy(xpath="//a[@href=\"//www.phptravels.net\"]")
	@CacheLookup
	WebElement HomePageClick;

	public pHp_loGinPage() 
	{
		PageFactory.initElements(driver,this);
	}

	public HomePage DemoPage() {

		System.out.println("Inside demo page");
		String parentWindowHandler = driver.getWindowHandle();
		
		HomePageClick.click();

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			String subWindowHandler = iterator.next();

			if(!parentWindowHandler.contains(subWindowHandler)){

				driver.switchTo().window(subWindowHandler);


			}
		}

		return new HomePage();

	}


}
