package upasana.testCase16;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase16 {

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] loginDetailsProvider() throws IOException {
		return ExcelOperation.readExcel("LoginData.xlsx", "Data");
	}

	@Test(dataProvider = "loginDetailsProvider")
	public void operation(String userName, String password, String expectedResult) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - OPEN REGISTRATION PAGE ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();

		System.out.println("");
		System.out.println("STEP - ENTER USERNAME ");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(userName);

		System.out.println("");
		System.out.println("STEP - ENTER PASSWORD ");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);

		System.out.println("");
		System.out.println("STEP - CLICK SUBMIT BUTTON ");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("VERIFY ALERT MESSAGE ");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();

		Assert.assertEquals(expectedResult, actualAlertText);
		alert.accept();

		driver.quit();

	}
}