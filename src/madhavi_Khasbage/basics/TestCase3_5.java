package madhavi_Khasbage.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MadhaviKhasbage.basic.PredefinedActions;

/*Test case 3_5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
*/

public class TestCase3_5 {

	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "http://automationbykrishna.com/index.html#";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();	

		System.out.println("STEP1:Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("javascriptPromp")));

		System.out.println("STEP2:JS Prompt");
		driver.findElement(By.id("javascriptPromp")).click();

		Thread.sleep(2000);
		System.out.println("STEP3:enter name");
		Alert alert = driver.switchTo().alert();
		String name = "madhavi";
		alert.sendKeys(name);
		alert.accept();
		System.out.println("STEP4:from the message verify that " + name + " is present.");
		String alertConfText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (alertConfText.contains(name)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

}
