package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"*/
public class LogIn {

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
	void logIn() {
		driver.findElement(By.id("registration2")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='login-wrap']"))));
		
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("madhaviraut");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Password@1");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP - Verifying Alert");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Success!", "Login Failed");
		alert.accept();
	}
}
