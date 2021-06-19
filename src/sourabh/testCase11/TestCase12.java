/*
Test case - 12: 16th Jun'2021
program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.

program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2
 */
package sourabh.testCase11;

import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase12 {
	static HashMap<String, Integer> getDeptCountMap(WebDriver driver) {
		int countRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> deptCountMap= new HashMap<String, Integer>();
		for(int index=1; index<=countRows; index++) {
			String deptName= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(deptCountMap.containsKey(deptName))
				deptCountMap.put(deptName, deptCountMap.get(deptName)+1);
			else
				deptCountMap.put(deptName, 1);
		}
		return deptCountMap;
	}
	
	//------------------------------------------------------------------------------------
	
	static HashMap<String, Integer> getEmployeeCountEachManagerMap(WebDriver driver){
		int countRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> employeeCountEachManager= new HashMap<String, Integer>();
		for(int index=1; index<=countRows; index++) {
			String managerID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(employeeCountEachManager.containsKey(managerID))
				employeeCountEachManager.put(managerID, employeeCountEachManager.get(managerID)+1);
			else
				employeeCountEachManager.put(managerID, 1);
		}
		return employeeCountEachManager;
	}

	public static void main(String[] args) {
		System.out.println("STEP1 : Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP2 : Open URL ");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		// ----------------------------------------------------------------------------------
		System.out.println("STEP3 : Wait for Demo Tables page to load  ");
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		HashMap<String, Integer> outputDept= getDeptCountMap(driver);
		System.out.println("Emplyee count in each deptName : " +outputDept);
		
		HashMap<String, Integer> outputManagerID= getEmployeeCountEachManagerMap(driver);
		System.out.println("Emplyee count in each Employee count under a Manager : " +outputManagerID);
		
		driver.close();
	}

}
