package simmi.TestCase_11;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8*/

public class TestCase11 {

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
		int ManagerCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		HashMap<String, Integer> mapOfManagers = new HashMap<String, Integer>();
		for (int index = 1; index <= ManagerCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (mapOfManagers.containsKey(deptName)) {
				mapOfManagers.put(deptName, mapOfManagers.get(deptName) + 1);
			} else {
				mapOfManagers.put(deptName, 1);
			}
		}
		return mapOfManagers;
	}
	
	static HashMap<String, Integer> getEmployeeDetails(WebDriver driver) {
		int EmployeeCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		HashMap<String, Integer> mapOfEmployee = new HashMap<String, Integer>();
		for (int index = 1; index <= EmployeeCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]"))
					.getText();
			if (mapOfEmployee.containsKey(deptName)) {
				mapOfEmployee.put(deptName, mapOfEmployee.get(deptName) + 1);
			} else {
				mapOfEmployee.put(deptName, 1);
			}
		}
		return mapOfEmployee;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		HashMap<String, Integer> getDept = getDepartmentDetails(driver);
		System.out.println("Number of Departments we have are " + getDept);

		HashMap<String, Integer> getManager = getManagerDetails(driver);
		System.out.println("Number of Managers we have are " + getManager);
		
		HashMap<String, Integer> getEmployee = getEmployeeDetails(driver);
		System.out.println("Number of Employees we have are " + getEmployee);
		driver.close();
	}
}
