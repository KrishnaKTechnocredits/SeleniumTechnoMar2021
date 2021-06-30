/*
 *Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"
 */
package kajal.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase3_Javascriptalert {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=PredefinedActions.start();
		Thread.sleep(2000);
		WebElement basic = driver.findElement(By.linkText("Basic Elements"));
		basic.click();
		Thread.sleep(2000);

		System.out.println("STEP 3 click on Alert button");
		WebElement JavascriptAlert = driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",JavascriptAlert);
		JavascriptAlert.click();
		
		Alert alert=driver.switchTo().alert();
		
		String alertMsg= "You must be TechnoCredits student!!";
		System.out.println("STEP 4 Verify - You must be TechnoCredits student");
		if(alert.getText().equals(alertMsg)) {
			System.out.println("Alert message validate successfully");
		} else {
			System.out.println("Alert message is incorrect , please submit again");
		}
		alert.accept();
		driver.close();
	}		
	
}
