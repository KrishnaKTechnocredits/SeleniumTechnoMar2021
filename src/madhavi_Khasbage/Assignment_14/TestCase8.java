package madhavi_Khasbage.Assignment_14;

import java.util.List;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/* Test case 8 >> Return a map of empId and empName */

public class TestCase8 {
	
	WebDriver driver;
	
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		String expectedURL = "http://automationbykrishna.com/";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step3: Close browser");
		driver.close();
	}

	
	@Test
    void getempIdName() {
		System.out.println("STEP2: Click on demotable");	
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("STEP3: Find table and rows");
		HashMap<String, String> empMap = new HashMap<String, String>();
		List<WebElement> element = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

		System.out.println("STEP4: Find emp id and emp name");
		for (int index = 1; index <= element.size(); index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			empMap.put(empId, empName);
		}
		System.out.println(empMap);		
	}	
}
