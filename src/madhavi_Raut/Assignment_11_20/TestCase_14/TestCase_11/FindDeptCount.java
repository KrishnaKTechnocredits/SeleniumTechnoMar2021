package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_11;

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

//How many dept we have -> 4
public class FindDeptCount {
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
	void getDeptCount() {
		driver.findElement(By.id("demotable")).click();
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		driver.findElement(By.xpath("//div[@id='empmanager']"));
		HashSet<String> deptList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of dept present");
		for (int index = 1; index <= rowCount; index++) {
			deptList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[5]")).getText());
		}
		Assert.assertEquals(4, deptList.size(), "Dept count mismatched");
	}
}
