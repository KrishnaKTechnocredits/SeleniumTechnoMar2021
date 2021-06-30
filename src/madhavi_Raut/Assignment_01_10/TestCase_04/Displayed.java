package madhavi_Raut.Assignment_01_10.TestCase_04;
//1. validate visible button functionality click on button and validate button is displayed or not and vice versa

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Displayed {

	void isDisplayed() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/JavaSeleniumBatch/Study%20Material/Selenium/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("visibleAndHidden")).click();
		System.out.println("STEP - TO Verify whether block is visible or not");
		if (driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed()) {
			System.out.println("Block is visible");
			driver.findElement(By.id("visibleAndHidden")).click();
		} else {
			System.out.println("Block is not visible");
			driver.findElement(By.id("visibleAndHidden")).click();
		}
		driver.close();
	}

	public static void main(String[] args) {
		new Displayed().isDisplayed();
	}
}
