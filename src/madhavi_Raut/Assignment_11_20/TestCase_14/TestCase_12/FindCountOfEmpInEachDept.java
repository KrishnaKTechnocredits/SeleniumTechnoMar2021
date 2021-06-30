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

/*program 1: employee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.*/
public class FindCountOfEmpInEachDept {
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
	void findCountOfEmpInEachDept() {
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, Integer> deptInfo = new HashMap<String, Integer>();
		HashMap<String, Integer> originalDeptInfo = new HashMap<String, Integer>();
		originalDeptInfo.put("7001-Admin", 2);
		originalDeptInfo.put("7002-Finance", 2);
		originalDeptInfo.put("7003-HR", 2);
		originalDeptInfo.put("7013-IT", 3);

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		List<WebElement> deptList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		System.out.println("STEP - Collecting count of employee working in each dept.");

		for (WebElement dept : deptList) {
			String deptName = dept.getText();
			if (deptInfo.containsKey(deptName)) {
				deptInfo.put(deptName, deptInfo.get(deptName) + 1);
			} else {
				deptInfo.put(deptName, 1);
			}
		}
		Assert.assertEquals(deptInfo, originalDeptInfo, "Dept info mismatched");
	}
}
