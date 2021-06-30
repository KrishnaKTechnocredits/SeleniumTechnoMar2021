/*TestCase 13:

TestCase 15: 20th Jun'2021 
Perform Login Test using data provider on AutomationByKrishna -> Registration*/

package simmi.TestCase_15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase15 {

	@DataProvider(name = "loginDetailsProvider")
	public Object[][] loginDetailsProvider() {
		Object[][] data = new Object[3][3];

		data[0][0] = "simmi";
		data[0][1] = "simmi217";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "jessi";
		data[1][1] = "jessi2008";
		data[1][2] = "Success!";

		data[2][0] = "charlie";
		data[2][1] = "charlie2000";
		data[2][2] = "Success!";

		return data;
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

		driver.close();
	}
}
