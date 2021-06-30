package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_04;
//1. validate visible button functionality click on button and validate button is displayed or not and vice versa

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Enabled {
	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("file:///D:/JavaSeleniumBatch/Study%20Material/Selenium/Krishna%20Requirement.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	void isEnabled() {
		driver.findElement(By.id("enableAndDisable")).click();
		System.out.println("STEP - TO Verify whether text box is visible or not");
		Assert.assertEquals(driver.findElement(By.id("myText")).isEnabled(), false, "Text box is Enabled.");
		driver.findElement(By.id("enableAndDisable")).click();
		Assert.assertEquals(driver.findElement(By.id("myText")).isEnabled(), true, "Text box is Disabled.");
	}
}
