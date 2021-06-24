package madhavi_Khasbage.basics;
/*1. How many total entries are there in table?
2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
3. Print Employee First Name of all employees working from London Office.
4. Find all Employees who hold Position as Software Engineer.
5. COunt number of Employee with age More than 25, on first page.
6. Print Employee Start date whose age is 66.
7. Print employee Age whose salary is minimum. 
8. How many rows in Table on first page.
9. Print all text in table
Reference URL
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MadhaviKhasbage.basic.PredefinedActions;

public class TestCase3_6 {

	public static void main(String[] args) throws InterruptedException {

		TestCase3_6.getTotalEntries();

		TestCase3_6.getAgeOfEmployee("Bruno Nash");

		TestCase3_6.getEmployeeName("London");

		TestCase3_6.getSoftwareEngineers("Software Engineer");

		TestCase3_6.getCountOfEmployees(25);

		TestCase3_6.geEmployeeStartDate(66);

		TestCase3_6.geEmployeeAgeOfMinSalary();
		
		TestCase3_6.geTotalRowsOnFirstPage();
		
		TestCase3_6.printAllTextInTable();
	}

	static void getTotalEntries() {
		System.out.println("How many total entries are there in table?");
		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();

		String size = driver.findElement(By.xpath("//div[@id='example_info']")).getText();

		String[] arr = size.split("of ");
		String totalEntries = " ";
		for (int index = 0; index < arr.length; index++) {
			String str = arr[index];
			if (str.contains("entries")) {
				totalEntries = str.replace(" entries", " ");
				totalEntries = totalEntries.trim();
			}
		}

		System.out.println("Total entries in the table are >> " + totalEntries);

		System.out.println("Close browser");
		driver.close();

	}

	static void getAgeOfEmployee(String strName) {
		System.out.println("Find Employee Age");
		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();

		System.out.println("STEP: Printing Employee age");
		String empAge = driver
				.findElement(By.xpath(
						"//table[@id='example']/tbody/tr/td[text()='" + strName + "']//following-sibling::td[3]"))
				.getText();
		System.out.println("Employee " + strName + " age: " + empAge);
		System.out.println("Close browser");
		driver.close();
	}

	static void getEmployeeName(String officeName) {
		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		ArrayList<String> empFirstNameList = new ArrayList<String>();
		int pageNum = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		System.out.println("STEP2: Get employee name");
		for (int index = 1; index <= pageNum; index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(By.xpath(
					"//table[@id='example']/tbody/tr/td[3][text()='" + officeName + "']//preceding-sibling::td[2]"));
			for (WebElement webElement : empList) {
				empFirstNameList.add(webElement.getText());
			}
		}
		System.out.println("Below are the employees working from London Office.");
		System.out.println(empFirstNameList);
		System.out.println("STEP3: Close");
		driver.close();
	}

	static void getSoftwareEngineers(String targetPosition) {
		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		ArrayList<String> empFirstNameList = new ArrayList<String>();
		int pageNum = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		System.out.println("STEP2: Get employee name");
		for (int index = 1; index <= pageNum; index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2][text()='"
					+ targetPosition + "']//preceding-sibling::td[1]"));
			for (WebElement webElement : empList) {
				empFirstNameList.add(webElement.getText());
			}
		}
		System.out.println("Below are the Employees who hold Position as Software Engineer.");
		System.out.println(empFirstNameList);
		System.out.println("STEP3: Close");
		driver.close();
	}

	static void getCountOfEmployees(int age) {
		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();

		System.out.println("STEP2: Find employee age and compare");
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int totalEmp = element.size();
		int empcnt = 0;
		for (int index = 1; index <= totalEmp; index++) {
			int empAge = Integer.parseInt(
					driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
			if (empAge > 25) {
				empcnt++;
			}
		}

		System.out.println("Total number of Employee with age More than 25:" + empcnt);
		System.out.println("Close browser");
		driver.close();
	}

	static void geEmployeeStartDate(int age) {

		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		ArrayList<String> empStartDateList = new ArrayList<String>();
		int pageNum = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		System.out.println("STEP2: Get employee start date");
		for (int index = 1; index <= pageNum; index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(
					By.xpath("//table[@id='example']/tbody/tr/td[4][text()='66']/following-sibling::td[1]"));

			for (WebElement webElement : empList) {
				empStartDateList.add(webElement.getText());
			}
		}
		System.out.println("Below are the Employees's Start date whose age is 66.");
		System.out.println(empStartDateList);
		System.out.println("STEP3: Close");
		driver.close();
	}

	static void geEmployeeAgeOfMinSalary() {

		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		System.out.println("STEP2: Get employee salary and age");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[6]")).click();
		String empSalary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]")).getText();
		int empAge = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]//preceding-sibling::td[2]")).getText());
		System.out.println("Employee age who is having minimum salary " + empSalary + " is: " + empAge);

		System.out.println("STEP3: Close");
		driver.close();
	}

	static void geTotalRowsOnFirstPage() {

		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		System.out.println("STEP3: Get table rows on first page");
		List<WebElement> empList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

		System.out.println("Total rows in Table on first page >>" + empList.size());
		System.out.println("STEP3: Close");
		driver.close();
	}

	static void printAllTextInTable() {

		System.out.println("STEP1: Open URL");
		String expectedURL = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);

		int pageNum = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		System.out.println("STEP2: Get rows on every page and print it.");
		for (int index = 1; index <= pageNum; index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

			for (WebElement webElement : empList) {
				System.out.println(webElement.getText());
			}
		}
		System.out.println("STEP3: Close");
		driver.close();
	}
}
