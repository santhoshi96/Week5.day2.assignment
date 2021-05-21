package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead2 extends BaseClass{
    
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		String[][] data = RdExcelData.readExcelData("Create Lead");
		return data;
	}
	
	@Test(dataProvider="TestData")
	public void CreatingLead(String companyName,String firstName,String lastName) {
		
		        //Create lead
				driver.findElement(By.linkText("Create Lead")).click();
				//Company Name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
				//first name
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
				//last name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
				driver.findElement(By.className("smallSubmit")).click();
    }
}