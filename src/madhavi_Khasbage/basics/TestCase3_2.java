package madhavi_Khasbage.basics;
/*TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase3_2 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "http://automationbykrishna.com/index.html#";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
		System.out.println("STEP1:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP2:Enter email");
		driver.findElement(By.name("emailId")).sendKeys("Madhavi");
		System.out.println("STEP3:Enter password");
		driver.findElement(By.id("pwd")).sendKeys("madhavi22");

		String expectedText = "You successfully clicked on it";

		System.out.println("STEP4:Click submit.");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("STEP5:verify message You successfully clicked on it");
		Alert alert = driver.switchTo().alert();
		String strAlertText = alert.getText();
		if (strAlertText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		
	}
}
