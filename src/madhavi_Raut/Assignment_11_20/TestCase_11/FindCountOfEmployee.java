package madhavi_Raut.Assignment_11_20.TestCase_11;

//how many employees we have - 8
import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindCountOfEmployee {

	void getEmployeeCount() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.id("demotable")).click();
		driver.findElement(By.xpath("//div[@id='empmanager']"));
		HashSet<String> EmployeeList = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of Employee present");
		for (int index = 1; index <= rowCount; index++) {
			EmployeeList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText());
		}
		System.out.println("Total number of Employee - " + EmployeeList.size());
		driver.close();
	}

	public static void main(String[] args) {
		new FindCountOfEmployee().getEmployeeCount();
	}
}
