package simmi.TestCase1_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC#4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK"
based on Cancel - "You pressed Cancel!"*/

public class TestCase4 {
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
		String expectedAlert = "You pressed OK!";
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		String getAlert = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (getAlert.equals(expectedAlert)) {
			System.out.println(expectedAlert);
		} else {
			System.out.println("ALert not handled properly");
		}

		System.out.println(" STEP - Click on alert ");
		String expectedAlert1 = "You pressed Cancel!";
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		Thread.sleep(2000);
		Alert alert3 = driver.switchTo().alert();
		alert3.dismiss();
		String getAlert1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (getAlert1.equals(expectedAlert1)) {
			System.out.println(expectedAlert1);
		} else {
			System.out.println("ALert not handled properly");
		}
	}
}
