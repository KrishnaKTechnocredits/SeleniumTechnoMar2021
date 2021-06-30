package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;

public class EnableAndDisableButton_TestCase5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("E:\\JAVA Selenium\\Selenium\\Krishna Requirement.html");
		boolean enable = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("radha");
		System.out.println(enable);
		if(enable)	
			System.out.println("Name field is enabled");
		else
			System.out.println("name field is disabled");
		Thread.sleep(2000);
		System.out.println("Click button");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		boolean isEnable = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println(isEnable);
		if(isEnable)
			System.out.println("Name field is enabled");
		else
			System.out.println("Name field is disabled");
		System.out.println("close browser");
		driver.close();
	}
}
