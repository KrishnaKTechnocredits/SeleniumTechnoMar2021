// count number of employee under each manager, verify count against properties file.

package krati_Jain.test1_14_TestNG;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase12 {

	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		getEmpManagers();
	}

	@Test
	public void getEmpManagers() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = table.size();
		Thread.sleep(3000);
		HashMap<String, Integer> empMngr = new HashMap<String, Integer>();

		for (int index = 1; index <= size; index++) {

			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[3]")).getText();
			String manager = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]/td[4]")).getText();
			if (!empMngr.containsKey(manager))
				empMngr.put(manager, 1);
			else
				empMngr.put(manager, empMngr.get(manager) + 1);

		}
		System.out.println(empMngr);
	}

	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}

}
