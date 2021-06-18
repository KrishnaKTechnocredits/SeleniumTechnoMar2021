/*Test case - 12: 16th Jun'2021
program 1: employee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.
program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2
*/
package paras.Assignment_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase12 {

	private static WebDriver driver;

	private static void employeeCountDeptWise(WebDriver driver) {
		HashMap<String, Integer> empDeptMap = new HashMap<String, Integer>();
		List<WebElement> deptList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		ArrayList<String> uniqueDeptList = new ArrayList<String>();

		for (WebElement listOfDept : deptList) {
			if (!uniqueDeptList.contains(listOfDept.getText())) {
				uniqueDeptList.add(listOfDept.getText());
			}
		}
		for (int index = 0; index < uniqueDeptList.size(); index++) {
			String key = uniqueDeptList.get(index);
			int value = driver
					.findElements(
							By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='" + key + "']"))
					.size();
			empDeptMap.put(key, value);
		}
		System.out.println(empDeptMap);
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		employeeCountDeptWise(driver);
		driver.close();
	}
}
