package madhavi_Khasbage.Assignment_14;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase12_1 {
	WebDriver driver;

	@BeforeTest
	void setUp() {
		System.out.println("Step1: Launch browser & hit AutomationByKrishna.com");
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
	public void getEmployeeCout() {
	
		System.out.println("Step2:Nevigate to Demo tables");
		driver.findElement(By.id("demotable")).click();

		System.out.println("Wait for demotable page to load");
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

	    System.out.println("Get unique department count");
		HashMap<String, Integer> empMap = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		
		for (int index = 1; index < rows; index++) {
			String strName = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[5]")).getText();
			if (!empMap.containsKey(strName)) {
				empMap.put(strName, 1);
			} else {				
				empMap.put(strName, empMap.get(strName)+1);
			}
		}

		System.out.println("Department and their employee count >>" + empMap);	
	}
}
