package week5.day2.assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass{
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
    String[][] data = RdExcelData.readExcelData("Duplicate Lead");
    return data;
	}
    
	@Test(dataProvider="TestData")

	public  void duplicatingDataProvider(String emailId) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.linkText("Email")).click();
		
		driver.findElement(By.name("emailAddress")).sendKeys(emailId);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		String FirstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).getText();
		System.out.println("First Name " + FirstName);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		boolean titleShown = driver.findElement(By.id("sectionHeaderTitle_leads")).getText().equals("Duplicate Lead");
		System.out.println(titleShown);
		
		driver.findElement(By.name("submitButton")).click();
		
		boolean verify = driver.findElement(By.id("viewLead_firstName_sp")).getText().equals(FirstName);
		System.out.println("Duplicated lead name is same as Captured name-"+verify);
		

	}

}
