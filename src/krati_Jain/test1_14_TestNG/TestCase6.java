package krati_Jain.test1_14_TestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase6 {

	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	// 1. How many total entries are there in table?
	@Test
	public void problem1(WebDriver driver) {
		WebElement strElement = driver.findElement(By.xpath("//div[@id='example_info']"));
		String temp = strElement.getText();
		String[] str1 = temp.split("of");
		String str2 = str1[1];
		String str3 = str2.trim();
		String[] str4 = str3.split(" ");
		System.out.println("Total entries in the table are : " + str4[0]);
	}

	// 2. On Dynamic table - check age of Employee "Caesar Vance" - write Dynamic
	// Xpath - Print Age
	@Test
	public void problem2() {
		WebElement caeserAge = driver.findElement(By.xpath(
				"//div[@id='example_wrapper']//tbody/tr/td[1][text()='Caesar Vance']//following-sibling::td[3]"));
		System.out.println("Age of Caesar Vance is : " + caeserAge.getText());
	}

	// 3. Print Employee First Name of all employees working from London Office.
	@Test
	public void problem3() {
		List<WebElement> londonEmployees = driver.findElements(
				By.xpath("//div[@id='example_wrapper']//tbody/tr/td[text()='London']//preceding-sibling::td[2]"));
		System.out.println("Employees belong to London are : ");
		for (WebElement element : londonEmployees) {
			System.out.println(element.getText());
		}
	}

	// 4. Find all Employees who hold Position as Software Engineer.
	@Test
	public void problem4() {
		List<WebElement> softwareEngg = driver.findElements(By.xpath(
				"//div[@id='example_wrapper']//tbody/tr/td[2][text() = 'Software Engineer']//preceding-sibling::td[1]"));
		System.out.println("Employees who are Software Engineers are : ");
		for (WebElement element : softwareEngg) {
			System.out.println(element.getText());
		}
	}

	// 7. Print employee Age whose salary is minimum.
	@Test
	public void problem7() {
		List<Integer> listSalaries = new ArrayList<Integer>();
		List<WebElement> salary = driver.findElements(By.xpath("//div[@id='example_wrapper']//tbody//td[6]"));
		for (WebElement element : salary) {
			String temp = element.getText().replace('$', ' ').trim();
			String str = temp.replace(",", ""); // 162700
			int num = Integer.parseInt(str.trim());
			listSalaries.add(num);
		}
		TreeSet<Integer> sortedSalaries = new TreeSet<Integer>();
		for (int tempInt : listSalaries)
			sortedSalaries.add(tempInt);
		for (int allSalaries : sortedSalaries) {
			System.out.println("Minimum Salary : " + allSalaries);
			break;
		}
	}

	// 5. COunt number of Employee with age More than 25, on first page.
	@Test
	public void problem5() {
		int count = 0;
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='example_wrapper']//tbody//td[4]"));
		List<Integer> ageInInteger = new ArrayList<Integer>();
		for (WebElement element : list) {
			ageInInteger.add(Integer.parseInt(element.getText()));
		}
		for (int age : ageInInteger) {
			if (age > 25)
				count++;
		}
		System.out.println("Number of employees with age greater than 25 : " + count);
	}

	// 6. Print Employee Start date whose age is 66.
	@Test
	public void problem6() {
		WebElement startDate = driver
				.findElement(By.xpath("//div[@id='example_wrapper']//tbody//td[4][text() = 66]//parent::tr/td[5]"));
		System.out.println("Start Date of the employee who's age is 66 : " + startDate.getText());
		WebElement wholeTable = driver.findElement(By.xpath("//div[@id='example_wrapper']//tbody"));
		System.out.println(wholeTable.getText());
	}

	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}

}
