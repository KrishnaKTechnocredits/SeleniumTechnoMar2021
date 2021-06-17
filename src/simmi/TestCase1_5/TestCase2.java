package simmi.TestCase1_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC#2 - Second Box - Enter email - Enter password - verify message
 * "You successfully clicked on it"
 */

public class TestCase2 {
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
		System.out.println("");
		System.out.println(" STEP 7 - Enter email ID");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("217simmisingh@gmail.com");

		System.out.println("");
		System.out.println(" STEP 8 - Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("123Simmi");

		System.out.println("");
		String expectedAlert = "You successfully clicked on it";
		System.out.println(" STEP 9 - Verify the alert message");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Alert alert1 = driver.switchTo().alert();
		String getAlert1 = alert1.getText();
		System.out.println("");
		if (getAlert1.equals(expectedAlert)) {
			System.out.println(expectedAlert);
		} else {
			System.out.println("ALert not handled properly");
		}

		alert1.accept();
	}
}
