package kajal.assignments;

/*
 * Test case - 12 : [17th Jun'2021]

program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2
 */
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC12CntEmpUnderMngrVerifyPropFile {
	static void getCount(WebDriver driver) throws InterruptedException {
		HashMap<String, Integer> deptEmp = new HashMap<String, Integer>();

		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		int size = totalRows.size();

		for (int index = 0; index < size; index++) {
			String dept = driver
					.findElement(
							By.xpath("//table[@class='table table-striped']//tbody//tr[" + (index + 1) + "]//td[5]"))
					.getText();
			if (!deptEmp.containsKey(dept))
				deptEmp.put(dept, 1);
			else
				deptEmp.put(dept, deptEmp.get(dept) + 1);
		}
		System.out.println("Department to employee mapping count :" + deptEmp);
	}

	static void countManagerEmp(WebDriver driver) throws InterruptedException {
		HashMap<String, Integer> MgrEmp = new HashMap<String, Integer>();

		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		int size = totalRows.size();

		for (int index = 0; index < size; index++) {
			String manager = driver
					.findElement(
							By.xpath("//table[@class='table table-striped']//tbody//tr[" + (index + 1) + "]//td[4]"))
					.getText();
			if (!MgrEmp.containsKey(manager))
				MgrEmp.put(manager, 1);
			else
				MgrEmp.put(manager, MgrEmp.get(manager) + 1);
		}
		System.out.println("Manager to employee mapping count :" + MgrEmp);
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		getCount(driver);
		countManagerEmp(driver);
		driver.close();
	}
}