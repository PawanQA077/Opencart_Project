package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

// Create BaseClass under testBase package and copy re-usable methods.
// Create re-usable methods to generate random numbers and strings in BaseClass
// LogManager have predfined class which have also one method which manage the log with which class we have to executed.
// Logger is return type of complete statement need to import from apache.logging.log4j & mentioned it in as public i.e public Logger logger 
// And through the instance we can store LogManager class with getLogger() method in setup() method which is in Base class.

public class BaseClass 
{
	public static WebDriver driver;		// We make it static because we refer same driver instance in ExtentReportUtilit, if we not make static
									    // after attached ExtentReportManager with listner then it gave exception NullPointer i.e "takesScreenshot" is null.
	
	public Logger logger;			// Logger is predefined class need to import from apache.logging.log4j
	
	public ResourceBundle rb;		// ResourceBundle is predefined class imports from java.utils to read config.properties file
		
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{															
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"}); 
		
/* "chrome control by automated test software" this will be displayed after excuting driver to avoid that we need to used chromeoptions and pass 
 * that instance to ChromeDriver constructor  */
		
														// LogManager is class have one method which manage the log which class we have to executed
		logger = LogManager.getLogger(this.getClass());	// Here we have need to mentioned which class we want to execute but insted of harcoded 
														// test class name we know this refer to class so by using this call getClass() method
														// so this call actual method at run time which we executed
		
		rb= ResourceBundle.getBundle("config");			// ResourceBundle class have one method i.e getBundle() and both help to 
														// Load config.properties file which is we created under resources folder
				
		if (br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		driver.get(rb.getString("appURL"));;				//  get url from config.properties file, whenever we have call any key from
															//  from properties file then by using instance we have need to call getString()
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	

	
	// RandomStringUtils class Generates random Strings which is comes from Apache Common dependcy
	// This class generates random Strings and that string may be alphabetically or numeric and we get reuired data as per which method we used
	// It provides two methods i.e randomAlphabetic() & randomNumeric() and both method accept parameter of how much number string we want
	// If we put 6 then it return string of 6 numbers
	// So by using this method we are able to generate random data and it is useful to use in sceanario where we have need to provide every time
	// unique data (Ex. Email, Mobile number, OTP etc)
	// As per our requirement we used that method

	public String randomString()
	{
		String alphabeticdString = RandomStringUtils.randomAlphabetic(5);
		return alphabeticdString;
	}
	
	public String randomNumber()
	{
		String numericString = RandomStringUtils.randomNumeric(10);
		return numericString;
	}
	
	public String randomEmail()
	{
		String alphaString = RandomStringUtils.randomAlphabetic(5);
		String numbString = RandomStringUtils.randomNumeric(3);
		
		return (alphaString + numbString);
	}
	
	public String randomPassword()
	{
		String alphaString = RandomStringUtils.randomAlphabetic(4);
		String numbString = RandomStringUtils.randomNumeric(2);
		
		return (alphaString + "@" + numbString);
	}
	
	
	public String captureScreen(String tname) throws IOException {			// tname is our test name

		//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		//Date dt = new Date();
		//String timeStamp = sdf.format(dt);
		
		// Above three statement merged in single statement which gave us timestamp
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
