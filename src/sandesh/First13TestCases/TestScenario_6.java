/*
 * visit site - "https://datatables.net/extensions/autofill/examples/initialisation/focus.html" and 
 * complete assignments
 * 
 * Problem Statements :
1. How many total entries are there in table? -- DONE
2. On Dynamic table - check age of Employee "Caesar Vance" - write Dynamic Xpath - Print Age -- DONE
3. Print Employee First Name of all employees working from London Office. -- DONE
4. Find all Employees who hold Position as Software Engineer. -- DONE
5. Count number of Employee with age More than 25, on first page. 
6. Print Employee Start date whose age is 66.
7. Print employee Age whose salary is minimum. 
8. How many rows in Table on first page.
9. Print all text in table 
 */

package sandesh.First13TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='DataTables']")));
		String stringOfEntries = driver.findElement(By.id("example_info")).getText();
		String[] strArray = stringOfEntries.split(" ");
		String entriesString = strArray[strArray.length - 2];
		int numberOfEntries = Integer.parseInt(entriesString);
		System.out.println("Total number of entries in table are -: " + numberOfEntries);
		System.out.println();

		// *****************Age of Caesar Vance******************//
		String stringAge = driver.findElement(By.xpath("//td[text()='Caesar Vance']//following-sibling::td[3]"))
				.getText();
		int ageCaesarVance = Integer.parseInt(stringAge);
		System.out.println("Age of Caesar Vance is -: " + ageCaesarVance);
		System.out.println();

		// *****************First Name of Employees working from London
		// office******************//
		List<WebElement> listOfFullNames = driver.findElements(By.xpath("//td[text()='London']//parent::tr//td[1]"));
		System.out.println("First name of employees working from London office -: ");
		for (WebElement eachName : listOfFullNames) {
			System.out.println(eachName.getText().split(" ")[eachName.getText().split(" ").length - 2]);
		}
		System.out.println();

		// *****************Find all Employees who hold Position as Software
		// Engineer.******************//
		List<WebElement> listOfEmployeesSE = driver
				.findElements(By.xpath("//td[text()='Software Engineer']//parent::tr//td[1]"));
		System.out.println("List of Employees who hold position of Software Engineer");
		for (WebElement eachEmployee : listOfEmployeesSE) {
			System.out.println(eachEmployee.getText());
		}
		System.out.println();

		// *****************Count number of Employee with age More than 25, on first
		// page.******************//
		List<WebElement> listOfEmployeesAgeMore = driver.findElements(By.xpath("//td[text()>25]"));
		System.out.println("Total number of employees whose age is more than 25 is -: ");
		System.out.println(listOfEmployeesAgeMore.size());
		System.out.println();

		// *****************Print Employee Start date whose age is
		// 66.******************//
		System.out.println("Start date of employee whose age is 66 is -: ");
		System.out.println(driver.findElement(By.xpath("//td[text()=66]//following-sibling::td[1]")).getText());
		System.out.println();

		// *****************Print employee Age whose salary is
		// minimum.******************//
		List<WebElement> listOfSalaries = driver.findElements(By.xpath("//td[6]"));
		List<WebElement> listOfAge = driver.findElements(By.xpath("//td[4]"));
		ArrayList<Integer> listOfSalariesInt = new ArrayList<Integer>();
		ArrayList<Integer> listOfAgeInt = new ArrayList<Integer>();

		for (WebElement salary : listOfSalaries) {
			int eachSalaryInt = Integer
					.parseInt(salary.getText().substring(1, salary.getText().length() - 1).replaceAll(",", ""));
			listOfSalariesInt.add(eachSalaryInt);
		}

		for (WebElement ageElement : listOfAge) {
			int eachAgeInt = Integer.parseInt(ageElement.getText());
			listOfAgeInt.add(eachAgeInt);
		}

		TreeMap<Integer, Integer> mapOfSalaryAge = new TreeMap<Integer, Integer>();
		for (int index = 0; index < listOfSalariesInt.size(); index++) {
			mapOfSalaryAge.put(listOfSalariesInt.get(index), listOfAgeInt.get(index));
		}

		System.out.println("Employee's age having minimum salaray is -: ");
		System.out.println(mapOfSalaryAge.get(mapOfSalaryAge.firstKey()));
		System.out.println();

		// *****************How many rows in Table on first page.******************//
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
		System.out.println("Total number of rows in first table are -: ");
		System.out.println(listOfRows.size());
		System.out.println();

		// *****************Print all text in table******************//
		System.out.println("Print all text from first table");
		System.out.println(driver.findElement(By.id("example")).getText());
		System.out.println();
	}
}
