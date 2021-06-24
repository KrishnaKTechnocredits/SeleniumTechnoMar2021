package amrutaM.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import amrutaM.base.PredefinedActions;

/*TC#4
	JS confirmation
	Read message and accordingly click - OK and cancel
	A label is added. get this label using getText(); and now verify based on below conditions -
	based on OK - "You pressed OK"
	based on Cancel - "You pressed Cancel!"
*/

public class TC4_JSConfirmation {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Launch the browser");
		System.out.println("STEP : Go to automationbykrishna.com");
		driver = PredefinedActions.setUp();
		System.out.println("STEP : Navigate to Basic Elements ");
		driver.findElement(By.linkText("Basic Elements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("STEP : Scrolling the page so that JS Confirmation Box is visible ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='javascriptConfirmBox']")));
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println("STEP : Clicking on the Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP : Switching to Alert");
		Alert al = driver.switchTo().alert();
		System.out.println("STEP : Fetching the alert text");
		String alertText = al.getText();
		System.out.println("STEP : Printing the alert text");
		System.out.println(alertText);
		System.out.println("STEP : Clicking OK ");
		al.accept();
		System.out.println("Fetching the message displayed based on user action");
		String msgDisplayed = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Message displayed is: "+msgDisplayed);
		System.out.println("Asserting the message is correct or not");
		Assert.assertEquals("You pressed OK!", msgDisplayed);
		PredefinedActions.tearDown();
	}

}
