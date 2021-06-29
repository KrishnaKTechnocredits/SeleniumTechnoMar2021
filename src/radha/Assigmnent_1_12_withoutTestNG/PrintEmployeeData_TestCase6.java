package radha.Assigmnent_1_12_withoutTestNG;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class PrintEmployeeData_TestCase6 {

	int findAge(WebDriver driver) {
		String ageStr = driver
				.findElement(By.xpath("//table[@id='example']//tr/td[text()='Caesar Vance']//following-sibling::td[3]"))
				.getText();
		int age = Integer.valueOf(ageStr);
		return age;
	}

	List<String> findEmpWorkingFromLondon(WebDriver driver) {
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@id='example']//tr/td[text()='London']//parent::tr/td[1]"));
		List<String> fName = new ArrayList<String>();
		for (WebElement empName : list) {
			String name = empName.getText();
			String[] tempName = name.split(" ");
			fName.add(tempName[0]);
		}
		return fName;
	}

	List<WebElement> findSoftwareEngineers(WebDriver driver) {
		List<WebElement> eng = driver
				.findElements(By.xpath("//table[@id='example']//tr/td[text()='Software Engineer']//parent::tr/td[1]"));
		return eng;
	}

	int findEmpWithAgeMoreThan25(WebDriver driver) {
		List<WebElement> emp = driver.findElements(By.xpath("//td[text()>'25']"));
		return emp.size();
	}

	String findStartDate(WebDriver driver) {
		String startDate = driver.findElement(By.xpath("//td[text()='66']//following-sibling::td[1]")).getText();
		return startDate;
	}

	int findAgeWithMinSalary(WebDriver driver) {
		String getText = driver.findElement(By.xpath("//td[text()='$86,000']//../td[4]")).getText();
		return Integer.valueOf(getText);
	}
	
	int findNoOfRowsOn1stPage(WebDriver driver) {
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		return rowCount.size();
	}
	
	void printAllTextInTable(WebDriver driver) {
		WebElement pageText = driver.findElement(By.xpath("//table[@id='example']"));
		System.out.println(pageText.getText());
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		PrintEmployeeData_TestCase6 empData = new PrintEmployeeData_TestCase6();
		System.out.println("Problem Statement - 2");
		int age = empData.findAge(driver);
		System.out.println("Age of the Employee named Caesar Vance is : " + age);
		System.out.println("Problem Statement - 3");
		List<String> listofNames = empData.findEmpWorkingFromLondon(driver);
		System.out.println("Names of Employees working from London office are : " + listofNames);
		System.out.println("Problem Statement - 4");
		System.out.println("Names of the employees who hold Position as Software Engineer : ");
		List<WebElement> nameList = empData.findSoftwareEngineers(driver);
		for (WebElement e : nameList) {
			System.out.println(e.getText());
		}
		System.out.println("Problem Statement - 5");
		int size = empData.findEmpWithAgeMoreThan25(driver);
		System.out.println("Number of Employees with age more than 25 are : " + size);
		System.out.println("Problem Statement - 6");
		String startDate = empData.findStartDate(driver);
		System.out.println("Start date of the employee having age as 66 : " + startDate);
		System.out.println("Problem Statement - 7");
		int ageWithMinSalary = empData.findAgeWithMinSalary(driver);
		System.out.println("Age of the employee having minimum salary is : " + ageWithMinSalary);
		System.out.println("Problem Statement - 8");
		int noOfRows = empData.findNoOfRowsOn1stPage(driver);
		System.out.println("Number of rows on 1st page are : "+noOfRows);
		System.out.println("Problem Statement - 9");
		empData.printAllTextInTable(driver);
		System.out.println("Closing browser...");
		driver.close();
	}
}
