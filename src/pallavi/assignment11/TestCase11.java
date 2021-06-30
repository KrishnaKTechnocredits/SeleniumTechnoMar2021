package pallavi.assignment11;
/*program 1: How many Depts we have.
ans : 4
program 2 : how many managers we have.
ans : 3
program 3: how many employees we have.
ans : 8*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase11 {
	// program 1: How many Depts we have.

	static void waitForElement(WebDriver driver, String Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
	}

	static int uniqueDepartment(WebDriver driver) {
		List<WebElement> listOfDepart = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[5]"));
		List<String> departList = new ArrayList<String>();
		for (WebElement list : listOfDepart) {
			departList.add(list.getText());
		}
		HashSet<String> uniqueDepart = new HashSet<String>(departList);
		return uniqueDepart.size();

	}

	// program 1: How many Depts we have.-----------2nd Way
	static int uniqueDepartmentcount(WebDriver driver) {
		List<WebElement> listOfDepart = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[5]"));
		HashSet<String> uniqueDepart = new HashSet<String>();
		for (WebElement list : listOfDepart) {
			uniqueDepart.add(list.getText());
		}
		return uniqueDepart.size();
	}

	// program 1: How many Depts we have.----------3rd way
	static int uniqueDepartmentcount2(WebDriver driver) {
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr//td[5]")).size();
		HashSet<String> uniqueDepart = new HashSet<String>();
		for (int index = 1; index <= row; index++) {
			String dept = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]/td[5]"))
					.getText();
			uniqueDepart.add(dept);
		}
		return uniqueDepart.size();
	}

	// program 2 : how many managers we have.
	static int uniqueManagersCount(WebDriver driver) {
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr//td[4]")).size();
		HashSet<String> uniqueManagerCount = new HashSet<String>();
		for (int index = 1; index <= row; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]//td[4]"))
					.getText();
			uniqueManagerCount.add(managerId);
		}
		return uniqueManagerCount.size();
	}

	static int uniqueEmployeeCount(WebDriver driver) {
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr//td[2]")).size();
		HashSet<String> uniqueEmployee = new HashSet<String>();
		for (int index = 1; index <= row; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + index + "]//td[2]"))
					.getText();
			uniqueEmployee.add(empId);	
		}

		return uniqueEmployee.size();
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

		int dept = uniqueDepartmentcount2(driver);
		System.out.println("total depratments are :" + dept);
		
		int empCount=uniqueEmployeeCount(driver);
		System.out.println("Employee count :" +empCount);

		int managerCount = uniqueManagersCount(driver);
		System.out.println("total Managers :" + managerCount);
		driver.close();
	}

}
