package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.A_HomePage;
import pageObject.C_LoginPage;
import pageObject.D_MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	@Test(groups= {"Sanity", "Master"})
	public void test_LoginTest()
	{
		logger.info("**** TC_002_LoginTest is Started ****");
		
		A_HomePage hp = new A_HomePage(driver);
		hp.clickMyAccount();
		logger.info("==== Click on MyAccount ====");
		hp.clickLogin();
		logger.info("==== Click on Login ====");
		
		C_LoginPage lp = new C_LoginPage(driver);
		logger.info("==== Sending Data From properties file to Login Page ====");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		logger.info("==== Click on Login Button ====");
		
		D_MyAccountPage map = new D_MyAccountPage(driver);
		logger.info("==== Validating Login Sucessfully or Not ====");
		
		try
		{
		boolean status = map.myAccountPageExist();
		Assert.assertEquals(status, true, "Login Data is Invalid");
		}
		catch(Exception e)
		{
			System.out.println("Exception occurs = " +e.getMessage());
			Assert.fail();
		}
	}

}
