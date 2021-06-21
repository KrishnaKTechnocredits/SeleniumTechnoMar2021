package shivani.Assignment11;

import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*Test case - 11: 16th Jun'2021

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8*/

public class Assignment11 {
	
	@Test
	void NoOfDepartment() throws InterruptedException {
		System.out.println("testcase 1");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
	
		driver.findElement(By.id("demotable")).click();
		System.out.println("clicked on demotable");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='empmanager']"));
	
		HashSet<String> DepartmentList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - get all the rows");
		for (int index = 1; index <= rowCount; index++) {
			DepartmentList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[5]")).getText());
		}
		System.out.println("Total number of department : " + DepartmentList.size());
		driver.close();
	}
@Test
	void NoOfManager () throws InterruptedException {
	System.out.println("testcase 2 ");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
	
		driver.findElement(By.id("demotable")).click();
		System.out.println("clicked on demotable");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='empmanager']"));
	
		HashSet<String> ManagerList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
	
	 
		
		System.out.println("STEP - get all the rows");
		for (int index = 1; index <= rowCount; index++) {
			ManagerList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[4]")).getText());
		}
		System.out.println("Total number of Managers : " + ManagerList.size());
		driver.close();
	}
@Test
void NoOfEmployee () throws InterruptedException {
	System.out.println("testcase 2 ");
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
	
		driver.findElement(By.id("demotable")).click();
		System.out.println("clicked on demotable");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='empmanager']"));
	
		HashSet<String> EmployeeList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
	
	 
		
		System.out.println("STEP - get all the rows");
		for (int index = 1; index <= rowCount; index++) {
			EmployeeList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText());
		}
		System.out.println("Total number of Employee : " + EmployeeList.size());
		driver.close();
	}
	
}	


