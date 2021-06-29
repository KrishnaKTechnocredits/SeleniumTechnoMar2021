package amrutaM.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amrutaM.base.PredefinedActions;

/*TC#5
	JS Prompt
	- click JS Prompt
	- switch to alert
	- enter name
	- from the message verify that "given name" is present.
*/
public class TC5_JSPrompt {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.out.println("STEP: Launching the browser");
		System.out.println("STEP: Navigating to automationbykrishna.com");
		driver = PredefinedActions.setUp();
		System.out.println("Clicking on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("STEP: Waiting for page to load");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='javascriptPromp']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("STEP : Scrolling the page so that JS Confirmation Box is visible ");
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println("Clicking on JS Prompt button ");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("Switching to Alert");
		Alert al = driver.switchTo().alert();
		System.out.println("Sending Amruta into alert box");
		al.sendKeys("Amruta");
		al.getText().contains("Amruta");
		System.out.println("Accepting the alert!");
		al.accept();
		
		
		
	}

}
