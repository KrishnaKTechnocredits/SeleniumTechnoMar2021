/*
1. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
 */
package paras.Test_Case_1_to_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4_1 {
	
	public void  isSelected(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(2500, TimeUnit.SECONDS);
		driver.findElement(By.id("registration2")).click();
		
		if(driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		}
		if(driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected()) 
			System.out.println("Female Selected : PASS ");
		else
			System.out.println("Female not selected : FAIL");
	}
	
	public static void main(String[] args) {
		TestCase4_1 testCase4 = new TestCase4_1();
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open automationbykrishna.com
		driver.get("http://automationbykrishna.com/");
		testCase4.isSelected(driver);
	}
}