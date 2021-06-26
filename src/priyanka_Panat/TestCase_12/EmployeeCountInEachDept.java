package priyanka_Panat.TestCase_12;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class EmployeeCountInEachDept {
	static void WaitForElement(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
	}
	
	static HashMap<String, Integer> getDeptCountMap(WebDriver driver){
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String,Integer> mapOfDepts=new HashMap<String,Integer>();
		for(int index=1;index<=totalRows;index++) {
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(mapOfDepts.containsKey(deptName)) 
				mapOfDepts.put(deptName,mapOfDepts.get(deptName)+1);
			else 
				mapOfDepts.put(deptName, 1);
			
		}
		return mapOfDepts;
	}
	
	public static void main(String[] args) {
		WebDriver driver=PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();;
		WaitForElement(driver,"//a[contains(text(),'Tables')]");
		HashMap<String,Integer> result=getDeptCountMap(driver);
		System.out.println("Employee count in each department is : " +result);
		driver.close();
	}
}
