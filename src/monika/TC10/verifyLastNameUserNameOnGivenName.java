package monika.TC10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class verifyLastNameUserNameOnGivenName {
	WebDriver driver;
	@Test
	public void verifyLastNameUserNameOnGivenName() {
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		String[] arr = {"zerothIndex", "Kanani","mkanani"};
		for(int index=1;index<arr.length;index++) {
			String actualResult = driver.findElement(By.xpath("//table[@id='table1']//tr[1]//td[2]//following::td[\"+index+\"]")).getText();
			Assert.assertEquals(actualResult, arr[index]);
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
