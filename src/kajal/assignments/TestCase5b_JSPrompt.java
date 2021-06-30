package kajal.assignments;

/*
 TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
 * */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase5b_JSPrompt {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = PredefinedActions.start();
		WebElement basic = driver.findElement(By.id("basicelements"));
		basic.click();
		Thread.sleep(2000);

		System.out.println("STEP 3 click on Javascript prompt button");
		WebElement JavascriptAlert = driver.findElement(By.xpath("//button[@onclick='callJavaScriptPrompt()']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", JavascriptAlert);

		JavascriptAlert.click();
		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		System.out.println("STEP 5 Verify message validated successfully or not");
		String name = "kajal";
		alert.sendKeys(name);
		alert.accept();
		String msgonAlert = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (msgonAlert.contains(name)) {
			System.out.println("Give name is present is paragraph ");
		} else {
			System.out.println("Given name is not present");
		}

		driver.close();
	}
}
