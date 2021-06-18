package simmi.TestCase_12;

/*program 1: emplyee count in each deptName*/
/*program 1: count number of employee under each manager, verify count against properties file.*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase12 {
	static HashMap<String, Integer> getDepartmentDetails(WebDriver driver) {
		int deptCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		HashMap<String, Integer> mapOfDepts = new HashMap<String, Integer>();
		for (int index = 1; index <= deptCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (mapOfDepts.containsKey(deptName)) {
				mapOfDepts.put(deptName, mapOfDepts.get(deptName) + 1);
			} else {
				mapOfDepts.put(deptName, 1);
			}
		}
		return mapOfDepts;
	}

	static void verifyDeptDeptData(HashMap<String, Integer> mapOfDepts) throws IOException {
		File file = new File(".//SeleniumTechnoMar2021/src/simmi/TestCase_12/PropertyFiles.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);

		Set<String> keys = mapOfDepts.keySet();
		for (String currentKey : keys) {
			int deptCountExpected = Integer.parseInt(prop.getProperty(currentKey));
			int deptCountActual = mapOfDepts.get(currentKey);
			if (deptCountActual == deptCountExpected) {
				System.out.println("Test Pass");
			} else {
				System.out.println("Test Failed");
			}
		}
	}

	static HashMap<String, Integer> getEmpDetails(WebDriver driver) {
		int ManagerCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		HashMap<String, Integer> mapOfManagers = new HashMap<String, Integer>();
		for (int index = 1; index <= ManagerCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (mapOfManagers.containsKey(deptName)) {
				mapOfManagers.put(deptName, mapOfManagers.get(deptName) + 1);
			} else {
				mapOfManagers.put(deptName, 1);
			}
		}
		return mapOfManagers;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		HashMap<String, Integer> output = getDepartmentDetails(driver);
		System.out.println("Empolyee count in each deptName " + output);

		HashMap<String, Integer> empUnderManager = getEmpDetails(driver);
		System.out.println("Number of employee under each manager " + empUnderManager);

		driver.close();
	}
}
