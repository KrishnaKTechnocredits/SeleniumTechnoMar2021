package priyanka_Panat.TestCase_15;

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


public class LoginTestUsingDataProvider {
	public WebDriver driver;

	@Test(dataProvider = "loginDetails")
	void loginTest(String userName, String password, String expectedResultMsg) {
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP - Enter UserName ");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']"))).sendKeys(userName);
		System.out.println("STEP - Enter Password ");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("STEP - Click on Submit button ");
		WebElement element = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		element.click();
		System.out.println("STEP- Verify alert message");
		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();
		Assert.assertEquals(expectedResultMsg, actualAlertMsg);
		alert.accept();
		driver.close();
	}

	@DataProvider(name = "loginDetails")
	public Object[][] loginDetails() {
		Object[][] data = new Object[4][3];
		data[0][0] = "Priyanka";
		data[0][1] = "Priya123";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "Shriya";
		data[1][1] = "Shriya@1234";
		data[1][2] = "Success!";

		data[2][0] = "Ankita";
		data[2][1] = "Ankita22567";
		data[2][2] = "Success!";

		data[3][0] = "Samarpita";
		data[3][1] = "Samarpita@999";
		data[3][2] = "Success!";

		return data;
	}
}
