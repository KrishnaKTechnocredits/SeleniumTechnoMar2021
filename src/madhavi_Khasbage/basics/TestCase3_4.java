package madhavi_Khasbage.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import MadhaviKhasbage.basic.PredefinedActions;

/*Test Case 3_4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK"
based on Cancel - "You pressed Cancel!"
*/

public class TestCase3_4 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "http://automationbykrishna.com/index.html#";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
		System.out.println("STEP1:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("STEP2:JS confirmation.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		String expectedOkText = "You pressed OK!";
		String expectedCancelText = "You pressed Cancel!";

		System.out.println("STEP3:Read message and accordingly click - OK and cancel");	
		Alert alert = driver.switchTo().alert();	
		alert.accept();
		//alert.dismiss();

		String alertConfText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		if (alertConfText.equals(expectedOkText)) {
			System.out.println("Test Pass >> ok press");
		} else if (alertConfText.equals(expectedCancelText)) {
			System.out.println("Test Pass >> cancel press");
		} else {
			System.out.println("Test Fail");
		}

	}
}
