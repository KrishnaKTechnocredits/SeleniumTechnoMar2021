package madhavi_Raut.Assignment_01_10.TestCase_08;
//Test case : 8 Return a map of empId and empName

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//Test case : 8 Return a map of empId and empName
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapForEmpIDName {
	HashMap<Integer, String> getMapForEmpIDName() {
		HashMap<Integer, String> empDetails = new HashMap<Integer, String>();
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		int empId;
		String empName = "";
		System.out.println("STEP - Collecting Emp Id and respective Emp Name");
		for (int index = 1; index <= rowCount; index++) {
			empId = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText());
			empName = driver
					.findElement(By
							.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]//following-sibling::td[1]"))
					.getText();

			if (!empDetails.containsKey(empId)) {
				empDetails.put(empId, empName);
			}
		}

		driver.close();
		return empDetails;
	}

	public static void main(String[] args) {
		System.out.println("HashMap of empId and empName:");
		System.out.println(new MapForEmpIDName().getMapForEmpIDName());
	}
}
