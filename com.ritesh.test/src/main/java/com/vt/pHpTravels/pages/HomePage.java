package com.vt.pHpTravels.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vt.qa.base.TestBase;
import com.vt.qa.utils.TestUtils;

public class HomePage extends TestBase{
	TestUtils utils;
	public String currentDate;
	public Actions action = new Actions(driver);
	public FluentWait<WebDriver> wait = new WebDriverWait(driver, 90);

	//Page Factory model for a single page
	@FindBy(xpath="/html/body/nav/div/div[1]/a/img")
	WebElement pHploGo;

	@FindBy(xpath = "//a[@href=\"#HOTELS\"]")
	WebElement HotelsTab;

	@FindBy(xpath=".//input[@name='travellers']")
	WebElement Travellers;

	@FindBy(xpath="/html/body/div[4]/section/div[2]/div/div[2]/div/div[1]/form/div[5]/button")
	WebElement SearchButton;

	@FindBy(xpath = "//a[@href=\"#flights\"]")
	WebElement FlightsTab;

	@FindBy(xpath = "//a[@href=\"#TOURS\"]")
	WebElement ToursTab;

	@FindBy(xpath = "//a[@href=\"#CARS\"]")
	WebElement CarsTab;

	@FindBy(xpath = "//a[@href=\"#VISA\"]")
	WebElement VisaTab;

	public HomePage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	public String LoginPageTittle() {
		System.out.println(driver.getTitle()+" is the title");
		return driver.getTitle();
		
	}


	public boolean verifyPhpLogo() {
		return pHploGo.isDisplayed();
	}


	public boolean HotelCheckinDate() {
		utils =new TestUtils();
		//get the current day which will be the checkin date
		currentDate =utils.getCurrentDay();
		WebElement checkinclick =driver.findElement(By.xpath(".//input[@name='checkin']"));
		checkinclick.click();

		List<WebElement> Dates = driver.findElements(By.tagName("td"));

		for(WebElement cell:Dates) {
		
			if((cell.getText().contains(currentDate))&&(cell.getAttribute("class").contains("day  active"))) {
				cell.click();
				break;
			}
			else {
				continue;
			}
		}
		if(checkinclick.toString().contains(currentDate)) {
			return true;
		}else {
			return false;
		}
	}

	public void HotelCheckOutDate() {
		
		
		List<WebElement> Dates = driver.findElements(By.tagName("td"));

		for(WebElement cell:Dates) {
			
			if(cell.getText().contains("active")){
				cell.click();
				break;
			}else {
				continue;
			}
		}
		
		

	}

	public boolean HotelSearch(String City) {

		WebElement hotelSearch = driver.findElement(By.xpath("//div[@id='s2id_autogen8']"));

		wait.until(ExpectedConditions.visibilityOf(hotelSearch));

		action.click(hotelSearch).sendKeys(City).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		List<WebElement> liTag = driver.findElements(By.className("select2-match"));
		int size = liTag.size();

		String beforeXpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[";
		String afterXpath = "]/div/span";
		
		 boolean matchCity = false;

		for(int i=1;i<size+1;++i) {
			
			WebElement CitySearch =driver.findElement(By.xpath(beforeXpath+i+afterXpath));
			System.out.println(CitySearch.getText()+" is the City, user is looking for");
			
			if(CitySearch.getText().equalsIgnoreCase(City)){
				action.moveToElement(CitySearch).perform();
				CitySearch.click();
				matchCity=true;
				break;

			}
		}
		return matchCity;

	}

	public void TravellersList(int Adult,int Children) {
		
		System.out.println(" Entering the travelleres details");
		driver.findElement(By.id("travellersInput")).click();
	
		//Enter the number of passengers
		
		//Enter the adults details 
		
		if(Adult==1) {
			 driver.findElement(By.xpath(".//button[@id='adultMinusBtn']//i[@class='fa fa-minus']")).click();
		}else if(Adult>2) {
			for(int i=0;i<Adult-2;i++) {
				driver.findElement(By.xpath(".//button[@id='adultPlusBtn']//i[@class='fa fa-plus']")).click();
			}
		}
		
		//Enter the child details
		if(Children>0) {
			for(int i=0;i<Children;i++) {
				driver.findElement(By.xpath(".//button[@id='childPlusBtn']//i[@class='fa fa-plus']")).click();
			}
		}	
			
	}
	
	public void clickOnSearchButton() {
		
			driver.findElement(By.xpath("//*[@id=\"HOTELS\"]/form/div[5]/button")).click();
			
	}



}
