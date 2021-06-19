package madhavi_Raut.Assignment_11_20.TestCase_11;
//how many managers we have -> 3

import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindCountOfManager {
	void getManagerCount() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.id("demotable")).click();
		driver.findElement(By.xpath("//div[@id='empmanager']"));
		HashSet<String> ManagerList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of Manager present");
		for (int index = 1; index <= rowCount; index++) {
			ManagerList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[4]")).getText());
		}
		System.out.println("Total number of Managers - " + ManagerList.size());
		driver.close();
	}

	public static void main(String[] args) {
		new FindCountOfManager().getManagerCount();
	}
}
