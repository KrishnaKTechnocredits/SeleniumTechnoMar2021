package monali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_5_VerifyAlertDemoJavaScriptPrompt {
	
	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		
		System.out.println("STEP- click on basic element link");
		driver.findElement(By.id("basicelements")).click();
		
		
		Thread.sleep(3000);
		System.out.println("STEP - click on alert button");
		WebElement ele = driver.findElement(By.id("javascriptPromp"));
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",ele);
		ele.click();

		
		Thread.sleep(3000);
		System.out.println("STEP - Verify alert message");
		 Alert alert = driver.switchTo().alert();
			
			alert.sendKeys("monali");
			alert.accept();
			
		 
			
	}

	}


