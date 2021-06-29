package shilpa.Assignment_1_10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*TC-5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
*/
public class TC5_VerifyJsPrompt {
	void verifyJavascriptPrompt() {
		WebDriver driver = new LaunchBrowser().start("http://automationbykrishna.com/");

		System.out.println("STEP - Open Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("UserLastName"))));

		System.out.println("STEP - Scroll down to view Javascript Prompt button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("javascriptPromp")));
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("STEP - verify Alert");
		String name = "Shilpa";
		String msg = "Hello " + name + "! How are you today?";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		if (driver.findElement(By.id("pgraphdemo")).getText().equals(msg)) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");
		driver.close();

	}

	public static void main(String[] args) {
		new TC5_VerifyJsPrompt().verifyJavascriptPrompt();
	}

}
