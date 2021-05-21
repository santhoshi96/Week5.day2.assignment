package week5.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass

{
	public ChromeDriver driver;
        
	    @BeforeMethod
		public void setup() throws InterruptedException {
	    	WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps");
			driver.manage().window().maximize();
			//username
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			//password
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			//login button
			driver.findElement(By.className("decorativeSubmit")).click();
			//Title
			String text=driver.findElement(By.tagName("h2")).getText();
			System.out.println(text);
			//CRM/SFA
			driver.findElement(By.linkText("CRM/SFA")).click();

		}
		@AfterMethod
		public void teardown()  {
			driver.close();

	}
	


	}


