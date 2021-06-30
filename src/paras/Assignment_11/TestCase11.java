/*program 1: How many Depts we have.
ans : 4
program 2 : how many managers we have.
ans : 3
program 3: how many employees we have.
ans : 8
*/
package paras.Assignment_11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase11 {

	private static WebDriver driver;

	private static void uniqueDeptCount(WebDriver driver) {
		List<WebElement> listOfDept = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> setofDept = new HashSet<String>();
		for (WebElement dept : listOfDept) {
			setofDept.add(dept.getText());
		}
		System.out.println("Total Department Count : " + setofDept.size() + " " + setofDept );
	}

	private static void uniqueMngCount(WebDriver driver) {
		List<WebElement> listOfMng = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> setOfMng = new HashSet<String>();
		for (WebElement mng : listOfMng) {
			setOfMng.add(mng.getText());
		}
		System.out.println("Total Manager Count : " + setOfMng.size() + " " + setOfMng);
	}

	private static void uniqueEmpCount(WebDriver driver) {
		List<WebElement> listOfEmp = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		HashSet<String> setOfEmp = new HashSet<String>();
		for (WebElement Emp : listOfEmp) {
			setOfEmp.add(Emp.getText());
		}
		System.out.println("Total Employee Count : " + setOfEmp.size() + " " + setOfEmp);
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		uniqueDeptCount(driver);
		uniqueMngCount(driver);
		uniqueEmpCount(driver);
	}
}
