package amrutaM.testcases;

/*Test Case: 8 
 * Return a map of empId and empName*/

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amrutaM.base.PredefinedActions;

public class TC8_EmpMap {
	static WebDriver driver;
	
	public HashMap<String, String> getEmployeeDetailsMap() {
		HashMap<String, String> empDataMap  = new HashMap<String, String>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index = 1;index<=size;index++) {
			String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			empDataMap.put(empId, empName);
		}
		return empDataMap;
	}
	
	public static void main(String[] args) {
		System.out.println("STEP: Launching the browser");
		System.out.println("STEP: Navigating to automationbykrishna.com");
		driver = PredefinedActions.setUp();
		System.out.println("Clicking on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("STEP: Waiting for page to load");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']")));
		TC8_EmpMap tc8_EmpMap = new TC8_EmpMap();
		HashMap<String, String> empDetails = tc8_EmpMap.getEmployeeDetailsMap();
		System.out.println(empDetails);
		System.out.println("STEP : Closing the browser");
		PredefinedActions.tearDown();
	}
}
