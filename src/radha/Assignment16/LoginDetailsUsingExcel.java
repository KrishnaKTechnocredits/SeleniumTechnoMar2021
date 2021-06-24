package radha.Assignment16;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;
import radha.Utility.ExcelOperation;

public class LoginDetailsUsingExcel {
	
	public WebDriver driver;

	@Test(dataProvider = "loginDetails")
	void loginTest(String userName, String password, String expectedResult) {
		driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP - Enter UserName ");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']"))).sendKeys(userName);
		System.out.println("STEP - Enter Password ");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("STEP - Click on Submit button ");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		submitBtn.click();
		System.out.println("STEP- Verify alert message");
		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();
		Assert.assertEquals(expectedResult, actualAlertMsg);
		alert.accept();
		driver.close();
	}
	
	@DataProvider(name = "loginDetails")
	public Object[][] loginData() throws IOException {
			return ExcelOperation.readFormExcel(".//resources/LoginDataSheet.xlsx", "Data");
	}
}
