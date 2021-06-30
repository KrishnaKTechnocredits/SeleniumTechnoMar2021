package pallavi.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pallavi.base.Predefined;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Predefined.setUp("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		String username = "Pallavi";
		String password = "Pallavi123";
		String company = "Atos";

		System.out.println("Enter FirstName-");
		driver.findElement(By.id("UserFirstName")).sendKeys(username);

		System.out.println("Enter Password");
		driver.findElement(By.id("UserLastName")).sendKeys(password);

		System.out.println("Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);

		System.out.println("Press Submit Button");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String expectedText = username + " and " + password + " and " + company;
		Alert alert = driver.switchTo().alert();
		String getOutput = alert.getText();

		if (expectedText.equals(getOutput)) {
			System.out.println("test Case passed");
		} else {
			System.out.println("test case failed !!!");
		}

		alert.accept();
		driver.close();

	}

}
