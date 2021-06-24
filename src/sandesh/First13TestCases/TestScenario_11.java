/*Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8
*/

package sandesh.First13TestCases;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario_11 {

	private LinkedHashMap<String, Integer> getCountOfEach() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		LinkedHashMap<String, Integer> mapOfOutputs = new LinkedHashMap<String, Integer>();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> listOfRows = driver
				.findElements(By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr"));
		LinkedHashSet<String> setOfDepartments = new LinkedHashSet<String>();
		LinkedHashSet<String> setOfManagerIDs = new LinkedHashSet<String>();
		LinkedHashSet<String> setOfEmployeeIDs = new LinkedHashSet<String>();
		for (int index = 1; index <= listOfRows.size(); index++) {
			setOfDepartments.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[5]"))
					.getText());
			setOfManagerIDs.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
					.getText());
			setOfEmployeeIDs.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[2]"))
					.getText());
		}
		mapOfOutputs.put("Number of Departments", setOfDepartments.size());
		mapOfOutputs.put("Number of Managers", setOfManagerIDs.size());
		mapOfOutputs.put("Number of EBasicAssignment_12.javamployees", setOfEmployeeIDs.size());
		return mapOfOutputs;

	}

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> mapOfTable2 = new TestScenario_11().getCountOfEach();
		System.out.println("Details of Table 2 are - : ");
		System.out.println(mapOfTable2);
	}
}
