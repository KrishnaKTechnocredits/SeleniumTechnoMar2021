/*Test case - 12: 16th Jun'2021
program 1: employee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.

program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2
*/

package sandesh.First13TestCases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_12 {

	private HashMap<String, Integer> getCountAccordingly(WebDriver driver) {
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("demotable")).click();
		List<WebElement> listOfRows = driver
				.findElements(By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr/td[5]"));
		LinkedHashMap<String, Integer> mapOfDeptEmployeeCount = new LinkedHashMap<String, Integer>();
		LinkedHashSet<String> setOfEmpIDs = new LinkedHashSet<String>();
		for (int index = 1; index <= listOfRows.size(); index++) {
			if (setOfEmpIDs.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[2]"))
					.getText())) {
				if (mapOfDeptEmployeeCount.containsKey(driver
						.findElement(By.xpath(
								"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[5]"))
						.getText())) {
					mapOfDeptEmployeeCount.put(
							driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[5]"))
									.getText(),
							mapOfDeptEmployeeCount.get(driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[5]"))
									.getText()) + 1);
				} else
					mapOfDeptEmployeeCount.put(driver
							.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[5]"))
							.getText(), 1);
			}
		}
		return mapOfDeptEmployeeCount;
	}

	private HashMap<String, Integer> getCountEmpUnderEachMgr(WebDriver driver) {
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header[contains(text(),'Employee Manager')]")));
		// header[contains(text(),'Employee Manager')]/..//tbody/tr/td[4]
		// header[contains(text(),'Employee Manager')]/..//tbody/tr/td[2]
		HashSet<String> setOfEmpIDs = new HashSet<String>();
		LinkedHashMap<String, Integer> mapOfManagerEmpCount = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= driver
				.findElements(By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr")).size(); index++)
			if (setOfEmpIDs.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[2]"))
					.getText())) {
				if (mapOfManagerEmpCount.containsKey(driver
						.findElement(By.xpath(
								"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
						.getText())) {
					mapOfManagerEmpCount.put(
							driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
									.getText(),
							mapOfManagerEmpCount.get(driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
									.getText()) + 1);
				} else
					mapOfManagerEmpCount.put(driver
							.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
							.getText(), 1);
			}
		return mapOfManagerEmpCount;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		HashMap<String, Integer> mapOfDeptEmpCount = new TestScenario_12().getCountAccordingly(driver);
		HashMap<String, Integer> mapOfManagerEmpCount = new TestScenario_12().getCountEmpUnderEachMgr(driver);
		System.out.println("Count of Employees in each department is -: ");
		System.out.println(mapOfDeptEmpCount);
		System.out.println("Count of Employees under each manager is -: ");
		System.out.println(mapOfManagerEmpCount);
	}
}
