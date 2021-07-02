package pallavi.assignment15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {
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
	}

	@org.testng.annotations.DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		Object[][] data = new Object[3][3];
		data[0][0] = "pallavi";
		data[0][1] = "pallavi123";
		data[0][2] = "Success!";

		data[1][0] = "Simmi";
		data[1][1] = "simi123";
		data[1][2] = "Failed! please enter strong password";

		data[2][0] = "upasana";
		data[2][1] = "upasana123";
		data[2][2] = "Success!";

		return data;

	}
}
