package pallavi.assignment16;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {

	WebDriver driver;

	@BeforeMethod
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver", ".//resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
	}

	@Test(dataProvider = "loginData")
	public void registration(String uname, String password, String expectedResultText) {

		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("STEP- Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(uname);

		System.out.println("STEP- Enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);

		System.out.println("STEP- click on submit button");
		driver.findElement(By.xpath("//button[@type='submit'][@onclick='validatecredentials()']")).click();

		Alert alert = driver.switchTo().alert();
		String actulText = alert.getText();
		Assert.assertEquals(actulText, expectedResultText);

		alert.accept();
		driver.quit();
	}

	@org.testng.annotations.DataProvider(name = "loginData")
	public Object[][] loginDataProvider() throws IOException {
		Object data[][]=ExcelOperation.readExcel("Data.xlsx", "data");
		return data;

	}

}
