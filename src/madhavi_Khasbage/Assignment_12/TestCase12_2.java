package madhavi_Khasbage.Assignment_12;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2
*/

public class TestCase12_2 {

	static void getCountEmployeeOfManager() {
		System.out.println("Step1: Launch browser & hit AutomationByKrishna.com");
		WebDriver driver = PredefinedActions.setUp("http://automationbykrishna.com/");

		System.out.println("Step2:Nevigate to Demo tables");
		driver.findElement(By.id("demotable")).click();

		System.out.println("Wait for demotable page to load");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("Get unique manager count");
		HashMap<Integer, Integer> empMap = new HashMap<Integer, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		
		for (int index = 1; index < rows; index++) {
			int managerID = Integer.parseInt(driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[4]")).getText());
			if (!empMap.containsKey(managerID)) {
				empMap.put(managerID, 1);
			} else {
				empMap.put(managerID, empMap.get(managerID)+1);
			}
		}

		System.out.println("Manager and their employee count >>" + empMap);
		System.out.println("Step3:Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		TestCase12_2.getCountEmployeeOfManager();
	}
}
