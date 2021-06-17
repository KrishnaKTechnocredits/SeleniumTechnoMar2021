//validate enable button functionality click on button and validate button is disable or not and vice versa
package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateButtonFunctionality_TC7_2 {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("file:///C:/Users/Softcell/Downloads/Krishna%20Requirement.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//button[@id='visibleAndHidden']"));
		boolean status = element.isEnabled();
		System.out.println(status);
		element.click();
		status = element.isEnabled();
		System.out.println(status);
	}

}
