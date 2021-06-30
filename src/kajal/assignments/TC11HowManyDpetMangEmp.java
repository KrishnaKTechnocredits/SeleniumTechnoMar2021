package kajal.assignments;

/*
 * Test case - 11: [16th Jun'2021]
 

program 1: How many Depts we have.
ans : 4

program 2 : how many managers we have.
ans : 3

program 3: how many employees we have.
ans : 8
 */
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC11HowManyDpetMangEmp {
	static void getDeptName(WebDriver driver) throws InterruptedException {
		TreeSet<String> totalDept = new TreeSet<String>();

		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		int size = totalRows.size();

		for (int index = 0; index < size; index++) {
			String dept = driver
					.findElement(
							By.xpath("//table[@class='table table-striped']//tbody//tr[" + (index + 1) + "]//td[5]"))
					.getText();
			totalDept.add(dept);
		}

		int countDept = totalDept.size();
		System.out.println("Total Departments are :" + totalDept);
		System.out.println("Count of departments are :" + countDept);
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		getDeptName(driver);
		driver.close();
	}
}
