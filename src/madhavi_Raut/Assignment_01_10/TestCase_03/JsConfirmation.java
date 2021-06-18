package madhavi_Raut.Assignment_01_10.TestCase_03;
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

public class JsConfirmation {

	void checkJsConfirmation() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='UserLastName']"))));
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")));
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP - Verifying Alert");
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			alert.accept();
			if ((driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText()).equals("You pressed OK!"))
				System.out.println("OK message is displayed correctly.");
			else
				System.out.println("OK message is displayed incorrectly.");
		}
		System.out.println("STEP - Verifying Cancel Message");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		driver.switchTo().alert();
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			alert.dismiss();
			if ((driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText()).equals("You pressed Cancel!"))
				System.out.println("Cancel message is displayed correctly.");
			else
				System.out.println("Cancel message is displayed incorrectly.");
		}
		System.out.println("STEP - Closing Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new JsConfirmation().checkJsConfirmation();
	}
}
