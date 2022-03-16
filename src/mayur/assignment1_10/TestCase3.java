package mayur.assignment1_10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		System.out.println("STEP - Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("STEP - Get Text from Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("VERIFY - Alert text");
		if (actualText.equals(expectedText))
			System.out.println("Alert Text is correct - PASS");
		else
			System.out.println("Alert Text is Incorrect - FAIL");

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();

		System.out.println("STEP - Close Browser ");
		driver.close();
	}
}
