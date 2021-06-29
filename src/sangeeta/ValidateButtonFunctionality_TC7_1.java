//validate visible button functionality click on button and validate button is displayed or not and vice versa
package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateButtonFunctionality_TC7_1 {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("file:///C:/Users/Softcell/Downloads/Krishna%20Requirement.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element1 = driver.findElement(By.xpath("//input[@id='myText']"));
		WebElement element2 = driver.findElement(By.xpath("//button[@id='enableAndDisable']"));
		boolean status1 = element1.isDisplayed();
		element1.sendKeys("Sangeeta");
		System.out.println(status1);
		element2.click();
		boolean status2 = element1.isDisplayed();
		element1.sendKeys("Kartik");
		System.out.println(status2);
	}

}
