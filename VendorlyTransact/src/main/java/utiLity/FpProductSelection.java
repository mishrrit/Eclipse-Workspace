package utiLity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vendorly.Main.baseClass;
import vtPages.FP_ProductSelection;

public class FpProductSelection extends baseClass {
	FP_ProductSelection prod;
	FluentWait<WebDriver> wait;

	public FpProductSelection() {
		PageFactory.initElements(driver, this);
		prod = new FP_ProductSelection();
	}

	@SuppressWarnings("deprecation")
	public void CreateOffer() throws InterruptedException {

		wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(prod.CreateOfferButton));
		wait.pollingEvery(5, TimeUnit.SECONDS);

		Actions tkaction = new Actions(driver);
		tkaction.moveToElement(prod.CreateOfferButton).build().perform();
		tkaction.click();
		System.out.println("clicked on offer button");
		wait = new WebDriverWait(driver, 30);

		tkaction.moveToElement(prod.CreateOffer).click().perform();

		wait = new WebDriverWait(driver, 10).withTimeout(30, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	public void ClientSelection(String Client) throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(prod.SelectClient));
		Select client = new Select(prod.SelectClient);
		client.selectByVisibleText(Client);
		wait = new WebDriverWait(driver, 10).withTimeout(100, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	public void CategorySelection(String Category) throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		// wait = new WebDriverWait(driver,30).withTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(prod.SelectCategory));
		Thread.sleep(10000);
		Select category = new Select(prod.SelectCategory);
		category.selectByVisibleText(Category);
		// Thread.sleep(10000);
		wait = new WebDriverWait(driver, 10).withTimeout(100, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	public void ProductSelection(String Product) throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		// wait = new WebDriverWait(driver,30).withTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(prod.SelectProduct));
		Thread.sleep(10000);
		Select product = new Select(prod.SelectProduct);
		product.selectByVisibleText(Product);
		// Thread.sleep(10000);
		wait = new WebDriverWait(driver, 10).withTimeout(100, TimeUnit.SECONDS);
	}

	public void ClickonCreateOfferButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(prod.CreateButton));
		if(prod.CreateButton.isEnabled()) {
		prod.CreateButton.click();
		Thread.sleep(20000);
		System.out.println(" Dynamic form page");
		wait.until(ExpectedConditions.visibilityOf(prod.HomeLink));
		}else {
			System.out.println(" not clicked");
		}
		wait = new WebDriverWait(driver, 120);
	}

}
