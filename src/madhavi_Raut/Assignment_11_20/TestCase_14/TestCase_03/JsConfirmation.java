package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_03;
/*TC#4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsConfirmation {

	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	void checkJsConfirmation() {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Basic Elements"))));
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")));
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP - Verifying Alert");
		Assert.assertEquals(alert.getText(), "Are you are doing your homework regularly, Press Okay else Cancel!!");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText(), "You pressed OK!",
				"OK message is displayed incorrectly.");

		System.out.println("STEP - Verifying Cancel Message");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Are you are doing your homework regularly, Press Okay else Cancel!!");
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText(), "You pressed Cancel!",
				"Cancel message is displayed incorrectly.");
	}
}
