package simmi.TestCase1_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test - 3

TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/

public class TestCase1 {
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
		System.out.println(" STEP 2 - Enter first Name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Simmi");

		System.out.println("");
		System.out.println(" STEP 3 - Enter the last name");
		driver.findElement(By.id("UserLastName")).sendKeys("Singh");

		System.out.println("");
		System.out.println(" STEP 4 - Enter the company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Infosys");

		Thread.sleep(2000);
		System.out.println("");
		System.out.println(" STEP 5 - Click on Submit");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(" STEP 6 - VERIFY - Verify the alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		System.out.println("");
		System.out.println(alterActualText);

		alert.accept();

		/*
		 * TC#2 - Second Box - Enter email - Enter password - verify message
		 * "You successfully clicked on it"
		 */

		System.out.println("");
		System.out.println(" STEP 7 - Enter email ID");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("217simmisingh@gmail.com");

		System.out.println("");
		System.out.println(" STEP 8 - Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("123Simmi");

		System.out.println("");
		System.out.println(" STEP - Click on submit");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

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
