package shilpa.Assignment_1_10;

/*TC-4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class TC4_JsConfirmation {

	void checkJsConfirmation() {
		WebDriver driver = new LaunchBrowser().start("http://automationbykrishna.com/");

		System.out.println("STEP - Open Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP - Scroll down to view Javascript confirmation button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")));
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		System.out.println("STEP - Verify Alert - OK Message");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			alert.accept();
			if ((driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText()).equals("You pressed OK!"))
				System.out.println("Displayed OK message is correct.");
			else
				System.out.println("Displayed Ok message is incorrect.");
		}

		System.out.println("STEP - Verify Alert - Cancel Message");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		driver.switchTo().alert();
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			alert.dismiss();
			if ((driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText()).equals("You pressed Cancel!"))
				System.out.println("Displayed Cancel message is correct..");
			else
				System.out.println("Displayed Cancel message is incorrect..");
		}
		driver.close();
	}

	public static void main(String[] args) {
		new TC4_JsConfirmation().checkJsConfirmation();
	}
}