package monika.TC9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;
import monika.TC7.FindLastNameGivenFirstName;

public class VerifyUserNameOnTable {
	WebDriver driver;
	
	@Test
	void verifyUserNameOnTable() {
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		String[] arr = {"zerothIndex","mkanani","kkanani","dboda","asharma","ppatro"};
		for(int index=1;index<arr.length;index++) {
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[4]")).getText();
			Assert.assertEquals(actualUserName, arr[index]);
		}
	}
	
	@AfterMethod
	void close() {
		driver.close();
	}
	
}
