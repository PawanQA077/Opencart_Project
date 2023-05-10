package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class D_MyAccountPage extends BasePage 
{
	public D_MyAccountPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement  msgHeading;
	@FindBy(xpath ="//div[@class='list-group mb-3']//a[text()='Logout']") WebElement lnk_logout;
	
	public boolean myAccountPageExist()
	{
		try
		{
		return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clickLogout()
	{
		lnk_logout.click();
	}
}
