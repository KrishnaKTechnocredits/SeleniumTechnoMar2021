package madhavi_Khasbage.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import madhavi_Khasbage.base.PredefinedActions;

/*Task for today  
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa
3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
Note: 1 & 2 perform on HTML which is shared
*/

public class TestCase4 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "file:///C:/Users/madha/Downloads/Krishna%20Requirement.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("madhavi");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		boolean isEnabled = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println("Button enabled:" + isEnabled);

		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		isEnabled = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println("Button enabled:" +isEnabled);
		
	}
}
