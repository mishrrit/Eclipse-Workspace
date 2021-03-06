package vtPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vendorly.Main.baseClass;

public class FP_ProductSelection extends baseClass{
	
	
	public FP_ProductSelection() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath=".//button[@class='dropdown-toggle btn btn-primary']/span")
	//@FindBy(xpath="//*[@id='actionMenu']/span[2]/button/span")
	public WebElement CreateOfferButton;
	
	@FindBy(xpath=("//span[button[contains(.,'Offer Controls')]]//li[contains(.,'Create Offer')]"))
	//(id="createOffer")  
	public WebElement CreateOffer;
	
	@FindBy(xpath="//*[@id=\"productSelectionProgress\"]/ng-include/div[1]/div[2]/select")
	public WebElement SelectClient;
	
	@FindBy(xpath="//*[@id=\"productSelectionProgress\"]/ng-include/div[2]/div[2]/select")
	public WebElement SelectCategory;

	
	@FindBy(xpath="//*[@id=\"productSelectionProgress\"]/ng-include/div[3]/div[2]/select")
	public WebElement SelectProduct;
	
	@FindBy(xpath="/html/body/div[7]/div/div/div[3]/button[2]")
	public WebElement CreateButton;
	
	
	@FindBy(xpath="//*[@id=\"currentApplication\"]/span/a")
	public WebElement HomeLink;

}
