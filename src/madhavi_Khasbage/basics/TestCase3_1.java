package madhavi_Khasbage.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import madhavi_Khasbage.base.PredefinedActions;

/*TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.
*/
public class TestCase3_1 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "http://automationbykrishna.com/index.html#";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		System.out.println("STEP1:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP2:Enter Fname, Last name and Company name.");
		driver.findElement(By.name("ufname")).sendKeys("Madhavi");
		driver.findElement(By.name("ulname")).sendKeys("Khasbage");
		driver.findElement(By.name("cmpname")).sendKeys("VKSoft Technology");

		String expectedText = "Madhavi and Khasbage and VKSoft Technology";

		System.out.println("STEP3:Click submit.");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[@class='btn btn-primary']")).click();

		System.out.println("STEP4:You should get alert; get that text and verify.");
		Alert alert = driver.switchTo().alert();
		String strAlertText = alert.getText();
		if (strAlertText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

	}
}
