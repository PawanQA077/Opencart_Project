package roughWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registerflow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get("https://demo.opencart.com/");
				driver.manage().window().maximize();
				
				
				driver.findElement(By.xpath("//span[text()='My Account']")).click();
				driver.findElement(By.xpath("//a[text()='Register']")).click();
				
				driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Pawan");
				driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Jadhav");
				driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pawan123@gmail.com");
				driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("pawan@123");
				
				JavascriptExecutor js = (JavascriptExecutor) driver;

				WebElement rdbtn = driver.findElement(By.xpath("//input[@id='input-newsletter-yes']"));
				js.executeScript("arguments[0].click();", rdbtn);							
				
				WebElement chkbox = driver.findElement(By.xpath("//input[@name='agree']"));
				js.executeScript("arguments[0].click();", chkbox);							

				Thread.sleep(3000);
				
				WebElement btn = driver.findElement(By.xpath("//button[text()='Continue']"));
				js.executeScript("arguments[0].click();", btn);							

//				Thread.sleep(3000);
//				
//				String actual = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
//				
//				if (actual.equals("Your Account Has Been Created!"))
//				{
//					System.out.println("Test is passed");
//				}
//				else
//				{
//					System.out.println("Test failed");
//				}
				
			}
		}
