package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase5_3 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("STEP 1 :- Click on Basic Element link");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		Thread.sleep(5000);
		System.out.println("Step 2: Click on JavaScript Promp");
		element.click();
		element.sendKeys("Sangeeta");
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

}
