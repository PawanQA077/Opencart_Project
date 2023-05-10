package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class C_LoginPage extends BasePage {
	
	public C_LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath ="//input[@id='input-email']") WebElement text_email;
	@FindBy(xpath ="//input[@id='input-password']") WebElement text_password;
	@FindBy(xpath ="//button[text()='Login']") WebElement btn_login;
	
	public void setEmail(String eml)
	{
		text_email.sendKeys(eml);
	}
	
	public void setPassword(String pwrd)
	{
		text_password.sendKeys(pwrd);
	}

	public void clickLogin()
	{
		btn_login.click();
	}

}
