package prachi.Assignment_1_to_10;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//Test case : 8 Return a map of empId and empName
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case : 8
Return a map of empId and empName

HashMap<String,String>empDataMap = new HashMap<String,String>();
size = //table[@class='table table-striped']/tbody/tr;

for(int index=1;index<=size;index++){
	String empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]
		")).getText();
	
	String empName = driver.findElement(By.xpath("//table[@class='table 				   table-striped']/tbody/tr["+index+"]/td[3]"));
	
	empDataMap.put(empId,empName);
}
return empDataMap;*/

public class Assignmnet_8 {
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
		System.out.println(new Assignmnet_8().getMapForEmpIDName());
	}

}
