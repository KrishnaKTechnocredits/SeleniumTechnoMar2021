package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver  = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	// 1. How many total entries are there in table?
	@Test
	void getTotalEntriesInTable() {
		System.out.println("Program Statement: Finding total entries.");
		System.out.println("STEP: Navigating to website.");
		// start();
		System.out.println("STEP: Capturing details from pagination label");
		String entriesStr = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] entriesArray = entriesStr.split("of ");
		String strEntries = "";
		for (int index = 1; index < entriesArray.length; index++) {
			strEntries = entriesArray[index];
		}
		strEntries = strEntries.replace(" entries", "");
		Assert.assertEquals( Integer.parseInt(strEntries), 57,"Incorrect entry details fetched.");
		}

	// 2. On Dynamic table - check age of Employee "Vaesar Vance" - write Dynamic
	// Xpath - Print Age
	@Test
	void printAgeOfEmployee() {
		String empName = "Caesar Vance";
		System.out.println("\nProgram Statement: Find Employee Age");
		System.out.println("STEP: Navigating to website");
		//
		System.out.println("STEP: Printing Employee age");
		String empAge = driver
				.findElement(By.xpath(
						"//table[@id='example']/tbody/tr/td[text()='" + empName + "']//following-sibling::td[3]"))
				.getText();
		System.out.println("Employee " + empName + " age: " + empAge);
		Assert.assertEquals(Integer.parseInt(empAge), 21, "Incorrect Age fetched.");
	}

	// 3. Print Employee First Name of all employees working from London Office.
	@Test
	void printFNameOfEmployee() {
		String empCity = "London";
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> fNameList = new ArrayList<String>();
		String[] originalEmpNames = {"Angelica", "Bradley", "Bruno","Haley", "Hermione","Jena","Lael", "Michael","Prescott","Suki", "Tatyana", "Timothy"};
		ArrayList<String> originalEmpList = new ArrayList<String>(Arrays.asList(originalEmpNames));
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
		Assert.assertEquals(fNameList, originalEmpList,"Incorrect details fetched for first name of Employee working at loaction.");

	}

	// 4. Find all Employees who hold Position as Software Engineer.
	@Test
	void getEmpNameWorkingAs() {
		String empPosition = "Software Engineer";
		ArrayList<String> nameList = new ArrayList<String>();
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		String[] originalEmpNames = { "Bradley Greer", "Brenden Wagner","Bruno Nash","Sonya Frost","Zenaida Frank", "Zorita Serrano"};
		ArrayList<String> originalEmpList = new ArrayList<String>(Arrays.asList(originalEmpNames));
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
		Assert.assertEquals(nameList, originalEmpList,"Incorrect details fetched of Employee working as "+empPosition);
	}

	// 5. Count number of Employee with age More than 25, on first page.
	@Test
	void getAgeGreaterThan() {
		int age = 25, pageIndex = 2;
		System.out.println("STEP: On Page 0" + pageIndex);
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + pageIndex + "]")).click();
		System.out.println("STEP - Collecting count of Employee having age > 25");
		List<WebElement> empList = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4][text()>25]//preceding-sibling::td[3]"));
		System.out.println("Count of Employee with age nore than 25 on page " + pageIndex + " is: " + empList.size());
		Assert.assertEquals(empList.size(), 8,"Incorrect details fetched of Employee age greater than "+age);
	}

	// 6. Print Employee Start date whose age is 66.
	@Test
	void getStartDateOfParticularAge() {
		int age = 66;
		LinkedList<String> startDateList = new LinkedList<String>();
		String[] originalStartDateArray = {"2009/01/12", "2012/11/27"};
		LinkedList<String> originalStartDateList = new LinkedList<String>(Arrays.asList(originalStartDateArray));
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		
		for (int index = 1; index <= pageNumbers; index++) {
			System.out.println("STEP: On Page 0" + index);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> empStartDateList = driver.findElements(
					By.xpath("//table[@id='example']/tbody/tr/td[4][text()='66']//following-sibling::td[1]"));
			System.out.println("STEP: Collecting Employee StartDate whose age is " + age);
			for (WebElement webElement : empStartDateList) {
				startDateList.add(webElement.getText());
			}
		}
		Assert.assertEquals(originalStartDateList, startDateList,"Incorrect details fetched of Employee Start Date whose age is greater than "+age);
	}
	
	//7. Print employee Age whose salary is minimum.
	@Test
	void getEmpAgeOfMinSalary() {

		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[6]")).click();
		int empAge = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='example']/tbody/tr/td[6]//preceding-sibling::td[2]")).getText());
		Assert.assertEquals(empAge, 43,"Incorrect details fetched of Employee age having minimum salary");
	}

	// 8. How many rows in Table on first page.
	@Test
	void getRowCount() {
		int pageIndex = 2, rowCount = 0;
		int pageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = pageIndex; index <= pageNumbers;) {
			System.out.println("STEP: On Page 0" + pageIndex);
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + pageIndex + "]")).click();
			System.out.println("STEP - Gathering row count");
			List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
			rowCount = rowList.size();
			break;
		}
		Assert.assertEquals(rowCount, 10,"Incorrect details fetched of row count on page0"+pageIndex);
	}

	// 9. Print all text in table
	@Test
	void printTableText() {

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
	}
}
