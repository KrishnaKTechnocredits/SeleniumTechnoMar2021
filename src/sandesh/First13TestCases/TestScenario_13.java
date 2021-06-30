/*program 1: count number of employee under each manager, verify count against properties file.
output : 
20209 -> 3
20205 -> 3
10101 -> 2
*/

package sandesh.First13TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario_13 {

	private boolean compareWebAndPropertiesFile(WebDriver driver) throws IOException {
		File file = new File(".\\src\\sandesh\\resources\\DeptInfo.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("demotable")).click();

		HashSet<String> setOfEmpIDs = new HashSet<String>();
		LinkedHashMap<String, Integer> mapOfManagerEmpCount = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= driver
				.findElements(By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr")).size(); index++)
			if (setOfEmpIDs.add(driver
					.findElement(
							By.xpath("//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[2]"))
					.getText())) {
				if (mapOfManagerEmpCount.containsKey(driver
						.findElement(By.xpath(
								"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
						.getText())) {
					mapOfManagerEmpCount.put(
							driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
									.getText(),
							mapOfManagerEmpCount.get(driver.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
									.getText()) + 1);
				} else
					mapOfManagerEmpCount.put(driver
							.findElement(By.xpath(
									"//header[contains(text(),'Employee Manager')]/..//tbody/tr[" + index + "]/td[4]"))
							.getText(), 1);
			}

		System.out.println(mapOfManagerEmpCount);
		boolean allValuesFlag = true;
		Set<String> keys = mapOfManagerEmpCount.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			String currentKey = itr.next();

			if (mapOfManagerEmpCount.get(currentKey) != Integer.parseInt(prop.getProperty(currentKey))) {
				allValuesFlag = false;
				break;
			}
		}
		return allValuesFlag;
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		boolean compareValuesResult = new TestScenario_13().compareWebAndPropertiesFile(driver);
		System.out.println(compareValuesResult);
	}
}
