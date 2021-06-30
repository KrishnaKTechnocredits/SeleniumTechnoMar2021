package pallavi.assignment12;
/*program 2: count number of employee under each manager.
output : 20209 -> 3
         20205 -> 4
         10101 -> 2**/

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program2 {

	static void waitForElement(WebDriver driver, String Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
	}

	static HashMap<String, Integer> getCount(WebDriver driver) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr//td[4]")).size();
		for (int index = 1; index <= row; index++) {
			String empDept = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]//td[4]"))
					.getText();
			if (map.containsKey(empDept))
				map.put(empDept, map.get(empDept) + 1);
			else
				map.put(empDept, 1);
		}
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
		HashMap<String, Integer> count = getCount(driver);
		System.out.println(count);
		driver.close();
	}

}
