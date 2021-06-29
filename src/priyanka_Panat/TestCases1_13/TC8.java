package priyanka_Panat.TestCases1_13;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC8 {
	static WebDriver driver;

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		return driver;
	}

	static void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	static HashMap<String, String> getEmpData() {
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
		return empDataMap;
	}

	public static void main(String[] args) {
		start();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String, String> output = getEmpData();
		System.out.println(output);
		tearDown();
	}
}
