/*

 * Test - 3
 
TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.
 */
package kajal.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase1 {

	public static void main(String[] args) throws InterruptedException {
		String fname = "Kajal";
		String lname = "Kirdat";
		String cmpName = "@123";

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
		System.out.println("STEP 3 Enter First Name");
		WebElement firstname = driver.findElement(By.xpath("//input[@name='ufname']"));// find by xpath
		firstname.sendKeys(fname);

		System.out.println("STEP 4 Enter Last Name");
		WebElement lastName = driver.findElement(By.id("UserLastName"));// find by id
		lastName.sendKeys(lname);

		System.out.println("STEP 5 Enter Company Name");
		WebElement cmpname = driver.findElement(By.name("cmpname"));// find by name
		cmpname.sendKeys(cmpName);

		System.out.println("STEP 6 Click on submit button");
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

		System.out.println("STEP 7 Verify alert message");
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		if (alertMessage.equals(fname + " and " + lname + " and " + cmpName)) {
			System.out.println("Alert message validate successfully");
		} else {
			System.out.println("Alert message is incorrect , please submit again");
		}
		alert.accept();
		driver.close();

	}
}
