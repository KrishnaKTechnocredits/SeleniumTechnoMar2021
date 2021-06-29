package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//3. validate isSelected on automationbykrishna's registration page if male radio button is selected 
//then click on female
public class Selected {
	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	void isSelected() {
		driver.findElement(By.id("registration2")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='unameSignin']"))));
		
		driver.findElement(By.id("radio-02")).click();
		System.out.println("STEP - To Verify which radio button is selected");
		Assert.assertEquals(driver.findElement(By.id("radio-02")).isSelected(), true,"Male radio button is selected.");
	}
}
