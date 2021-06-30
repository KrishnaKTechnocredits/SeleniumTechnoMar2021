/*
program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2
 */
package paras.Assignment_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase13 {

	private static WebDriver driver;

	void countOfEmpUnderMng() throws IOException, InterruptedException {
		File file = new File(".//resources/ManagerDetails");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		HashMap<String, Integer> empManagerID = new HashMap<String, Integer>();

		List<WebElement> deptList = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		System.out.println("Count of Employee in each Department");
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='empmanager']")));
		for (WebElement dept : deptList) {
			String deptName = dept.getText();
			if (empManagerID.containsKey(deptName)) {
				empManagerID.put(deptName, empManagerID.get(deptName) + 1);
			} else {
				empManagerID.put(deptName, 1);
			}
		}
		System.out.println(empManagerID);
		System.out.println("\nVerifying Data with Property file");
		Set<String> managerIDInfo = empManagerID.keySet();
		for (String managerID : managerIDInfo) {
			if (prop.getProperty(managerID).equals(String.valueOf(empManagerID.get(managerID)))) {
				System.out.println("Employee count fetched for " + managerID + " is Correct");
			} else {
				System.out.println("Employee count fetched for " + managerID + " is InCorrect");
			}
		}
		driver.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new TestCase13().countOfEmpUnderMng();
	}
}
