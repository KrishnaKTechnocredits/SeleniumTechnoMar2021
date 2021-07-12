package monika.TC15_DataProvider_ExcelReading;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class RegistrationUsingDataProvider1 {
	private WebDriver driver;
	@Test(dataProvider = "successLoginDetails")
	public void verifySuccessRegistrationUnamePass(String uname, String pass) {
		driver = PredefinedActions.start();
		driver.findElement(By.id("registration2")).click();
		driver.findElement(By.id("unameSignin")).sendKeys(uname);
		driver.findElement(By.id("pwdSignin")).sendKeys(pass);
		driver.findElement(By.id("btnsubmitdetails")).click();
		String expSuccessMsg = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expSuccessMsg);
		alert.accept();
	}
	
	@Test(dataProvider = "failLoginDetails")
	public void verifyFailRegistrationUnamePass(String uname, String pass) throws InterruptedException {
		driver = PredefinedActions.start();
		driver.findElement(By.id("registration2")).click();
		driver.findElement(By.id("unameSignin")).sendKeys(uname);
		driver.findElement(By.id("pwdSignin")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.id("btnsubmitdetails")).click();
		String expFailMsg = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expFailMsg);
		alert.accept();
	}
	
	@DataProvider(name="successLoginDetails")
	public Object[][] successregistrationDetails() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "Monika";
		obj[0][1] = "Monika123";
		obj[1][0] = "Sonika";
		obj[1][1] = "Sonika123";
		obj[2][0] = "konika";
		obj[2][1] = "konika123";
		return obj;
	}
	
	@DataProvider(name="failLoginDetails")
	public Object[][] failRegistrationDetails() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "Monika";
		obj[0][1] = "Monika";
		obj[1][0] = "Sonika";
		obj[1][1] = "Sonika";
		obj[2][0] = "konika";
		obj[2][1] = "konika";
		return obj;
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
