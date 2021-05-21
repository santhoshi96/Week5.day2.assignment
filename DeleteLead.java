package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
    String[][] data = RdExcelData.readExcelData("Delete Lead");
    return data;
	}
    
	@Test(dataProvider="TestData")

	public void deletingDataProvider(String phoneNumber) throws InterruptedException {
		//Click Lead
				driver.findElement(By.linkText("Leads")).click();
				//Click findlead
				driver.findElement(By.linkText("Find Leads")).click();
				//Click Phone
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
				//Enter Phone Number
				driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
				//Click find leads
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			    //capture lead
				Thread.sleep(2000);
				String FirstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();
				System.out.println("First Lead ID" + FirstLead);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
				Thread.sleep(1000);
				//click delete
				driver.findElement(By.linkText("Delete")).click();
				//click find leds
				driver.findElement(By.linkText("Find Leads")).click();
		// Enter the lead id
				driver.findElement(By.name("id")).sendKeys(FirstLead);

				// Click on Find Leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				Thread.sleep(2000);

				// No Records Found - Verification
				String leadi_del = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

				if (leadi_del.contains("No records to display"))

				{
					System.out.println("No Records Found - Verified");
				} else {
					System.out.println("Verified - Records found");
				}

	}

}
