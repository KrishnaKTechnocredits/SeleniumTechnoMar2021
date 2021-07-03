package madhavi_Khasbage.Assignment_12;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import madhavi_Khasbage.base.PredefinedActions;

/*program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.
*/

public class TestCase12_1 {

	static void getEmployeeCout() {
		System.out.println("Step1: Launch browser & hit AutomationByKrishna.com");
		WebDriver driver = PredefinedActions.setUp("http://automationbykrishna.com/");

		System.out.println("Step2:Nevigate to Demo tables");
		driver.findElement(By.id("demotable")).click();

		System.out.println("Wait for demotable page to load");
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
	    System.out.println("Get unique department count");
		HashMap<String, Integer> empMap = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		int count = 1;
		for (int index = 1; index < rows; index++) {
			String strName = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[5]")).getText();
			if (!empMap.containsKey(strName)) {
				empMap.put(strName, 1);
			} else {				
				empMap.put(strName, empMap.get(strName)+1);
			}
		}
		
		System.out.println("Department and their employee count >>" + empMap);		
		System.out.println("Step3:Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		TestCase12_1.getEmployeeCout();
	}

}
