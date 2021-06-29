package madhavi_Raut.Assignment_12;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2*/
public class FindCountOfEmpUnderManager {

	HashMap<String, Integer> getCountOfEmpUnderManager() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, Integer> empCountUnderManager = new HashMap<String, Integer>();
		List<WebElement> managerList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		System.out.println("STEP - Collecting count of employee working under Manager.");
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='empmanager']")));
		for (WebElement manager : managerList) {
			String managerId = manager.getText();
			if (empCountUnderManager.containsKey(managerId)) {
				empCountUnderManager.put(managerId, empCountUnderManager.get(managerId) + 1);
			} else
				empCountUnderManager.put(managerId, 1);
		}
		System.out.println("STEP - Closing the browser");
		System.out.println("Count of employee under Manger is: ");
		driver.close();
		return empCountUnderManager;
	}

	public static void main(String[] args) {
		System.out.println(new FindCountOfEmpUnderManager().getCountOfEmpUnderManager());
	}
}
