package amrutaM.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import amrutaM.base.PredefinedActions;

/*Test Case: 6
 * Problem Statements :
1. How many total entries are there in table?
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

public class TC6_DataTableExample {
	public static void main(String[] args) {
		String url = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";
		WebDriver driver = PredefinedActions.setUp(url);

		System.out.println("Fetching the total entries of the table");
		String entriesString = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] subString = entriesString.split("of ");
		System.out.println("Total number of records are = " + subString[1].substring(0, 2));
		System.out.println("-------------------------------------------------------------------");

		System.out.println("Fetching the age of Employee - Caesar Vance");
		System.out.println("Age of Caesar Vance is = " + driver
				.findElement(
						By.xpath("//table[@id='example']/tbody/tr/td[text()='Caesar Vance']/following-sibling::td[3]"))
				.getText());
		System.out.println("-------------------------------------------------------------------");

		System.out.println("All employees who are working from London Office.");
		List<WebElement> allLondonEmployees = driver.findElements(
				By.xpath("//table[@id='example']/tbody/tr/td[3][text()='London']/preceding-sibling::td[2]"));
		for (WebElement e : allLondonEmployees) {
			System.out.println(e.getText() + " lives in London");
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("All Employees who hold Position as Software Engineer");
		List<WebElement> allSoftwareEngg = driver.findElements(
				By.xpath("//table[@id='example']/tbody/tr/td[2][text()='Software Engineer']/preceding-sibling::td[1]"));

		for (WebElement e : allSoftwareEngg) {
			System.out.println(e.getText());
		}

		System.out.println("-------------------------------------------------------------------");
		// 5. COunt number of Employee with age More than 25, on first page.
		System.out.println(
				"Employees with age more than 25 are " + driver.findElements(By.xpath("//td[4][(text()>25)]")).size());
		System.out.println("-------------------------------------------------------------------");

		// 6. Print Employee Start date whose age is 66.
		System.out.println("Employee whose age is 66 years is: "
				+ driver.findElement(By.xpath("//td[4][(text()=66)]/preceding-sibling::td[3]")).getText());
		System.out.println("-------------------------------------------------------------------");
		// 7. Print employee Age whose salary is minimum.
		List<WebElement> allEmpSalary = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[6]"));
		String sal = allEmpSalary.get(0).getText();
		sal = sal.substring(1, sal.length());
		sal = sal.replaceAll(",", "");
		int min = Integer.parseInt(sal);
		System.out.println("Before for loop min value is " + min);
		for (int index = 1; index < allEmpSalary.size(); index++) {
			sal = allEmpSalary.get(index).getText();
			sal = sal.substring(1, sal.length());
			sal = sal.replaceAll(",", "");
			int min1 = Integer.parseInt(sal);
			if (min > min1) {
				min = min1;
				System.out.println("Minimum sal is " + min);
			}
		}
		System.out.println("-------------------------------------------------------------------");
		// 8. How many rows in Table on first page.
		System.out.println("Total number of rows in the table on the first page are: "
				+ driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());
		// 9. Print all text in table
		System.out.println(driver.findElement(By.xpath("//table[@id='example']")).getText());

		PredefinedActions.tearDown();
	}
}
