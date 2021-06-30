package monali;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//program 1: emplyees count in each deptName.


public class TestCase_12_1 {
	
	static HashMap<String,Integer> getEmpCount(WebDriver driver){ 
		
		HashMap<String,Integer> deptMap = new HashMap<String,Integer>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index = 1; index<=totalRows; index++) {
			String nameOfDept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(deptMap.containsKey(nameOfDept))
				deptMap.put(nameOfDept, deptMap.get(nameOfDept)+1);
			else
				deptMap.put(nameOfDept, 1);
		}
		return deptMap;
}
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,Integer> output = getEmpCount(driver);
		System.out.println(output);
	}
	}
