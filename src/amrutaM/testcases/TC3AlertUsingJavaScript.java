package amrutaM.testcases;

/*TC#3 - click Alert button
Verify - "You must be TechnoCredits student"
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import amrutaM.base.PredefinedActions;

public class TC3AlertUsingJavaScript {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = PredefinedActions.setUp();
		System.out.println("Step 1: Clicking on the Basic Elements menu link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(1000);
		System.out.println("Step 2: Verifying DIFFERENT EXAMPLES OF ALERTS section present");
		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", jsAlertBtn);

		System.out.println("Step 3: Clicking on JS Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("Step 5: Verifying alert message");

		String expectedMessage = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		System.out.println("Actual alert message displayed is --> " + actualAlertMessage);
		if (expectedMessage.equals(actualAlertMessage)) {
			System.out.println("Verification Passed - Alert message text matched!!");
		} else {
			System.out.println("Verification failed - Alert message text do not matched!!");
		}

		alert.accept();
		PredefinedActions.tearDown();
	}
}
