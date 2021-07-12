package madhavi_Khasbage.basics;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.base.PredefinedActions;

/* Test case 8 >> Return a map of empId and empName */

public class TestCase8 {

	static void getempIdName() {
		System.out.println("STEP1: Open url on browser");
		String expectedURL = "http://automationbykrishna.com/";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("STEP2: Find table and rows");
		HashMap<String, String> empMap = new HashMap<String, String>();
		List<WebElement> element = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

		int size = element.size();
		System.out.println("STEP2: Find emp id and emp name");
		for (int index = 1; index <= size; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			empMap.put(empId, empName);
		}
		System.out.println(empMap);
		System.out.println("Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		TestCase8.getempIdName();
	}
}
