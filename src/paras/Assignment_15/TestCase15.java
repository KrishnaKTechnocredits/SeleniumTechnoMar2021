/*
Test Case - 15 [20-06-2021]
Perform Login Test using data provider on AutomationByKrishna -> Registration
 */
package paras.Assignment_15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase15 {

	private static WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(1000);
	}

	@AfterMethod
	void End() {
		driver.close();
	}

	@Test(dataProvider = "loginDetailsProvider")
	public void registrationLogin(String uName, String pwd, String expectedAlertText) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("unameSignin")))).sendKeys(uName);

		driver.findElement(By.id("pwdSignin")).sendKeys(pwd);
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify Alert message");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		Assert.assertEquals(alert.getText(), expectedAlertText, "actualAlertText");
		alert.accept();

	}

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] loginDataProvider() {
		Object[][] data = new Object[3][3];

		data[0][0] = "Paras";
		data[0][1] = "Paras@123";
		data[0][2] = "Success!";

		data[1][0] = "kevin";
		data[1][1] = "kevin";
		data[1][2] = "Failed! please enter strong password";

		data[2][0] = "Akshay";
		data[2][1] = "Akshay@123";
		data[2][2] = "Success!";

		return data;

	}
}
