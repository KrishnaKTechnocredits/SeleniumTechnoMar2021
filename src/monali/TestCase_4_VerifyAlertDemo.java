package monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_4_VerifyAlertDemo {

	public static void main(String[] args) throws InterruptedException {

		String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");

		System.out.println("STEP- click on basic element link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);
		System.out.println("STEP - click on alert button");
		WebElement ele = driver.findElement(By.id("javascriptConfirmBox"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.click();

		Thread.sleep(3000);
		System.out.println("STEP - Verify alert message");
		Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();

		System.out.println(alertActualText);
		if (expectedAlertMessage.equals(alertActualText)) {
			alert.accept();
			System.out.println("you pressed ok");
		} else {
			alert.accept();
			System.out.println("you pressed cancle");
		}
	}
}
