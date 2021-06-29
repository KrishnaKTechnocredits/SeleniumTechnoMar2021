package simmi.TestCase_6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC#6
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
Reference URL
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
*/

public class TestCase6 {
	static int getTotalEntries(WebDriver driver) {
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();

		String[] arr = text.split("of");
		String temp = arr[1].trim().replace(" entries", "");
		return Integer.parseInt(temp);

	}

	static int getAgeOfEmployee(WebDriver driver) {
		String text = driver
				.findElement(
						By.xpath("//table[@id='example']//tr//td[text()='Caesar Vance']//following-sibling::td[3]"))
				.getText();
		return Integer.parseInt(text);
	}

	public static void main(String[] args) {
		String url = "https://datatables.net/extensions/autofill/examples/initialisation/focus.html";

		System.out.println("STEP 1 - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		/* 1. How many total entries are there in table */

		int entries = getTotalEntries(driver);
		System.out.println("Total entries are there in table are " + entries);
		System.out.println();

		/*
		 * 2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic
		 * Xpath - Print Age
		 */

		int age = getAgeOfEmployee(driver);
		System.out.println("Age of Employee Vaesar Vance is " + age);
		System.out.println();

		/* 3. Print Employee First Name of all employees working from London Office. */

		List<WebElement> empNameList = driver.findElements(
				By.xpath("//table[@id='example']/tbody/tr/td[3][text()='London']/preceding-sibling::td[2]"));
		for (WebElement emp : empNameList) {
			System.out.println("Name of Employees working from London Office are " + emp.getText());
		}
		System.out.println();

		/* 4. Find all Employees who hold Position as Software Engineer. */

		List<WebElement> empNameSoftwareList = driver.findElements(
				By.xpath("//table[@id='example']//tr//td[text()='Software Engineer']//ancestor::tr//td[1]"));
		for (WebElement emp : empNameSoftwareList) {
			System.out.println("Name of Employees working as Software Engineers are " + emp.getText());
		}
		System.out.println();

		/* 5. COunt number of Employee with age More than 25, on first page. */

		List<WebElement> numberOfEmployee = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4][text()>'25']"));

		System.out.println("Number of Employees whose age is more than 25 years are " + numberOfEmployee.size());
		System.out.println();

		/* 6. Print Employee Start date whose age is 66. */

		System.out.println("Start date of Employee whose age is 66 is " + driver
				.findElement(By.xpath("//table[@id='example']/tbody/tr/td[4][text()='66']/following-sibling::td[1]"))
				.getText());
		System.out.println();

		/* 8. How many rows in Table on first page. */

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		System.out.println(totalRows.size());
		System.out.println();

		/* 9. Print all text in table */

		System.out.println(driver.findElement(By.xpath("//table[@id='example']/tbody")).getText());
		driver.close();
	}
}
