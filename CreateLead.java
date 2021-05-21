package week5.day2.assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
    @Test(invocationCount=3)
	public void CreatingLead() {
		
		//Create lead
				driver.findElement(By.linkText("Create Lead")).click();
				//Company Name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
				//first name
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Santhoshi");
				//last name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("T");
				driver.findElement(By.className("smallSubmit")).click();
	}

}
