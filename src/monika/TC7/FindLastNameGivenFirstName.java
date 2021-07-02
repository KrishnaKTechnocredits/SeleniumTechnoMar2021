package monika.TC7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class FindLastNameGivenFirstName {
	WebDriver driver;
	
	@Test
	void verifyLastNameOfGivenEmp() {
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String expLastName = "Sharma";
		String actuallastName = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr//td[2][text()='Abhishek']//following::td[1]")).getText();
		System.out.println(actuallastName);
		Assert.assertTrue(actuallastName.equals(expLastName));
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
