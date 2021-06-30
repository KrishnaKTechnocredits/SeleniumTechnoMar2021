package madhavi_Raut.TestCase_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2*/
public class FindCountOfEmp {

	void getCountOfEmp() throws IOException{
		File file = new File(".//src/madhavi_Raut/ManagerDetails");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/");
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, Integer> deptInfo = new HashMap<String, Integer>();
		List<WebElement> deptList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
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
		System.out.println(deptInfo);
		System.out.println("STEP - Verifying details of Emp count with file.");
		Set<String> managerIdSet = deptInfo.keySet();
		for (String managerId : managerIdSet) {
			if (prop.getProperty(managerId).equals(String.valueOf(deptInfo.get(managerId)))) {
				System.out.println("Correct employee count fetched for " + managerId);
			} else {
				System.out.println("Incorrect employee count fetched for " + managerId);
			}
		}
		System.out.println("STEP - Closing browser");
		driver.close();
	}

	public static void main(String[] args) throws IOException{
		new FindCountOfEmp().getCountOfEmp();
	}
}
