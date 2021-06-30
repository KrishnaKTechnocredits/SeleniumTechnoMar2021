package madhavi_Raut.Assignment_11_20.TestCase_11;

import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//How many dept we have -> 4
public class FindDeptCount {

	void getDeptCount() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.id("demotable")).click();
		driver.findElement(By.xpath("//div[@id='empmanager']"));
		HashSet<String> deptList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of dept present");
		for (int index = 1; index <= rowCount; index++) {
			deptList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[5]")).getText());
		}
		System.out.println("Total number of dept - " + deptList.size());
		driver.close();
	}

	public static void main(String[] args) {
		new FindDeptCount().getDeptCount();
	}
}
