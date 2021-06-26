package madhavi_Khasbage.Assignment_13;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test Case - 13 [18-06-2021]
Program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
*/


public class TestCase_13 {
	WebDriver driver;
	 void verifyDeptData(HashMap<String,Integer> hmap) throws IOException{
		 PropOperation popOperation=new PropOperation(".//src/madhavi_Khasbage/Assignment_13/deptinfo.properties");		
		Set<String> keys= hmap.keySet();
		for(String currentkey:keys) {
			int deptcoutExpected=Integer.parseInt(popOperation.getValue(currentkey));			
			int deptcount=hmap.get(currentkey);			
			if(deptcoutExpected==deptcount) {
				System.out.println("Test Pass for >>" + currentkey);
			}else {
				System.out.println("Test Fail for >>" + currentkey);
			}				
		}
		driver.close();
	}
	void getEmployeeCout() throws IOException {
		System.out.println("Step1: Launch browser & hit AutomationByKrishna.com");
		driver = PredefinedActions.setUp("http://automationbykrishna.com/");

		System.out.println("Step2:Nevigate to Demo tables");
		driver.findElement(By.id("demotable")).click();

		System.out.println("Wait for demotable page to load");
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

	    System.out.println("Get unique department count");
		HashMap<String, Integer> empMap = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		
		for (int index = 1; index < rows; index++) {
			String strName = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[5]")).getText();
			if (!empMap.containsKey(strName)) {
				empMap.put(strName, 1);
			} else {				
				empMap.put(strName, empMap.get(strName)+1);
			}
		}
	
		verifyDeptData(empMap);
	}

	public static void main(String[] args) throws IOException {		
		TestCase_13 testcase=new TestCase_13();		
		testcase.getEmployeeCout();
	}
}
