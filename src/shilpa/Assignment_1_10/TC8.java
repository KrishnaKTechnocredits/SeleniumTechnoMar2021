package shilpa.Assignment_1_10;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Test case : 8
Return a map of empId and empName
*/
public class TC8 {
	void getMapOfEmpIdAndName() {
		WebDriver driver=new LaunchBrowser().start("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		HashMap<String, String> empDataMap = new HashMap<String, String>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		for (int index = 1; index <= size; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			empDataMap.put(empId, empName);
		}
		System.out.println(empDataMap);
		driver.close();
		
	}

	public static void main(String[] args) {
		new TC8().getMapOfEmpIdAndName();
	}

}
