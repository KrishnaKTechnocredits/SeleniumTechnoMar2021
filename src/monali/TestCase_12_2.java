package monali;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//program 2: count number of employee under each manager.


public class TestCase_12_2 {
	
static HashMap<String,Integer> countOfEmpUnderEachManager(WebDriver driver){ 
		
		HashMap<String,Integer> empCountMap = new HashMap<String,Integer>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index = 1; index<=totalRows; index++) {
			String nameOfEmp = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(empCountMap.containsKey(nameOfEmp))
				empCountMap.put(nameOfEmp, empCountMap.get(nameOfEmp)+1);
			else
				empCountMap.put(nameOfEmp, 1);
		}
		return empCountMap;
}
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,Integer> output = countOfEmpUnderEachManager(driver);
		System.out.println(output);
	}
	}



