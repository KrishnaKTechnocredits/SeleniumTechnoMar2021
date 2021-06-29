/*
TC#2 - Second Box

- Enter email
- Enter password
- verify message "You successfully clicked on it"
 */
package kajal.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.out.println("STEP 1. Launch a chrome");
		WebDriver driver = new ChromeDriver();

		String url = "http://automationbykrishna.com/";
		System.out.println("STEP 2. Open automationbykrishnacom");
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement basic = driver.findElement(By.id("basicelements"));
		basic.click();
		Thread.sleep(2000);

		System.out.println("TC#1 SATRTED");
		System.out.println("STEP 3 Enter Email id");
		WebElement email = driver.findElement(By.xpath("//input[@id='exampleInputEmail1']"));
		email.sendKeys("kajal.kirdat@gmail.com");

		System.out.println("STEP 4 Enter Password");
		WebElement password = driver.findElement(By.xpath("//input[@id='pwd']"));
		password.sendKeys("India@123");

		System.out.println("STEP 5 click on submit button");
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitb2']"));
		submitButton.click();

		String expectedAlertMsg = "You successfully clicked on it";

		System.out.println("STEP 6 verify message, You successfully clicked on it");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(expectedAlertMsg)) {
			System.out.println("Alert message validate successfully");
		} else {
			System.out.println("Alert message is incorrect , please submit again");
		}
		alert.accept();
		driver.close();
	}

}