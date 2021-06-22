package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_03;

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

/*TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/
public class JsPrompt {
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
	void checkJsPrompt() {
		String name = "Madhavi";
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='panel-body']"))));

		// Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//input[@id='exampleInputPassword2']")));

		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		String labelMsg = "Hello " + name + "! How are you today?";
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText(), labelMsg,
				"Salutation is incorrect");
	}
}
