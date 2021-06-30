/*Test case : 8
Return a map of empId and empName*/

package sandesh.First13TestCases;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_8 {

	private LinkedHashMap<String, String> getMapEmpNameAndID(WebDriver dr) {
		dr.get("http://automationbykrishna.com/index.html#");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(dr, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empmanager']//tbody/tr")));
		List<WebElement> listOfRows = dr.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		LinkedHashMap<String, String> mapOfEmp = new LinkedHashMap<String, String>();

		for (int index = 1; index <= listOfRows.size(); index++) {
			mapOfEmp.put(dr.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText(),
					dr.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[3]")).getText());
		}
		return mapOfEmp;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		LinkedHashMap<String, String> mapOfEmployees = new TestScenario_8().getMapEmpNameAndID(driver);
		System.out.println("Map of Employees from given table is -: ");
		System.out.println(mapOfEmployees);
		System.out.println("Total number of unique employees in the given table are -: " + mapOfEmployees.size());
	}
}
