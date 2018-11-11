package utiLity;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vendorly.Main.baseClass;
import vtPages.FP_ProductSelection;

public class FpProductSelection extends baseClass {
	FP_ProductSelection prod;
	WebDriverWait wait;
	public FpProductSelection() {
		PageFactory.initElements(driver, this);
		//init();
		prod = new FP_ProductSelection();
	}

	public void CreateOffer() throws InterruptedException {
		
		wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(prod.OfferButton));
		//if(prod.OfferButton.isDisplayed()) {
		prod.OfferButton.click();
		Select select = new Select(prod.OfferButton);
		select.selectByVisibleText("Create Offer");
		Thread.sleep(10000);
		/*}else {
			System.out.println(" Element is not visible on the screen");
		}*/

	}

	public void ClientSelection(String Client) throws InterruptedException {
		Select client = new Select(prod.SelectClient);
		client.selectByVisibleText(Client);
		Thread.sleep(10000);
	}

	public void CategorySelection(String Category) throws InterruptedException {
		Select category = new Select(prod.SelectClient);
		category.selectByVisibleText(Category);
		Thread.sleep(10000);
	}

	public void ProductSelection(String Product) throws InterruptedException {
		Select product = new Select(prod.SelectClient);
		product.selectByVisibleText(Product);
		Thread.sleep(10000);
	}
	
	public void ClickonCreateOfferButton() {
		prod.CreateButton.click();
	}

}