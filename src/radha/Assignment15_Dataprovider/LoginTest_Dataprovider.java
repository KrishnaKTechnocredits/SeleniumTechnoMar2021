package radha.Assignment15_Dataprovider;

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

public class LoginTest_Dataprovider {

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
	public Object[][] loginData() {
		Object[][] data = new Object[4][3];
		data[0][0] = "Radha";
		data[0][1] = "Radha1234";
		data[0][2] = "Success!";

		data[1][0] = "Yash";
		data[1][1] = "Yash123456";
		data[1][2] = "Success!";

		data[2][0] = "Isha";
		data[2][1] = "Isha@123";
		data[2][2] = "Failed! please enter strong password";

		data[3][0] = "Shrug";
		data[3][1] = "Shrug0000";
		data[3][2] = "Success!";

		return data;
	}
}
