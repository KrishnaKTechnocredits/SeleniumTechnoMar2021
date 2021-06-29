package madhavi_Raut.Assignment_01_10.TestCase_03;
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

public class JsAlert {

	void checkJsAlert() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='ufname']"))));
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("You must be TechnoCredits student!!"))
			System.out.println("Success!");
		else
			System.out.println("Failure");
		alert.accept();
		System.out.println("STEP - Closing Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new JsAlert().checkJsAlert();
	}
}
