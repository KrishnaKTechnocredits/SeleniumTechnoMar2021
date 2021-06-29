package madhavi_Raut.Assignment_12;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*program 1: employee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.*/
public class FindCountOfEmpInEachDept {

	HashMap<String, Integer> findCountOfEmpInEachDept() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, Integer> deptInfo = new HashMap<String, Integer>();
		List<WebElement> deptList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		System.out.println("STEP - Collecting count of employee working in each dept.");
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='empmanager']")));
		for (WebElement dept : deptList) {
			String deptName = dept.getText();
			if (deptInfo.containsKey(deptName)) {
				deptInfo.put(deptName, deptInfo.get(deptName) + 1);
			} else {
				deptInfo.put(deptName, 1);
			}
		}
		System.out.println("Below is the employee count in each deptName:");
		System.out.println("STEP - Closing browser");
		driver.close();
		return deptInfo;
	}

	public static void main(String[] args) {

		System.out.println(new FindCountOfEmpInEachDept().findCountOfEmpInEachDept());
	}
}
