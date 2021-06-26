package technocredits.testngDemo;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;
import technocredits.utility.ExcelOperation;

public class RegistrationTestWithExcel {

	@Test(dataProvider="loginDetailsProvider")
	public void registrationLoginTest(String username, String password, String expectedAlertText) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(username);
		System.out.println("STEP - enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		System.out.println("STEP - click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		System.out.println("Verify - alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		Assert.assertEquals(expectedAlertText, alterActualText);
		alert.accept();
	}

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] m1() throws IOException {
		return ExcelOperation.readExcel("LoginData.xlsx", "Data");
	}

}
