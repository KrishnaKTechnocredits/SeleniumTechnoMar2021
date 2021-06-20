/*
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

package upasana.testCases;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class TestCase6 {

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arr = text.split("of");
		String[] str = arr[1].trim().split(" ");
		System.out.println("\n" + str[0] + "\n");

		// -------------------------------------------------------------------------------------

		String age = driver
				.findElement(
						By.xpath("//table[@id='example']/tbody/tr/td[text()='Caesar Vance']/following-sibling::td[3]"))
				.getText();
		System.out.println("age is " + Integer.parseInt(age) + "\n");

		// --------------------------------------------------------------------

		List<WebElement> list = driver.findElements(
				By.xpath("//table[@id='example']/tbody/tr/td[3][text()='London']/preceding-sibling::td[2]"));
		for (WebElement emp : list) {
			System.out.println(emp.getText());
		}
		System.out.println();

		// ----------------------------------------------------------------------

		List<WebElement> list1 = driver.findElements(
				By.xpath("//table[@id='example']/tbody/tr/td[2][text()='Software Engineer']/preceding-sibling::td[1]"));
		for (WebElement emp : list1) {
			System.out.println(emp.getText());
		}
		System.out.println();

		// ----------------------------------------------------------------------

		List<WebElement> list2 = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4][text()>'25']/preceding-sibling::td[3]"));
		for (WebElement emp : list2) {
			System.out.println(emp.getText());
		}
		System.out.println();

		// ----------------------------------------------------------------------

		List<WebElement> list3 = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4][text()='66']/following-sibling::td[1]"));
		for (WebElement emp : list3) {
			System.out.println(emp.getText());
		}
		System.out.println();

		// ----------------------------------------------------------------------

		List<WebElement> list4 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		ArrayList<String> salSet = new ArrayList<String>();

		for (WebElement emp : list4) {
			salSet.add(emp.getText());
		}
		Collections.sort(salSet);

		int minAge = Integer.parseInt(salSet.get(0));
		System.out.println(driver
				.findElement(By
						.xpath("//table[@id='example']/tbody/tr/td[text()='" + minAge + "']/preceding-sibling::td[3]"))
				.getText());
		System.out.println();

		// ----------------------------------------------------------------------
		System.out.println(driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());
		System.out.println();

		// ----------------------------------------------------------------------
		System.out.println(driver.findElement(By.xpath("//table[@id='example']/tbody")).getText());
		
		driver.close();
	}
}