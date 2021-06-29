package surabhi.automationByKrishnaDemoTables;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//unique employee under each department count
public class TestCase4 extends BaseClass{
	
	static void waitTillTableVisible(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
	}
	  
	@Test
	void runTest(){
		waitTillTableVisible(driver);
		int size=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		
		//HashMap for EmployeeID as key and HashMap of department, and it's count as a value
		HashMap<String, HashMap<String,Integer>> hm=new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> hs=new HashMap<String,Integer>();
		for(int index=1;index<=size;index++) {
			
			String empId=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td[2]")).getText();
			String department=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td[5]")).getText();
			//check if empID already exists, dont put into hashMap
			if(!hm.containsKey(empId)) {
				//put department and it's count 
				if(hs.containsKey(department)) {
					hs.put(department, hs.get(department)+1);
				}else {
					hs.put(department, 1);
				}
			}
			
			hm.put(empId, hs);
		}
		System.out.println(hs);
	}

}
