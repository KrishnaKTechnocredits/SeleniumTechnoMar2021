package amrutaM.testcases;

/*TC#2 - Second Box - BASIC FORMS
- Enter email
- Enter password
- verify message "You successfully clicked on it"*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import amrutaM.base.PredefinedActions;

public class TC3AlertDemoForm2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.setUp();
		System.out.println("Step 1: Clicking on the Basic Elements menu link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(1000);
		System.out.println("Step 2: Entering the email address");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("amruta@gmail.com");;
				
		System.out.println("Step 3: Entering the password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("amruta123");;
				
		System.out.println("Step 5: Clicking the Submit button");
		driver.findElement(By.xpath("//div/button[@id='submitb2']")).click();
		
		String expectedMessage = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		System.out.println("Actual alert message displayed is --> "+actualAlertMessage);
			if (expectedMessage.equals(actualAlertMessage)) {
				System.out.println("Verification Passed - Alert message text matched!!");
			} else {
				System.out.println("Verification failed - Alert message text do not matched!!");
			}
		
		alert.accept();
		driver.close();
		
		
	}
}
