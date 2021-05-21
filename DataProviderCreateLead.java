package week5.day2.assignment;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCreateLead extends BaseClass{
	
	@DataProvider(name="CreateLeadData")
	public Object[][] fetchData(){
		String[][] data = new String[2][4];
		data[0][0] = "Amazon";
		data[0][1] = "Santhoshi";
		data[0][2] = "Meena";
		data[0][3] = "Hi ";
		
		data[1][0] = "Zoho";
		data[1][1] = "santa";
		data[1][2] = "Tarsan";
		data[1][3] = "Hello";
		return data;
	}
	
	@Test(dataProvider="CreateLeadData")
	public void dataProviderLead(String company,String firstName,String lastName,String title) {
		driver.findElement(By.linkText("Create Lead")).click();
		//Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		//first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		//last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		//Title
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys(title);
		driver.findElement(By.className("smallSubmit")).click();
	}

}
