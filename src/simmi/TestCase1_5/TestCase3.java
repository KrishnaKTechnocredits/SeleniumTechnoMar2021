package simmi.TestCase1_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"*/

public class TestCase3 {
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
		String expectedAlert = "You must be TechnoCredits student!!";
		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();

		Alert alert2 = driver.switchTo().alert();
		String getAlert = alert2.getText();
		if (getAlert.equals(expectedAlert)) {
			System.out.println(expectedAlert);
		} else {
			System.out.println("ALert not handled properly");
		}

		alert2.accept();
	}
}
