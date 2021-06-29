/*
 TC#1
click Alert button
Verify - "You must be TechnoCredits student"
 
 TC#3
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/
package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase5_1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("STEP 1 :- Click on Basic Element link");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		
		System.out.println("STEP 2 :- Click on Alert");
		element.click();
		
		System.out.println("Step 3: Handle alert");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMsg = "You must be TechnoCredits student!!";
		String alertMsg = alert.getText();
		System.out.println(alertMsg);
		if(expectedAlertMsg.equals(alertMsg)) {
			alert.accept();
			System.out.println("Alert message verified");
		}
		else
			System.out.println("Getting different alert message");
		
		driver.close();
		
	}

}
