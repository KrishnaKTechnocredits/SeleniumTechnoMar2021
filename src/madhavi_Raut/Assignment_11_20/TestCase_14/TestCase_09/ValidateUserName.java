package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Test case : 9 - verify username from table "EMPLOYEE BASIC INFORMATION"
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateUserName {
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
	void validateUserName() {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("STEP - Verifying User Name");
		String empFname, empLname, empUserName;
		for (int index = 1; index <= rowCount; index++) {
			empFname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			empLname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
			empUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();
			Assert.assertEquals(empUserName, (empFname.substring(0, 1).toLowerCase() + empLname.toLowerCase()),
					"User Name mismatched for " + empUserName);
		}
	}
}
