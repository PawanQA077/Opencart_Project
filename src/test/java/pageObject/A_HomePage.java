package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class A_HomePage extends BasePage
{
		
	// constructor
	public A_HomePage (WebDriver driver)
	{
		super (driver);
	}
	
	//Elements
	
	@FindBy(xpath = "//span[text()='My Account']") WebElement lnk_myAccount;
	@FindBy(xpath = "//a[text()='Register']") WebElement lnk_Register;
	@FindBy(xpath = "//a[text()='Login']") WebElement lnk_Login;
	
	// Actions Methods
	
	public void clickMyAccount()
	{
		lnk_myAccount.click();
	}
	
	public void clickRegister()
	{
		lnk_Register.click();
	}

	public void clickLogin()
	{
		lnk_Login.click();
	}
}
