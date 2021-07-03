package madhavi_Khasbage.Assignment_14;

import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase11_2 {
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
		System.out.println("Step4: Close browser");
		driver.close();
	}

	@Test
	public void getTotalManager(){
		
		System.out.println("Step2:Click on tab");
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("Step3:Get unique manager");
		TreeSet<String> managerSet = new TreeSet<String>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();

		for (int index = 1; index < totalRows; index++) {
			managerSet.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]//td[4]"))
					.getText());
		}

		System.out.println("Total manager count >> " + managerSet.size());		
		
	}	
}
