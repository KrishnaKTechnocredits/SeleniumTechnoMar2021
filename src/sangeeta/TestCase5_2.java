/*TC#2
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"*/

package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase5_2 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("STEP 1 :- Click on Basic Element link");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		
		System.out.println("Step 1: Click on JavaScript Confirmation");
		element.click();
		
		System.out.println("Step 3: Handle alert");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel";
		String alertMsg = alert.getText();
		System.out.println("Alert message: "+alertMsg);
		if(expectedAlertMsg.equals(alertMsg)) {
			alert.accept();
			System.out.println("You pressed OK!");
		}
		else {
			alert.accept();
			System.out.println("You pressed Cancel!");
		}
		
		driver.close();
	}

}
