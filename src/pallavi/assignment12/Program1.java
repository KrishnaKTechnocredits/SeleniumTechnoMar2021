package pallavi.assignment12;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case - 12: 16th Jun'2021
program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2*/
public class Program1 {

	static void waitForElement(WebDriver driver, String Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
	}

	static HashMap<Integer, String> getEmpCount(WebDriver driver) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr//td[5]")).size();
		for (int index = 1; index <= row; index++) {
			String empDept = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]//td[5]"))
					.getText();
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]//td[2]"))
					.getText();
			int id = Integer.parseInt(empId);
			if (!map.containsKey(id)) {
				map.put(id, empDept);
			}
		}
		System.out.println(map);
		Set<Integer> key = map.keySet();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		for (Integer currentkey : key) {
			String value = map.get(currentkey);
			if (map1.containsKey(value))
				map1.put(value, map1.get(value) + 1);
			else
				map1.put(value, 1);
		}
		System.out.println(map1);

		return map;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Launch browser and Hit url");
		driver.get("http://automationbykrishna.com/");
		System.out.println("STEP-maximize the window");
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();
		waitForElement(driver, "//table[@class='table table-striped']");
		getEmpCount(driver);
		driver.close();
	}

}
