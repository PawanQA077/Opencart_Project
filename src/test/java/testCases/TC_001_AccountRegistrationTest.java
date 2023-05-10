package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.A_HomePage;
import pageObject.B_AccountRegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{	
	
	@Test(groups= {"Regression","Master"})
	public void test_Account_Registration()
	{
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
	
		try
		{
		A_HomePage hp = new A_HomePage(driver);
		hp.clickMyAccount();
		logger.info("=== Clicked on My Account ===");
		hp.clickRegister();
		logger.info("=== Clicked on Register ===");

		B_AccountRegistrationPage actReg = new B_AccountRegistrationPage(driver);
	/*	
		actReg.setFirstName("Pawan");
		actReg.setLasttName("Deshpande");
		actReg.setEmail("abcxyza@gmail.com");
		actReg.setPassword("xyza@123");
		actReg.clickNewsletter();
		actReg.clickPrivacyPolicy();
		actReg.clickContinue();
		
		// In above flow of regesrtation page there is some hardcoded data we used but application want unique gmail every time.
		// If i am try to execute above script multiple time then it failed due to same email and to avoid this i have need to change that email 
		// every time.
		// So insted of change email every time, I can used random data generated class i.e RandomStringUtils class which return random alphabets
		// & numeric string as per our requirement of lenegth of string
		// In future we required dynamic data most time so we take place that class in BaseClass and use in test class directly
	*/
		logger.info("=== Providing Registration Data ===");

		actReg.setFirstName(randomString());
		actReg.setLasttName(randomString());
		actReg.setEmail(randomEmail() + "@gmail.com");
		actReg.setPassword(randomPassword());
		actReg.clickNewsletter();
		actReg.clickPrivacyPolicy();
		actReg.clickContinue();
		logger.info("=== Clicked on Continue ===");
		
		String cnfmsg = actReg.getConfirmationMsg();
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}
		catch (Exception e)
		{
			logger.error("Test Failed");
			System.out.println("Reason of Failure = " +e.getMessage());
			Assert.fail();
		}
		
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");

	}
	
	
}
