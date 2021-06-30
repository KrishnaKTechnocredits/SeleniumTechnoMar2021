package radha.Assigmnent_1_12_withoutTestNG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class FindCount_TestCase11 {
	
	static ArrayList<String> finderHeader(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		ArrayList<String> headers = new ArrayList<>();
		List<WebElement> columnCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']//th")));
		for(WebElement tHead :columnCount) {
			headers.add(tHead.getText());
		}
		return headers;
	}
	
	void findDeptCount(WebDriver driver) {
		HashSet<String> deptName = new HashSet<>();
		ArrayList<String> headers = finderHeader(driver);
		int deptIndex = headers.indexOf("Employee Department")+1;
		System.out.println("\nStep - 1: Find No of Depts in the Table---");
		List<WebElement> elements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td["+deptIndex+"]"));
		for(WebElement e:elements) {
			deptName.add(e.getText());
		}
		System.out.println("Number of Depts in the table are: "+deptName.size());
	}
	
	void findManagerCount(WebDriver driver) {
		HashSet<String> managerNames = new HashSet<>();
		ArrayList<String> headers = finderHeader(driver);
		int managerIDIndex = headers.indexOf("Employee ManagerID")+1;
		System.out.println("\nStep - 2: Find No of Managers in the Table---");
		List<WebElement> elements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td["+managerIDIndex+"]"));
		for(WebElement e:elements) {
			managerNames.add(e.getText());
		}
		System.out.println("Number of Managers in the table are: "+managerNames.size());
	}
	
	void findEmployeeCount(WebDriver driver) {
		HashSet<String> empNames = new HashSet<>();
		ArrayList<String> headers = finderHeader(driver);
		int empIndex = headers.indexOf("Employee Id")+1;
		System.out.println("\nStep - 3: Find No of Employees in the Table---");
		List<WebElement> elements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td["+empIndex+"]"));
		for(WebElement e:elements) {
			empNames.add(e.getText());
		}
		System.out.println("Number of Employees in the table are: "+empNames.size());
	}
	
	public static void main(String[] args) {
		WebDriver driver =PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		FindCount_TestCase11 findCount = new FindCount_TestCase11();
		findCount.findDeptCount(driver);
		findCount.findEmployeeCount(driver);
		findCount.findManagerCount(driver);
		System.out.println("\nClose browser...");
		driver.close();
	}
}
