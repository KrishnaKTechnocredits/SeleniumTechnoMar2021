/*Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8*/

package simmi.TestCase14;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase11NG {

	static HashMap<String, Integer> getDepartmentDetails(WebDriver driver) {
		int deptCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		HashMap<String, Integer> mapOfDepts = new HashMap<String, Integer>();
		for (int index = 1; index <= deptCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (mapOfDepts.containsKey(deptName)) {
				mapOfDepts.put(deptName, mapOfDepts.get(deptName) + 1);
			} else {
				mapOfDepts.put(deptName, 1);
			}
		}
		return mapOfDepts;
	}

	static HashMap<String, Integer> getManagerDetails(WebDriver driver) {
		int totManager = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		HashMap<String, Integer> managerMap = new HashMap<String, Integer>();
		for (int index = 1; index <= totManager; index++) {
			String managerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (managerMap.containsKey(managerID))
				managerMap.put(managerID, managerMap.get(managerID) + 1);
			else
				managerMap.put(managerID, 1);
		}
		return managerMap;
	}

	static HashMap<String, Integer> getEmplyeeDetails(WebDriver driver) {
		int empCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		HashMap<String, Integer> empIDMap = new HashMap<String, Integer>();
		for (int index = 1; index <= empCount; index++) {
			String empID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (empIDMap.containsKey(empID))
				empIDMap.put(empID, empIDMap.get(empID) + 1);
			else
				empIDMap.put(empID, 1);
		}
		return empIDMap;
	}

	@Test
	public void operation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - OPEN DEMOTABLE PAGE ");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		HashMap<String, Integer> getDept = getDepartmentDetails(driver);
		System.out.println("Number of Departments we have are " + getDept);

		HashMap<String, Integer> managerCount = getManagerDetails(driver);
		System.out.println("Number of Managers are " + managerCount);

		HashMap<String, Integer> employeeCount = getEmplyeeDetails(driver);
		System.out.println("Number of Employees are " + employeeCount);

		driver.close();
	}
}
