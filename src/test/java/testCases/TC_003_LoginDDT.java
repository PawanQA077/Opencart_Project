package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.A_HomePage;
import pageObject.C_LoginPage;
import pageObject.D_MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	// Here along with dataProvider we have need to mentioned dataProviderClass Because our DataProviders method outside the package
	// Hence to identify DataProvider method we have need to mentioned class also
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class) 
	public void test_LoginDT(String email, String password, String status)	 // Dataproviders return logindata in the form of email, password and 								
	{																	     // status as per Excel sheet
		logger.info("**** TC_002_LoginDDT is Started ****");
		
	try
	{
		A_HomePage hp = new A_HomePage(driver);
		hp.clickMyAccount();
		logger.info("==== Click on MyAccount ====");
		hp.clickLogin();
		logger.info("==== Click on Login ====");
		
		C_LoginPage lp = new C_LoginPage(driver);
		logger.info("==== Sending Data From Excel sheet file to Login Page ====");
		lp.setEmail(email);							// email comes from method
		lp.setPassword(password);					// password comes from method
		lp.clickLogin();
		logger.info("==== Click on Login Button ====");
		
		D_MyAccountPage map = new D_MyAccountPage(driver);
		logger.info("==== Validating Login with both Act Page displayed and Status from Excel ====");
		
		// Here we validate login data with MyAccount page is visible or not and also with our excel sheet status(with +tve & -tve scenario)
		
		boolean actPage = map.myAccountPageExist();
		
		// status comes from method
		if(status.equals("Valid"))					//1,5) If dta is valid
		{
			if (actPage == true)					//2) with valid data we login and act page is displayed
			{
				map.clickLogout();					//4) Logout and check another data
				Assert.assertTrue(true);			//3) then test is pass with positve sceanario
			}
			else									//6)but act page is not diplayed
			{
				Assert.assertTrue(false);		    //7)then test is failed with positive sceanario
			}
		}
		
		if(status.equals("Invalid"))				// a,d) If data is Invalid
		{
			if (actPage == true)					// b) But with invalid data we login and act page is displayed
			{
				map.clickLogout();					// d) logout and check another data
				Assert.assertTrue(false);			// c) then test is failed with negative sceanario
			}
			else 									// e) with invalid data we are unable to see act page
			{
				Assert.assertTrue(true);			// f) then test is passed with negative sceanrio
			}	
		}
	
	}
	catch (Exception e)
	{
		System.out.println("Exception occurs = " +e.getMessage());
		Assert.fail();
	}
		
		logger.info("**** TC_002_LoginDDT is Finished ****");

	}
}
