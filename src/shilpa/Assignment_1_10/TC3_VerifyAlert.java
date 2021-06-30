package shilpa.Assignment_1_10;
/*TC-3
TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.

TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"

Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"*/

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3_VerifyAlert {
	void verifyAlertMessages() {
		WebDriver driver = new LaunchBrowser().start("http://automationbykrishna.com");

		System.out.println("STEP3 - Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("exampleInputEmail1"))));

		System.out.println("STEP4 - Enter username and password");

		driver.findElement(By.id("exampleInputEmail1")).sendKeys("sh123@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("xyz123");

		System.out.println("STEP5 - click on submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("STEP7 - Verify Alert Message on clicking submit button");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("You successfully clicked on it")) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");
		alert.accept();

		System.out.println("STEP8 - Scroll down and verify alert message on clicking Alert Button");
		// System.out.println("STEP6 - Scroll down to get full view of elements");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("exampleInputEmail2")));
		driver.findElement(By.id("javascriptAlert")).click();
		driver.switchTo().alert();
		if (alert.getText().equals("You must be TechnoCredits student!!")) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");
		alert.accept();

		driver.close();

	}

	public static void main(String[] args) {
		TC3_VerifyAlert verifyAlert = new TC3_VerifyAlert();
		verifyAlert.verifyAlertMessages();
	}

}
