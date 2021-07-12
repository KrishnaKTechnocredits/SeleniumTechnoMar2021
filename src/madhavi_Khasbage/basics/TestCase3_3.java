package madhavi_Khasbage.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import madhavi_Khasbage.base.PredefinedActions;

/* Test case 3 of 3
Javascript
click Alert button
Verify - "You must be TechnoCredits student"
Observations: we need to scroll the window in order to click on the alert
 as the alert button is not visible 
so receiving - org.openqa.selenium.ElementClickInterceptedException
*/

public class TestCase3_3 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "http://automationbykrishna.com/index.html#";
		WebDriver driver = PredefinedActions.setUp(expectedURL);	
		driver.manage().window().maximize();
		System.out.println("STEP1:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);		
		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("STEP1:Click Alert button.");
		driver.findElement(By.id("javascriptAlert")).click();

		System.out.println("STEP2:Verify - You must be TechnoCredits student!!");
		Alert alert = driver.switchTo().alert();
		String strAlertText = alert.getText();
		if (strAlertText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		
	}
}
