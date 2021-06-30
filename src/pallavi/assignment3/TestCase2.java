package pallavi.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pallavi.base.Predefined;

public class TestCase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Predefined.setUp("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.name("emailId")).sendKeys("Pallaviraj123@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("PallaviRaj123");
		driver.findElement(By.id("submitb2")).click();
		
		Alert alert= driver.switchTo().alert();
		
		String successMessage="You successfully clicked on it";
		String getActualmessage=alert.getText();
		
		if(successMessage.equals(getActualmessage)) {
			System.out.println("You successfully clicked on it");
		}else
			System.out.println("Failedd!!!");
		alert.accept();
		driver.close();
	}
}
