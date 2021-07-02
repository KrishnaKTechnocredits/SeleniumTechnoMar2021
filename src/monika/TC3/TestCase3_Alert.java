package monika.TC3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*Test Case 3
1. Launch chrome browser
2. Open automationbykrishna.com
3. click on registration link
4. enter username
5. enter password
6. click on submit button
7. verify alert message*/
public class TestCase3_Alert {
	
	private static WebDriver driver;
	@Test
	public static void verifyAlertMessage() throws InterruptedException {
		System.out.println("STEP: Launch browser");
		
		driver = PredefinedActions.start();
		System.out.println("STEP: Click on button");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("registration2")).click();
		
		System.out.println("STEP: Enter values");
		driver.findElement(By.id("unameSignin")).sendKeys("Monika");
		driver.findElement(By.id("pwdSignin")).sendKeys("Welcome");
		System.out.println("STEP: Click on submit button");
		
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP: Switch to alert");
		
		String actualAlertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		System.out.println("STEP: Verify alert message");
		Assert.assertEquals(actualAlertMessage, "Failed! please enter strong password");
		/*if (actualAlertMessage.equals(actualAlertMessage + "Failed! please enter strong password"))
			System.out.println("Alert Message is Same");
		else if (actualAlertMessage.equals("Success!"))
			System.out.println(actualAlertMessage + "Alert Message is Same");*/
		
		System.out.println("END");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
/*	public static void main(String[] args) throws InterruptedException {
		verifyAlertMessage();
	}
*/
}
