package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_12;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2*/
public class FindCountOfEmpUnderManager {

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
	void getCountOfEmpUnderManager() {
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, Integer> empCountUnderManager = new HashMap<String, Integer>();
		HashMap<String, Integer> originalEmpCountUnderManager = new HashMap<String, Integer>();
		originalEmpCountUnderManager.put("20209", 3);
		originalEmpCountUnderManager.put("20205", 4);
		originalEmpCountUnderManager.put("10101", 2);

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		List<WebElement> managerList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		System.out.println("STEP - Collecting count of employee working under Manager.");

		for (WebElement manager : managerList) {
			String managerId = manager.getText();
			if (empCountUnderManager.containsKey(managerId)) {
				empCountUnderManager.put(managerId, empCountUnderManager.get(managerId) + 1);
			} else
				empCountUnderManager.put(managerId, 1);
		}
		System.out.println(originalEmpCountUnderManager);
		System.out.println(empCountUnderManager);
		Assert.assertEquals(empCountUnderManager, originalEmpCountUnderManager,
				"Emp Count Under Manager Info mismatched");
	}
}
