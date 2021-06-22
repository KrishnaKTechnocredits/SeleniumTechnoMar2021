package simmi.TestCase14;

/*Test case : 8
Return a map of empId and empName*/

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase8NG {
	static HashMap<String, String> getEmployeeDetails(WebDriver driver) {
		HashMap<String, String> empDataMap = new HashMap<String, String>();
		List<WebElement> sizeElement = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = sizeElement.size();

		for (int index = 1; index <= size; index++) {
			String empID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			empDataMap.put(empID, empName);
		}
		return empDataMap;
	}

	@Test
	public void Operation() {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		HashMap<String, String> emp = getEmployeeDetails(driver);
		System.out.println("Map of empId and empName " + emp);
		driver.close();
	}
}
