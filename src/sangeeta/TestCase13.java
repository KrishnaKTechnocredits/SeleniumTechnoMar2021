/*program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
*/
package sangeeta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase13 {
	
	static HashMap<String, Integer> employeeCountManagerWise(WebDriver driver) {
		HashMap<String, Integer> empCount = new HashMap<String, Integer>();
		List<WebElement> empList = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for (WebElement currentKey : empList) {
			String temp = currentKey.getText();
			if (empCount.containsKey(currentKey.getText()))
				empCount.put(temp, empCount.get(temp) + 1);
			else
				empCount.put(temp, 1);
		}
		return empCount;
	}
	
	static void verifyEmpData(HashMap<String,Integer> empMap) throws IOException {
		File file = new File("D:\\Automation Testing\\Java\\Workspace\\SeleniumTechnoMar2021\\src\\sangeeta\\EmpData.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputStream);
		
		Set<String> keys = empMap.keySet();
		for(String currentKey : keys) {
			int empCountExpected = Integer.parseInt(prop.getProperty(currentKey));
			int empCountActual = empMap.get(currentKey);
			if(empCountExpected == empCountActual)
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Launch a WebBrowser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open a given URL");
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		HashMap<String, Integer> empMap = employeeCountManagerWise(driver);
		System.out.println(empMap);
		verifyEmpData(empMap);
	}


}
