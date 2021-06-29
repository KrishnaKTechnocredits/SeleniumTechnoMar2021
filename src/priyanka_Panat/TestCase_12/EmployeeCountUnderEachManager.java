package priyanka_Panat.TestCase_12;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class EmployeeCountUnderEachManager {
	static void WaitForElement(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	static HashMap<String, Integer> getEmployeeCountMap(WebDriver driver){
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String,Integer> mapOfMng=new HashMap<String,Integer>();
		for(int index=1;index<=totalRows;index++) {
			String empName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(mapOfMng.containsKey(empName))
				mapOfMng.put(empName,mapOfMng.get(empName)+1);
			else 
				mapOfMng.put(empName, 1);
			
		}
		return mapOfMng;
	}
	
	public static void main(String[] args) {
		WebDriver driver=PredefinedActions.start();
		driver.findElement(By.partialLinkText("Tables")).click();;
		WaitForElement(driver,"//a[contains(text(),'Tables')]");
		HashMap<String,Integer> output=getEmployeeCountMap(driver);
		System.out.println("Employee count under each manager is : " +output);
		driver.close();
		
	}
}
