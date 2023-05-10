package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class B_AccountRegistrationPage extends BasePage
{
	public WebDriver driver;


	// Constructor
	public B_AccountRegistrationPage(WebDriver driver)
	{
		super (driver);
	}
	
	// WebElements
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement text_firstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement text_lastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement text_email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement text_password;
	@FindBy(xpath = "//input[@id='input-newsletter-yes']") WebElement radBtn_newsletterYes;
	@FindBy(xpath = "//input[@name='agree']") WebElement chkBx_agreePolicy;
	@FindBy(xpath = "//button[text()='Continue']") WebElement btn_continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg_confirmation;
	
	
	//Actions Method
	
	public void setFirstName(String fname)
	{
		text_firstName.sendKeys(fname);
	}

	public void setLasttName(String lname)
	{
		text_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		text_email.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void clickNewsletter() 
	{
		radBtn_newsletterYes.click();
	}
	
	public void clickPrivacyPolicy() 
	{
		chkBx_agreePolicy.click();
	}

	public void clickContinue()
	{
		btn_continue.click();
	}

	public String getConfirmationMsg()
	{
		
		return msg_confirmation.getText();
	}
	
}
