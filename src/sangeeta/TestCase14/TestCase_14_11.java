/*Test case - 11: 16th Jun'2021
program 1: How many Depts we have.
ans : 4
program 2 : how many managers we have.
ans : 3
program 3: how many employees we have.
ans : 8*/
package sangeeta.TestCase14;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase_14_11 {
	
	@Test
	public void getDeptCount() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashSet<String> deptCount = new HashSet<String>();
		List<WebElement> deptCountElement = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for (WebElement e : deptCountElement) {
			deptCount.add(e.getText());
		}
		System.out.println("Department count is: " + deptCount.size());
	}
	
	@Test
	public void getManagerCount() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashSet<String> managerCount = new HashSet<String>();
		List<WebElement> managerCountElement = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for (WebElement e : managerCountElement) {
			managerCount.add(e.getText());
		}
		System.out.println("Manager count is: " + managerCount.size());
	}
	
	@Test
	public void getEmployeeCount() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashSet<String> employeeCount = new HashSet<String>();
		List<WebElement> epmCount = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for (WebElement e : epmCount) {
			employeeCount.add(e.getText());
		}
		System.out.println("Employee count is: " + employeeCount.size());
	}
}
