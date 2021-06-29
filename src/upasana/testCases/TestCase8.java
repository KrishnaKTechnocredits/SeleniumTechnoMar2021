/*
 Return a map of empId and empName
 */

package upasana.testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class TestCase8 {

	static LinkedHashMap<String, String> getMap(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		LinkedHashMap<String, String> mapEmp = new LinkedHashMap<String, String>();
		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		for (int index = 1; index <= size; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			String empName = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			mapEmp.put(empId, empName);
		}
		return mapEmp;
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		LinkedHashMap<String, String> mapEmp = getMap(driver);
		System.out.println(mapEmp);
		driver.close();
	}
}