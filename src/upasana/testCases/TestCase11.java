/*
program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8

 */

package upasana.testCases;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class TestCase11 {

	static int getDepts(WebDriver driver) {
		
		HashSet<String> deptList = new HashSet<String>();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for(WebElement element: list) {
			deptList.add(element.getText());
		}
		return deptList.size();
	
	}
	

	static int getmanagers(WebDriver driver) {
		
		HashSet<String> managerList = new HashSet<String>();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for(WebElement element: list) {
			managerList.add(element.getText());
		}
		return managerList.size();
	
	}
	
	static int getEmp(WebDriver driver) {
		
		HashSet<String> empList = new HashSet<String>();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for(WebElement element: list) {
			empList.add(element.getText());
		}
		return empList.size();
	
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		int deptList = getDepts(driver);
		System.out.println(deptList);
		int managerList = getmanagers(driver);
		System.out.println(managerList);
		int empList = getEmp(driver);
		System.out.println(empList);
		driver.close();
	}
}