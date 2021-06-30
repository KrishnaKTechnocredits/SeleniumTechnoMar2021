package pallavi.assignment13;

/*program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
*/
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pallavi.utility.PropOperation;

public class Testcase13 {

	public static void waitForElement(WebDriver driver, String Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Locator)));
	}

	static void comparevalue(HashMap<String, Integer> map) throws IOException {
		Set<String> keys = map.keySet();
		PropOperation prop = new PropOperation(".//resources/deptInfo.properties");
		for (String currentKey : keys) {
			int empCountActual = Integer.parseInt(prop.getValue(currentKey));
			int empCountExpected = map.get(currentKey);
			if (empCountActual == empCountExpected)
				System.out.println("Test case pass for :" + currentKey);
			else
				System.out.println("Test case failed for :" + currentKey);
		}
	}

	static HashMap<String, Integer> getCount(WebDriver driver) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tr/td[4]")).size();
		for (int index = 1; index <= row; index++) {
			String managerid = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[4]")).getText();
			if (map.containsKey(managerid))
				map.put(managerid, map.get(managerid) + 1);
			else
				map.put(managerid, 1);
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", ".//resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		waitForElement(driver, "//table[@class='table table-striped']");
		HashMap<String, Integer> map = getCount(driver);
		System.out.println(map);
		comparevalue(map);
		driver.close();

	}

}
