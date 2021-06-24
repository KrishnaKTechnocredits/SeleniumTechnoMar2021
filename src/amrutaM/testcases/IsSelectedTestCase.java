package amrutaM.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import amrutaM.base.PredefinedActions;

/*
 *  3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
	
	Note: 1 & 2 perform on HTML which is shared
*/
public class IsSelectedTestCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.setUp();
		System.out.println("STEP: Navigating to Registration Page");
		driver.findElement(By.linkText("Registration")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP: Varifying if the REGISTRATION ");
		driver.findElement(By.xpath("//a[@id='registration2']")).isDisplayed();
		System.out.println("Verifying if male radio button is selected or not");
		boolean maleSelected = driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected();
		if(maleSelected) {
			System.out.println("PASS - Male is selected so now selecting Female ");
			boolean femaleSelected = driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected();
			if(!femaleSelected)
				driver.findElement(By.xpath("//input[@id='radio-02']")).click();
			
		}else
			System.out.println("FAIL - Male is not selected");
		PredefinedActions.tearDown();
	}
}
