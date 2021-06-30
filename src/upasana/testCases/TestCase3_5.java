package upasana.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase3_5 {
	public static void main(String[] args) throws InterruptedException {

		String alertMsgExpected = "Hello Upasana! How are you today?";

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

		System.out.println("Step 5: Click on Javascript Prompt tab");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();

		Thread.sleep(2000);

		System.out.println("Step 6: Switch to Alert, Enter Name and press OK ");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Upasana");
		Thread.sleep(2000);
		alert.accept();

		System.out.println("Step 7: Get the label text and verify with expected ");
		String msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		System.out.print("Step 8 : ");
		if (alertMsgExpected.equals(msg))
			System.out.println("actual msg is same as expected : " + msg);
		else
			System.out.println("actual msg is not same as expected");

		driver.close();

	}

}
