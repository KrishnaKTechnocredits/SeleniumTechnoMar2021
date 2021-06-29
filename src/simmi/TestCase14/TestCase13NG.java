/*TestCase 14: 19th Jun'2021 
	Remove main method from all assignments and use TestNG annotations.
 
 * program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4*/

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

public class TestCase13NG {
	
	HashMap<String, Integer> employeeUnderManager(WebDriver driver) {
		int managerCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		HashMap<String, Integer> mapOfManagers = new HashMap<String, Integer>();
		for (int index = 1; index <= managerCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (mapOfManagers.containsKey(deptName)) {
				mapOfManagers.put(deptName, mapOfManagers.get(deptName) + 1);
			} else
				mapOfManagers.put(deptName, 1);
		}
		return mapOfManagers;
	}

	
	static void verifyEmpDetails(HashMap<String, Integer> mapOfData) throws IOException {
		File file = new File(".//resources/CountEmployee.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);

		Set<String> keys = mapOfData.keySet();
		for (String currentKey : keys) {
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

		HashMap<String, Integer> output = employeeUnderManager(driver);
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
