package priyanka_Panat.TestCases1_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC6 {
	static WebDriver driver;

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		return driver;
	}

	static void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	// 1. How many total entries are there in table?
	void getTotalEntriesInTable() {
		System.out.println("Program Statement: Finding total entries.");
		System.out.println("STEP: Navigating to website.");
		driver = TC6.start();
		System.out.println("STEP: Capturing the details");
		String entriesStr = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] entriesArray = entriesStr.split("of ");
		String strEntries = "";
		for (int index = 1; index < entriesArray.length; index++) {
			strEntries = entriesArray[index];
		}
		strEntries = strEntries.replace(" entries", "");
		System.out.println("STEP: Print total no. of entries");
		System.out.println("Total number of entries: " + Integer.parseInt(strEntries));
		TC6.tearDown();
	}

	// 2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic
	// Xpath - Print Age
	void printAgeOfEmployee(String empName) {
		System.out.println("\nProgram Statement: Find Employee Age");
		System.out.println("STEP: Navigating to website");
		driver = TC6.start();
		System.out.println("STEP: Printing Employee age");
		String empAge = driver
				.findElement(By.xpath(
						"//table[@id='example']/tbody/tr/td[text()='" + empName + "']//following-sibling::td[3]"))
				.getText();
		System.out.println("Employee " + empName + " age: " + empAge);
		TC6.tearDown();
	}

	// 3. Print Employee First Name of all employees working from London Office.
	void printFNameOfEmployee(String empCity) {
		driver = TC6.start();
		List<WebElement> empNameList = driver.findElements(
				By.xpath("//table[@id='example']//tr//td[text()='" + empCity + "']//ancestor::tr//td[1]"));
		for (WebElement empLondonName : empNameList) {
			System.out.println(empLondonName.getText() + " Lives in London");

		}
		TC6.tearDown();
	}

	// 4. Find all Employees who hold Position as Software Engineer.
	void getEmpNameWorkingAs(String designation) {
		driver = TC6.start();
		List<WebElement> empNameSEList = driver.findElements(
				By.xpath("//table[@id='example']//tr//td[text()='" + designation + "']//ancestor::tr//td[1]"));
		for (WebElement emp : empNameSEList) {
			System.out.println(emp.getText() + " is a Software Engineer");

		}
		TC6.tearDown();
	}

	// 5. COunt number of Employee with age More than 25, on first page.
	void getAgeGreaterThan() {
		driver = TC6.start();
		int result = driver.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]")).size();
		System.out.println("Number of Employee with Age more than 25 :" + result);

		List<WebElement> empAgeMoreThan25Names = driver
				.findElements(By.xpath("//table[@id='example']//tr//td[4][text()>25]//ancestor::tr//td[1]"));
		for (WebElement empMoreThan25Age : empAgeMoreThan25Names) {
			System.out.println(empMoreThan25Age.getText() + " Age is 25+ Year");
		}
		TC6.tearDown();
	}

	// 6. Print Employee Start date whose age is 66.
	void getStartDateOfParticularAge(int age) {
		driver = TC6.start();
		System.out.println("Employee start date whose age is 66 :" + driver
				.findElement(
						By.xpath("//table[@id='example']//tr//td[4][text()='" + age + "']//following-sibling::td[1]"))
				.getText());
		TC6.tearDown();
	}

	// 7. Print employee Age whose salary is minimum.
	void getEmpAgeOfMinSalary() {
		driver = TC6.start();
		List<WebElement> elementOfSalary = driver.findElements(By.xpath("//table[@id='example']//tr//td[6]"));
		ArrayList<String> listOfSalary = new ArrayList<String>();
		for (WebElement e : elementOfSalary) {
			listOfSalary.add(e.getText().replace("$", "").replace(",", ""));

		}
		ArrayList<Integer> salaryList = new ArrayList<Integer>();
		for (String str : listOfSalary) {
			salaryList.add(Integer.valueOf(str));
		}
		Collections.sort(salaryList);
		int empMinSalary = salaryList.get(0);
		int empAge = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]//preceding-sibling::td[2]")).getText());
		System.out.println("Employee age who is having minimum salary " + empMinSalary + " is: " + empAge);
		TC6.tearDown();
	}

	// 8. How many rows in Table on first page.
	void getRowCount() {
		driver = TC6.start();
		System.out.println(
				"No of records in table :" + driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size());
		TC6.tearDown();
	}

	// 9. Print all text in table. - on automation by Krishna
	void printTableText() {
		driver = TC6.start();
		System.out.println("Text of Whole table :" + driver.findElement(By.xpath("//table[@id='example']")).getText());
		TC6.tearDown();
	}

	public static void main(String[] args) {
		TC6 webTableDetails = new TC6();
		webTableDetails.getTotalEntriesInTable();
		webTableDetails.printAgeOfEmployee("Caesar Vance");
		webTableDetails.printFNameOfEmployee("London");
		webTableDetails.getEmpNameWorkingAs("Software Engineer");
		webTableDetails.getAgeGreaterThan();
		webTableDetails.getStartDateOfParticularAge(66);
		webTableDetails.getEmpAgeOfMinSalary();
		webTableDetails.getRowCount();
		webTableDetails.printTableText();
	}
}
