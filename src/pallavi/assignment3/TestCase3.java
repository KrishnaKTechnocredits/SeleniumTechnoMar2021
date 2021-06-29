package pallavi.assignment3;
/*TC#3
click Alert button
Verify - "You must be TechnoCredits student"

Observations: we need to scroll the window in order to click on the alert as the alert button is not visible */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pallavi.base.Predefined;

public class TestCase3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Predefined.setUp();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		String successMessage = "You must be TechnoCredits student!!";
		/*
		 * JavascriptExecutor je=(JavascriptExecutor)driver;
		 * je.executeScript("window.scrollBy(0,300)");
		 */

		System.out.println("Click on alert button");
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-xs btn-info']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		driver.findElement(By.id("javascriptAlert")).click();

		Alert alert = driver.switchTo().alert();
		String getText = alert.getText();
		if (successMessage.equals(getText)) {
			System.out.println("Test Case passed");
		} else {
			System.out.println("Failed!!");
		}
		alert.accept();
		driver.close();

	}

}
