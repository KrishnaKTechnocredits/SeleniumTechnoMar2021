package madhavi_Raut.Assignment_11_20.TestCase_15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginUsingDataProvider {

	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("Closing the browser");
		driver.close();
	}

	@Test(dataProvider = "LoginCredentialsData")
	void logIn(String userID, String userPwd) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='unameSignin']"))))
				.sendKeys(userID);

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(userPwd);
		driver.findElement(By.id("btnsubmitdetails")).click();
		// Switch to alert
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(),"Success!", "Login Failed");
		alert.accept();
	}

	@DataProvider(name = "LoginCredentialsData")
	public Object[][] loginCredentials() {
		Object[][] data = new Object[2][2];
		data[0][0] = "madhaviraut";
		data[0][1] = "Password@1";
		data[1][0] = "mickeymouse";
		data[1][1] = "Password@2";
		return data;
	}
}
