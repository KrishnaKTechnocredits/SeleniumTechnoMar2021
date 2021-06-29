package monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		String expectedFailedMessage = "Failed please enter strong passward";
		String expectedSuccessMessage = "Success";

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		
		System.out.println("STEP - Click on registration link ");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("mTondare");
		
		System.out.println("STEP - enter passward");
		String passward = "mTondare123";
		driver.findElement(By.id("pwdSignin")).sendKeys("mTondare123");
		
		System.out.println("STEP - click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		 System.out.println("Verify - alert messaga");
		 Alert alert = driver.switchTo().alert();
		String alertActualText = alert.getText();
		 
		if(passward.length()>8) {
			if(alertActualText.equals(expectedSuccessMessage))
				System.out.println("test pass");
			else
				System.out.println("test fail");
		}else {
			if(alertActualText.equals(expectedFailedMessage))
				System.out.println("test pass");
			else	
				System.out.println("test fail");
			}
		 alert.accept(); 
	}
	}

 