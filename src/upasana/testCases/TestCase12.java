/*
program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.

program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2

*/

package upasana.testCases;

import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import base.PredefinedActions;

public class TestCase12 {

	static HashMap<String, Integer> getDepts(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HashMap<String, Integer> deptList = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (deptList.containsKey(deptName)) {
				deptList.put(deptName, deptList.get(deptName) + 1);
			} else
				deptList.put(deptName, 1);
		}

		return deptList;

	}

	static HashMap<String, Integer> getmanagers(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HashMap<String, Integer> managerList = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (managerList.containsKey(deptName)) {
				managerList.put(deptName, managerList.get(deptName) + 1);
			} else
				managerList.put(deptName, 1);
		}

		return managerList;

	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HashMap<String, Integer> deptList = getDepts(driver);
		System.out.println("\n"+deptList+"\n"); 
		HashMap<String, Integer> managerList = getmanagers(driver);
		System.out.println(managerList);
		driver.close();
	}
}