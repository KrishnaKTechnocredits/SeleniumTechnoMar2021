/*Test Case 3 : 
 
 Program 1:
 TC#1 - First Box
- Go to Basic Elements Tab 
- Enter Fname, Lname and Company name in Alert Demo section.
- click submit.
- you should get alert; get that text and verify.

*/


package vaibhav.TestCase_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_1 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Step 1 : Launch a chrome & got to www.automationbyKrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("Step 2 : Go to Basic Elements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Step 3 : Enter Fname, Lname and Company name in Alert Demo section");
		Thread.sleep(3000);
		String fName = "Vaibhav";
		String lName = "Tati";
		String cName = "TechnoCredits";
		String expectedStringInAlert = fName + " and " + lName + " and " + cName;

		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cName);

		System.out.println("Step 4 : click on submit button");
		driver.findElement(By.xpath("//div[@class='col-lg-6'][1]//button[@class='btn btn-primary']")).click();

		System.out.println("Strp 5 : You should get alert; get that text and verify");

		Alert alert = driver.switchTo().alert();
		String actualTextInAlert = alert.getText();

		if (actualTextInAlert.equals(expectedStringInAlert)) {
			System.out.println("Test Pass");
			System.out.println("Expected String --> " + expectedStringInAlert);
			System.out.println("Actual String   --> " + actualTextInAlert);
		} else
			System.out.println("Test Fail : Actual Text in alert is not equal to expected text");

		alert.accept();

		System.out.println("Step 6 : Close the browser");
		driver.close();

	}
}
