package madhavi_Raut.Assignment_01_10.TestCase_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Problem Statements :
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
public class WebTableDetails {
	static WebDriver driver;

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
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
	
	//1. How many total entries are there in table?
	void getTotalEntriesInTable() {
		System.out.println("Program Statement: Finding total entries.");
		System.out.println("STEP: Navigating to website.");
		driver = WebTableDetails.start();
		System.out.println("STEP: Capturing details from pagination label");
		String entriesStr = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] entriesArray = entriesStr.split("of ");
		String strEntries = "";
		for (int index = 1; index < entriesArray.length; index++) {
			strEntries = entriesArray[index];
		}
		strEntries = strEntries.replace(" entries", "");
		System.out.println("STEP: Print total no. of entries");
		System.out.println("Total number of entries: " + Integer.parseInt(strEntries));
		WebTableDetails.tearDown();
	}
	
	//2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic Xpath - Print Age
	void printAgeOfEmployee(String empName) {
		System.out.println("\nProgram Statement: Find Employee Age");
		System.out.println("STEP: Navigating to website");
		driver = WebTableDetails.start();
		System.out.println("STEP: Printing Employee age");
		String empAge = driver
				.findElement(By.xpath(
						"//table[@id='example']/tbody/tr/td[text()='" + empName + "']//following-sibling::td[3]"))
				.getText();
		System.out.println("Employee " + empName + " age: " + empAge);
		WebTableDetails.tearDown();
	}
	
	//3. Print Employee First Name of all employees working from London Office.
	void printFNameOfEmployee(String empCity) {
		driver = WebTableDetails.start();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> fNameList = new ArrayList<String>();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pageNumbers; index++) {
			System.out.println("STEP: On Page 0" + index);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empList = driver.findElements(By.xpath(
					"//table[@id='example']/tbody/tr/td[3][text()='" + empCity + "']//preceding-sibling::td[2]"));
			System.out.println("STEP: Collecting Employee Name");
			for (WebElement webElement : empList) {
				nameList.add(webElement.getText());
			}
		}
		Object[] namesArr = nameList.toArray();
		for (int innerIndex = 0; innerIndex < namesArr.length; innerIndex++) {
			fNameList.add(namesArr[innerIndex].toString().replaceAll("\\s[a-zA-Z]*", ""));
		}
		System.out.println("Below is the first name of Employee working at loaction: " + empCity + "\n" + fNameList);
		WebTableDetails.tearDown();
	}

	// 4. Find all Employees who hold Position as Software Engineer.
	void getEmpNameWorkingAs(String empPosition) {
		driver = WebTableDetails.start();
		ArrayList<String> nameList = new ArrayList<String>();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pageNumbers; index++) {
			System.out.println("STEP: On Page 0" + index);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empNameList = driver.findElements(By.xpath(
					"//table[@id='example']/tbody/tr/td[2][text()='" + empPosition + "']//preceding-sibling::td"));
			System.out.println("STEP: Collecting Employee Name working as " + empPosition);
			for (WebElement webElement : empNameList) {
				nameList.add(webElement.getText());
			}
		}
		System.out.println("Below are the Employee working as: " + empPosition + "\n" + nameList);
		WebTableDetails.tearDown();
	}

	// 5. Count number of Employee with age More than 25, on first page.
	void getAgeGreaterThan(int age, int pageIndex) {
		driver = WebTableDetails.start();
		System.out.println("STEP: On Page 0" + pageIndex);
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + pageIndex + "]")).click();
		System.out.println("STEP - Collecting count of Employee having age > 25");
		List<WebElement> empList = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4][text()>25]//preceding-sibling::td[3]"));
		System.out.println("Count of Employee with age nore than 25 on page " + pageIndex + " is: " + empList.size());
		WebTableDetails.tearDown();
	}

	// 6. Print Employee Start date whose age is 66.
	void getStartDateOfParticularAge(int age) {
		driver = WebTableDetails.start();
		ArrayList<String> nameList = new ArrayList<String>();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pageNumbers; index++) {
			System.out.println("STEP: On Page 0" + index);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empStartDateList = driver.findElements(
					By.xpath("//table[@id='example']/tbody/tr/td[4][text()='66']//following-sibling::td[1]"));
			System.out.println("STEP: Collecting Employee StartDate whose age is " + age);
			for (WebElement webElement : empStartDateList) {
				nameList.add(webElement.getText());
			}
		}
		System.out.println("Below are the Employee StartDate whose age is: " + age + "\n" + nameList);
		WebTableDetails.tearDown();
	}

	// 7. Print employee Age whose salary is minimum.
	void getEmpAgeOfMinSalary() {
		driver = WebTableDetails.start();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[6]")).click();
		String empMinSalary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]")).getText();
		int empAge = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]//preceding-sibling::td[2]")).getText());
		System.out.println("Employee age who is having minimum salary " + empMinSalary + " is: " + empAge);
		WebTableDetails.tearDown();
	}

	// 8. How many rows in Table on first page.
	void getRowCount(int pageIndex) {
		driver = WebTableDetails.start();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = pageIndex; index <= pageNumbers;) {
			System.out.println("STEP: On Page 0" + pageIndex);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + pageIndex + "]")).click();
			System.out.println("STEP - Gathering row count");
			List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
			System.out.println("Row count on page " + pageIndex + ": " + rowList.size());
			break;
		}
		WebTableDetails.tearDown();
	}

	// 9. Print all text in table
	void printTableText() {
		driver = WebTableDetails.start();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int pageIndex = 1; pageIndex <= pageNumbers; pageIndex++) {
			System.out.println("STEP: On Page 0" + pageIndex);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + pageIndex + "]")).click();
			System.out.println("STEP - Gathering row data");
			List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
			for (WebElement rowData : rowList) {
				System.out.println(rowData.getText());
			}
		}
		WebTableDetails.tearDown();
	}

	public static void main(String[] args) {
		WebTableDetails webTableDetails = new WebTableDetails();
		webTableDetails.getTotalEntriesInTable();
		webTableDetails.printAgeOfEmployee("Caesar Vance");
		webTableDetails.printFNameOfEmployee("London");
		webTableDetails.getEmpNameWorkingAs("Software Engineer");
		webTableDetails.getAgeGreaterThan(25, 1);
		webTableDetails.getStartDateOfParticularAge(66);
		webTableDetails.getEmpAgeOfMinSalary();
		webTableDetails.getRowCount(1);
		webTableDetails.printTableText();
	}
}
