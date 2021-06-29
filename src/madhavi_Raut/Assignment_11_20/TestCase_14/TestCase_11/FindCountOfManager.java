package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_11;
//how many managers we have -> 3

import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindCountOfManager {
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
	void getManagerCount() {
		driver.findElement(By.id("demotable")).click();
		HashSet<String> ManagerList = new HashSet<String>();
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='table1']"))));

		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of Manager present");
		for (int index = 1; index <= rowCount; index++) {
			ManagerList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[4]")).getText());
		}
		Assert.assertEquals(3, ManagerList.size(), "Manager count mismatched");
	}
}
