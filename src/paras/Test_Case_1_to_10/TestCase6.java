/*
 Reference URL
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
 
Problem Statements :
1. How many total entries are there in table?
2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
3. Print Employee First Name of all employees working from London Office.
4. Find all Employees who hold Position as Software Engineer.
5. COunt number of Employee with age More than 25, on first page.
6. Print Employee Start date whose age is 66.
7. Print employee Age whose salary is minimum. 
8. How many rows in Table on first page.
9. Print all text in table
 */
package paras.Test_Case_1_to_10;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();

		System.out.println("Case 1. How many total entries are there in table?");
		String paginationText = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] paginationarr = paginationText.split("of");
		System.out.println("Total Entries in table : " + paginationarr[1].replace(" entries", ""));

		System.out.println(
				"\nCase 2. On Dynamic table - check age of Employee \"Caesar Vancee\" - write Dynamic Xpath - Print Age");
		String employeeName = "Caesar Vance";
		WebElement ageofEmployee = driver.findElement(
				By.xpath("//table[@id='example']//tr//td[text()='" + employeeName + "']//following-sibling::td[3]"));
		String employeeAge = ageofEmployee.getText();
		System.out.println(employeeName + "age is : " + employeeAge);

		System.out.println("\nCase 3. Print Employee First Name of all employees working from London Office.");
		List<WebElement> londonEmployeeList = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[text()='London']//ancestor::tr//td[1]"));
		for (WebElement londonEmployee : londonEmployeeList) {
			System.out.println("Employees working from London Office : " + londonEmployee.getText());
		}

		System.out.println("\nCase 4. Find all Employees who hold Position as Software Engineer.");
		List<WebElement> softwareEnginerEmployeeList = driver.findElements(
				By.xpath("//table[@id=\"example\"]//tr//td[text() = 'Software Engineer']//ancestor::tr//td[1]"));
		for (WebElement softwareEnginerEmployee : softwareEnginerEmployeeList) {
			System.out.println(
					"Employees who hold Position as Software Engineer :  " + softwareEnginerEmployee.getText());
		}

		System.out.println("\nCase 5. Count number of Employee with age More than 25, on first page.");
		List<WebElement> employeeList = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]//ancestor::tr//td[1]"));
		for (WebElement listOfEmployee : employeeList) {
			System.out.println("Employee with age More than 25 : " + listOfEmployee.getText());
		}

		System.out.println("\nCase 6. Print Employee Start date whose age is 66.");
		List<WebElement> employeeList1 = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[4][text()=66]//following-sibling::td[1]"));
		for (WebElement listOfEmployee1 : employeeList1) {
			System.out.println("Employee Start date whose age is 66 : " + listOfEmployee1.getText());
		}

		/*
		 * System.out.println(
		 * "\nCase 7.  Print employee Age whose salary is minimum."); List<WebElement>
		 * employeeAgeList=
		 * driver.findElements(By.xpath("//table[@id='example']//tr/td[4]"));
		 * employeeAgeList.sort(new Comparator()); employeeAgeList.get(0).getText();
		 * System.out.println("Salary Whose Age is Min :"+driver.findElement(By.xpath(
		 * "//table[@id='example']//tr/td[text()='"+employeeAgeList.get(0).getText()+
		 * "']//following-sibling::td[2]")).getText());
		 */

		System.out.println("\nCase 8. How many rows in Table on first page.");
		System.out.println("Rows on first page in Table : "
				+ driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());

		System.out.println("\nCase 9. Print all text in table.");
		System.out.println("\nAll text in table : " + driver.findElement(By.xpath("//table[@id='example']")).getText());
	}
}