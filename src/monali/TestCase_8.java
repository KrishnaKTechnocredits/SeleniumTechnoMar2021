package monali;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_8 {
	
	static HashMap<String,String>getEmpIdAndEmpName(WebDriver driver){
		HashMap<String,String> empDataMap = new HashMap<String,String>();
		
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
	

		for(int index=1;index<=size;index++){
			String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			
		String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			
			empDataMap.put(empId,empName);
		}

		return empDataMap;
	}
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String,String> empDataMap = getEmpIdAndEmpName(driver);
		System.out.println(empDataMap);

	}
	
}
