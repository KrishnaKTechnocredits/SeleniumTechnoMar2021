package kajal.assignments;
/*
 * verify the message the message displayed on paragraph is matching with expected message format
 * 
 * */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase5a_JSPrompt {
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
		String actualMsg = "Hello " + name + "! How are you today?";
		// System.out.println(actualMsg);
		// System.out.println(msgonAlert);
		if (msgonAlert.equals(actualMsg)) {
			System.out.println("Alert message validate successfully");
		} else {
			System.out.println("Alert message is incorrect , please submit again");
		}

		driver.close();
	}
}
