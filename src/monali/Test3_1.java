package monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test3_1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		
		System.out.println("STEP- click on registration link");
		driver.findElement(By.id("basicelements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP- enter name");
		driver.findElement(By.id("UserFirstName")).sendKeys("monali");
		
		Thread.sleep(3000);
		System.out.println("STEP- enter LastName");
		driver.findElement(By.id("UserLastName")).sendKeys("Tondare");
		
		Thread.sleep(3000);
		System.out.println("STEP- enter CompanyName");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Tesla");
		
		System.out.println("STEP - click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		Thread.sleep(3000);
		System.out.println("Verify - alert message");
		 Alert alert = driver.switchTo().alert();
			alert.getText();
			

			String ActualAlertMsg = "monali and Tondare and Tesla";
			if(ActualAlertMsg.equals(alert.getText())){
				System.out.println("pass");
			}else {
				System.out.println("fail");
			}
			
		alert.accept();
	}
	
	
}
