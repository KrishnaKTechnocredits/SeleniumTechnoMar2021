package radha.Assigmnent_1_12_withoutTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import radha.Assigmnent_1_12_withoutTestNG.*;

public class EmpCountUsingPropFile_TestCase13 {
	public static void main(String[] args) throws IOException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String, Integer> empID = findEmpCount(driver);
		System.out.println("Employee count under each Manager is: " + empID);
		verifyCountFromPropFile(empID);
		driver.close();
	}

	static HashMap<String, Integer> findEmpCount(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		int rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody//tr"))).size();
		HashMap<String, Integer> managerCount = new HashMap<String, Integer>();
		for (int index = 1; index <= rows; index++) {
			String managerID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody//tr[" + index + "]/td[4]")).getText();
			if (managerCount.containsKey(managerID))
				managerCount.put(managerID, managerCount.get(managerID) + 1);
			else
				managerCount.put(managerID, 1);
		}
		return managerCount;
	}
	
	public static void verifyCountFromPropFile(HashMap<String, Integer> empCountMap) throws IOException {
		File file = new File(".//src/radha/Assigmnent_1_12_withoutTestNG/EmpCount.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		Set<String> key = empCountMap.keySet();
		for(String currentkey:key) {
			int expectedEmpCount = Integer.parseInt(prop.getProperty(currentkey));
			int actualEmpCount = empCountMap.get(currentkey);
			if(expectedEmpCount==actualEmpCount)
				System.out.println("Emp Count is as expected "+expectedEmpCount);
			else
				System.out.println("Emp count is incorrect. It should be "+expectedEmpCount);
		}
	}
}
