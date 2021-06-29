
/*TestCase 13:
 * 
 * program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
*/

package simmi.TestCase_13;

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

public class TestCase13 {

	static HashMap<String, Integer> employeeUnderManager(WebDriver driver) {
		int ManagerCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		HashMap<String, Integer> mapOfManagers = new HashMap<String, Integer>();
		for (int index = 1; index <= ManagerCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (mapOfManagers.containsKey(deptName))
				mapOfManagers.put(deptName, mapOfManagers.get(deptName) + 1);
			else
				mapOfManagers.put(deptName, 1);
		}
		return mapOfManagers;
	}

	static void verifyDeptDeptData(HashMap<String, Integer> mapOfDepts) throws IOException{
		
	File file = new File(".//resources/CountEmployee.properties");
	FileInputStream inputStream = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(inputStream);
	
	Set<String> keys = mapOfDepts.keySet();
	for (String currentKey : keys) {
		int deptCountExpected = Integer.parseInt(prop.getProperty(currentKey));
		int deptCountActual = mapOfDepts.get(currentKey);
		if (deptCountActual == deptCountExpected) 
			System.out.println("Test Pass");
		 else 
			System.out.println("Test Failed");
	}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - OPEN DEMOTABLE PAGE ");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		HashMap<String, Integer> output = employeeUnderManager(driver);
		System.out.println("Employee count under each manager are" + output);

		try {
			verifyDeptDeptData(output);
		} catch (IOException e) {
			System.out.println("Manager ID provided is not available");
		}
		driver.close();
	}
}
