package vendorly.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utiLity.FpMethodloginPage;
import utiLity.FpProductSelection;
import vendorly.Main.baseClass;

public class vTloginPage extends baseClass {
	FpMethodloginPage method;
	FpProductSelection prod;

	// utiLity.ExcelReadUtility excel;
	public vTloginPage() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		init();
		method = new FpMethodloginPage();
		prod = new FpProductSelection();
	}

	@DataProvider(name ="Product")
	public Object[][] getData() {
		//Object[][] data = utiLity.ExcelReadUtility.ReadFromExcel();
		return new Object[][] {{"Asset Management","Redemption","Redemption Orders"}};

	}

	//@Test(priority = 1)
	public void LoginPage() throws InterruptedException {

		method.loginPageCheck();
		Assert.assertEquals(driver.getTitle(), "REALTrans Marketplace");
	}

	@Test(priority = 2, dataProvider = "Product")
	public void CreateOfferWindow(String Client, String Category, String Product) throws InterruptedException {
		
		method.loginPageCheck();
		Assert.assertEquals(driver.getTitle(), "REALTrans Marketplace");
		prod.CreateOffer();
		prod.ClientSelection(Client);
		prod.CategorySelection(Category);
		prod.ProductSelection(Product);
		prod.ClickonCreateOfferButton();
	}

	@AfterMethod
	public void TearDown() {
		//driver.quit();
	}

}
