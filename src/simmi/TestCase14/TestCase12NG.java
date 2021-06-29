/*Test case - 12: 16th Jun'2021
program 1: emplyee count in each deptName
7001 - Admin : 2
7001 - Finance : 2
etc.*/

package simmi.TestCase14;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase12NG {

	HashMap<String, Integer> employeeUnderDept(WebDriver driver) {
		int empDept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		HashMap<String, Integer> mapOfDepts = new HashMap<String, Integer>();
		for (int index = 1; index <= empDept; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (mapOfDepts.containsKey(deptName))
				mapOfDepts.put(deptName, mapOfDepts.get(deptName) + 1);
			else
				mapOfDepts.put(deptName, 1);
		}
		return mapOfDepts;
	}

	static void verifyEmpDetails(HashMap<String, Integer> mapOfData) throws IOException {
		File file = new File(".//resources/EmployeeDeptCount.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);

		Set<String> deptKeys = mapOfData.keySet();
		for (String currentKey : deptKeys) {
			int deptCountExpected = Integer.parseInt(prop.getProperty(currentKey));
			int deptCountActual = mapOfData.get(currentKey);
			if (deptCountActual == deptCountExpected)
				System.out.println("Test Pass");
			else
				System.out.println("Test Failed");
		}
	}

	@Test
	public void Operation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - OPEN DEMOTABLE PAGE ");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		HashMap<String, Integer> output = employeeUnderDept(driver);
		System.out.println("Employee count under each manager are" + output);

		try {
			verifyEmpDetails(output);
		} catch (IOException e) {
			System.out.println("Manager ID provided is not available");
			e.printStackTrace();
		}
		driver.close();
	}
}
