//validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateButtonFunctionality_TC7_3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='registration2']")).click();
		WebElement element1 = driver.findElement(By.xpath("//input[@id='radio-01']"));
		boolean status = element1.isSelected();
		System.out.println(status);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element1);
		driver.findElement(By.xpath("//input[@id='radio-02']")).click();;
		
	}

}
