/*Test case - 12: 16th Jun'2021
program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.
program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2*/

package sangeeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase12 {

	static HashMap<String, Integer> employeeCountDeptWise(WebDriver driver) {
		HashMap<String, Integer> empCount = new HashMap<String, Integer>();
		List<WebElement> deptList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for (WebElement currentKey : deptList) {
			String temp = currentKey.getText();
			if (empCount.containsKey(currentKey.getText()))
				empCount.put(temp, empCount.get(temp) + 1);
			else
				empCount.put(temp, 1);
		}
		return empCount;
	}

	static HashMap<String, Integer> employeeCountManagerWise(WebDriver driver) {
		HashMap<String, Integer> empCount = new HashMap<String, Integer>();
		List<WebElement> empList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for (WebElement currentKey : empList) {
			String temp = currentKey.getText();
			if (empCount.containsKey(currentKey.getText()))
				empCount.put(temp, empCount.get(temp) + 1);
			else
				empCount.put(temp, 1);
		}
		return empCount;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String, Integer> empMap = employeeCountDeptWise(driver);
		System.out.println(empMap);
		HashMap<String, Integer> empMapManagerWise = employeeCountManagerWise(driver);
		System.out.println(empMapManagerWise);
	}

}
