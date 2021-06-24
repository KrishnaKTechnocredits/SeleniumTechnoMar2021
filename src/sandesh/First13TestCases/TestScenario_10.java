/*Test case : 10
Name -> "Maulik", print lastName and UserName*/

package sandesh.First13TestCases;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario_10 {

	private LinkedHashMap<String, String> getLastAndUserName(String inputStr) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String lastName = driver
				.findElement(By.xpath("//table[@id='table1']//td[text()='Maulik']/following-sibling::td[1]")).getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']//td[text()='Maulik']/following-sibling::td[2]")).getText();
		LinkedHashMap<String, String> mapOfLastAndUserNames = new LinkedHashMap<String, String>();
		mapOfLastAndUserNames.put("Last Name", lastName);
		mapOfLastAndUserNames.put("User Name", userName);
		return mapOfLastAndUserNames;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		String nameToFind = "Maulik";
		LinkedHashMap<String, String> mapOfNames = new TestScenario_10().getLastAndUserName(nameToFind);
		System.out.println("LastName and UserName for " + nameToFind + " is -: ");
		System.out.println(mapOfNames);
	}
}
