package monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test_3_2 {
	
	public static void main(String[] args) throws InterruptedException {
		String expectedFailedMessage = "Failed please enter strong passward";
		String expectedSuccessMessage = "You Successfully clicked on it";

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		
		System.out.println("STEP- click on registration link");
		driver.findElement(By.id("basicelements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP- enter email");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("monalitondare93@gmail.com");
		
		System.out.println("STEP- enter passward");
		String passward = "Tondare123";
		driver.findElement(By.id("pwd")).sendKeys("Tondare123");
		
		
		System.out.println("STEP - click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		Thread.sleep(3000);
		System.out.println("Verify - alert message");
		 Alert alert = driver.switchTo().alert();
		 String ActualSuccessmsg = "You Successfully clicked on it";
			if(expectedSuccessMessage.equals(ActualSuccessmsg))
				System.out.println("test pass");
			else
				System.out.println("test fail");
			 alert.accept(); 
		
	}
	

}