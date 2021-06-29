package radha.Assigmnent_1_12_withoutTestNG;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class FindEmpCountForEachDept_TestCase12 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String, Integer> deptNames = findEmpInEachDept(driver);
		System.out.println("Employee count in each dept is: "+deptNames);
		driver.close();
	}
	
	static HashMap<String, Integer> findEmpInEachDept(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 4);
		int rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table table-striped']/tbody//tr"))).size();
		HashMap<String, Integer> deptNames = new HashMap<String, Integer>();
		for(int index=1;index<=rows;index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody//tr["+index+"]/td[5]")).getText();
			if(deptNames.containsKey(deptName))
				deptNames.put(deptName, deptNames.get(deptName)+1);
			else
				deptNames.put(deptName, 1);
		}
		return deptNames;
	}
}
