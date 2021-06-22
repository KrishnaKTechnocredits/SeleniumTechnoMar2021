package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_03;
/*TC#3
click Alert button
Verify - "You must be TechnoCredits student"*/

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

public class JsAlert {

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
	void checkJsAlert() {

		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("STEP - Scrolling down");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Basic Elements"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "You must be TechnoCredits student!!", "Failure");
		alert.accept();
	}
}
