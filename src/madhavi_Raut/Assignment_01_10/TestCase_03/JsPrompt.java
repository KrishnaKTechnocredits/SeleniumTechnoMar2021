package madhavi_Raut.Assignment_01_10.TestCase_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/
public class JsPrompt {

	void checkJsPrompt(String name) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='UserCompanyName']"))));
		// Scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//button[@id='javascriptPromp']")));
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP - Verifying Alert");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		String labelMsg = "Hello " + name + "! How are you today?";
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals(labelMsg))
			System.out.println("Salutation is correct");
		else
			System.out.println("Salutation is incorrect");
		System.out.println("STEP - Closing browser");
		driver.close();
	}

	public static void main(String[] args) {
		new JsPrompt().checkJsPrompt("Madhavi");
	}
}
