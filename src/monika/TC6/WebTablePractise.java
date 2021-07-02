package monika.TC6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*TC#6
Problem Statements :
1. How many total entries are there in table?
2. On Dynamic table - check age of Employee "Caesar Vance" - write Dynamic Xpath - Print Age
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
public class WebTablePractise {
	
	private static WebDriver driver;
	
	@BeforeMethod
	public static void beforeMethod() {
		driver = PredefinedActions.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html\r\n");
	}
	
	@Test
	public void webtableTotalEntries() {
		System.out.println("TC1. How many total entries are there in table?");
		int expectedEntryCount = 57;
		String tempVarCount = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		String[] arr = tempVarCount.split("of ");
		int actualCount =0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].contains("entries")) {
				String tempValue = arr[i].replace(" entries", "");
				 actualCount = Integer.parseInt(tempValue);
			}
		}
		System.out.println(actualCount);
		Assert.assertEquals(actualCount, expectedEntryCount);	
	}
	
	@Test
	public void verifyAgeOfEmp() {
		System.out.println("TC 2. On Dynamic table - check age of Employee \"Caesar Vance");
		int expectedAge = 21;
		int actualAge = Integer.valueOf(driver.findElement(By.xpath("//table[@id='example']//tr[8]//td[4]")).getText());
		System.out.println(actualAge);
		Assert.assertEquals(actualAge, expectedAge);
	}
	
	@Test
	public void verifyFirstNameOfEmpOfLondonOffice() {
		System.out.println("TC3. Print Employee First Name of all employees working from London Office.");
		List<WebElement> fNameElements = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td[3]//following::td[text()='London']//parent::tr/td[1]"));
		for(WebElement e :fNameElements) {
			String[] fNameArr = e.getText().split(" ");
			System.out.println(fNameArr[0]);
		}
	}
	
	@Test
	public void printEmpAsSE() {
		System.out.println("TC4. Find all Employees who hold Position as Software Engineer.");
		List<WebElement> EmpElements = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td[2]//following::td[text()='Software Engineer']//parent::tr/td[1]"));
		for(WebElement e :EmpElements) {
			System.out.println(e.getText());
		}
	}
	
	@Test
	public void printEmpCountOfAgeAbove25()  {
		System.out.println("TC5. Count number of Employee with age More than 25, on first page.\r\n" + 
				"");
		List<WebElement> EmpElements = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td[4][text()>'25']"));
		System.out.println("Employee count of age above 25 are :"+EmpElements.size());
	}
	
	@Test
	public void printEmpStartDateOfAgeEquals66()  {
		System.out.println("TC6. Print Employee Start date whose age is 66." );
		String result = driver.findElement(By.xpath("//table[@id='example']//tbody//tr//td[4]//following::td[text()='66']/following-sibling::td[1]")).getText();
		System.out.println("Employee start date age = 66 is :"+result);
	}
	
	@Test
	public void printEmpAgeWhoseSalaryMin()  {
		System.out.println("TC7. Print employee Age whose salary is minimum." );
		driver.findElement(By.xpath("//th[text()='Salary']")).click();
		System.out.println(driver.findElement(By.xpath("//tbody/tr//td[6]")).getText());
	}
	
	@Test
	public void printNoOfRowsOnTable()  {
		System.out.println("TC8. How many rows in Table on first page." );
		List<WebElement> rowsCount = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
		System.out.println("Rows count on table are: "+rowsCount.size());
	}
	
	
	@Test
	public void printAllTextInTable()  {
		System.out.println("TC9. Print all text in table" );
		List<WebElement> allText = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td"));
		for(WebElement e :allText)
			System.out.println("txt of row, col :"+e.getText());
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
