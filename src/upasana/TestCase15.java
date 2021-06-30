package upasana;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase15 {

	@Test(dataProvider = "loginDetailsProvider")
	public void getOutput(String name, String pwd, String expectedResult) {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP - OPEN REGISTRATION PAGE ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();

		System.out.println("");
		System.out.println("STEP - ENTER USERNAME ");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(name);

		System.out.println("");
		System.out.println("STEP - ENTER PASSWORD ");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);

		System.out.println("");
		System.out.println("STEP - CLICK SUBMIT BUTTON ");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("VERIFY ALERT MESSAGE ");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();

		Assert.assertEquals(expectedResult, actualAlertText);
		alert.accept();
		driver.quit();
	}

	

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] loginDetailsProvider() {
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "simmi";
		obj[0][1] = "simmi123@mail.com";
		obj[0][2] = "Success!";

		obj[1][0] = "pallavi";
		obj[1][1] = "pallavi@yahoo.com";
		obj[1][2] = "Success!";
		
		return obj;
	}

}
