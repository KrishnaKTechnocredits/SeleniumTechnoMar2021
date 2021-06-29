package simmi.TestCase1_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/

public class TestCase5 {
	public static void main(String[] args) throws InterruptedException {

		String url = "http://automationbykrishna.com";

		System.out.println("STEP 1 - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		System.out.println("");
		System.out.println("STEP 1 - Open Registration page");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		System.out.println(" STEP - Click on alert ");
		String expectedAlert = "Hello Simmi! How are you today?";
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Simmi");
		alert2.accept();

		String getAlert = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (expectedAlert.equals(getAlert)) {
			System.out.println(expectedAlert);
		} else {
			System.out.println("ALert not handled properly");
		}
		driver.close();
	}
}
