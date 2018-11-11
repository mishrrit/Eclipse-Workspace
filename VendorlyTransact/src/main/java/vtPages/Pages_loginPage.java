package vtPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vendorly.Main.baseClass;

public class Pages_loginPage extends baseClass {
	
	
	@FindBy(xpath =".//input[@name='j_username']")
	public WebElement userName;
	
	@FindBy(xpath =".//input[@name='j_password']")
	public WebElement passWord;

	@FindBy(xpath =".//input[@type='submit']")
	public WebElement logIn;
	
	public Pages_loginPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
}
