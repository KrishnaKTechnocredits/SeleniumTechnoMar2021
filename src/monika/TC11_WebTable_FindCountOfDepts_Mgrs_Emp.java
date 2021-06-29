/*program 1: How many Depts we have.
ans : 4
program 2 : how many managers we have.
ans : 3
program 3: how many employees we have.
ans : 8
*/

package monika;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class TC11_WebTable_FindCountOfDepts_Mgrs_Emp {
	private static WebDriver driver;
	private static WebDriverWait wait;

	public static void startAndWaitOnDemoTable() {
		driver = PredefinedActions.start();
		System.out.println("STEP: Click on the demo table");
		wait = new WebDriverWait(driver, 2);
		WebElement demotableElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='demotable']")));
		demotableElement.click();
	}

	public static void uniqueCountOfDepts() {
		startAndWaitOnDemoTable();
		System.out.println("STEP: Identify the element");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr//td[5]"));
		LinkedHashSet<String> listOfDepts = new LinkedHashSet<String>();
		for (WebElement e : elements) {
			listOfDepts.add(e.getText());
		}
		System.out.println(listOfDepts.size());
		tearDown();
	}

	public static void uniqueCountOfManagers() {
		startAndWaitOnDemoTable();
		System.out.println("STEP: Identify the element");
		List<WebElement> elements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr//td[4]"));
		LinkedHashSet<String> listOfDepts = new LinkedHashSet<String>();
		for (WebElement e : elements) {
			listOfDepts.add(e.getText());
		}
		System.out.println(listOfDepts.size());
		tearDown();
	}

	public static void uniqueCountOfEmployees() {
		startAndWaitOnDemoTable();
		System.out.println("STEP: Identify the element");
		List<WebElement> elements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr//td[2]"));
		LinkedHashSet<String> listOfDepts = new LinkedHashSet<String>();
		for (WebElement e : elements) {
			listOfDepts.add(e.getText());
		}
		System.out.println(listOfDepts.size());
		tearDown();
	}

	public static void main(String[] args) {
		uniqueCountOfDepts();
		uniqueCountOfManagers();
		uniqueCountOfEmployees();
	}

	public static void tearDown() {
		driver.close();
	}
}
