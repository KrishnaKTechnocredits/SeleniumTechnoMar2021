package upasana.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase3_3 {
	public static void main(String[] args) throws InterruptedException {

		String alertMsgExpected = "You must be TechnoCredits student!!";

		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

		System.out.println("Step 1: Launch a chrome");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // Maximize window

		System.out.println("Step 2: Open Google.com");
		driver.get("https://google.com/");

		System.out.println("Step 3: navigate to \"http://automationbykrishna.com\"");
		driver.navigate().to("http://automationbykrishna.com");

		driver.manage().window().maximize();

		System.out.println("Step 4: Click on BasicElements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("Step 5: Click on Alert tab");
		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();

		System.out.println("Step 6: Switch to Alert, get that text and verify.");
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();

		System.out.print("Step 7: ");
		if (alertMsgExpected.equals(alertMsg))
			System.out.println("actual msg is same as expected : " + alertMsg);
		else
			System.out.println("actual msg is not same as expected");

		alert.accept();

		driver.close();

	}

}
