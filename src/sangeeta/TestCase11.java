/*Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8*/

package sangeeta;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase11 {

	static int getDeptCount(WebDriver driver) {
		HashSet<String> deptCount = new HashSet<String>();
		List<WebElement> deptCountElement = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for (WebElement e : deptCountElement) {
			deptCount.add(e.getText());
		}
		return deptCount.size();
	}

	static int getManagerCount(WebDriver driver) {
		HashSet<String> managerCount = new HashSet<String>();
		List<WebElement> managerCountElement = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for (WebElement e : managerCountElement) {
			managerCount.add(e.getText());
		}
		return managerCount.size();
	}

	static int getEmployeeCount(WebDriver driver) {
		HashSet<String> employeeCount = new HashSet<String>();
		List<WebElement> epmCount = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for (WebElement e : epmCount) {
			employeeCount.add(e.getText());
		}
		return employeeCount.size();
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int deptCount = getDeptCount(driver);
		System.out.println("Department count is: " + deptCount);
		int managerCount = getManagerCount(driver);
		System.out.println("Manager count is: " + managerCount);
		int employeeCount = getEmployeeCount(driver);
		System.out.println("Employee count is: " + employeeCount);
	}
}
