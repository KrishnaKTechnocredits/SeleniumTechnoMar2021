package shilpa;

import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class AutomationByKrishnaLoginTest {

	public static void main(String[] args) throws InterruptedException {
		String expectedFailedMessage = "Failed! please enter strong password";
		String expectedSuccessMessage = "Success!";
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		
		System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("mkanani");
		
		System.out.println("STEP - enter password");
		String password = "mkanani123";
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		
		System.out.println("STEP - click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		System.out.println("Verify - alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		int[] temp = {1,2};
		Arrays.toString(temp);
		if(password.length() >8) {
			if(alterActualText.equals(expectedSuccessMessage))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		}else {
			if(alterActualText.equals(expectedFailedMessage))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		}
		alert.accept();
		//alert.sendKeys(keysToSend);
		//alterActualText = alert.getText();
	}
}
