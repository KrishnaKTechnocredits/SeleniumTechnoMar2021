package simmi.TestCase_7to12;

import java.util.HashMap;

/*Test case : 10

Name -> "Maulik", print lastName and UserName*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase10 {

	static HashMap<String, String> getEmployeeDetails(String name, WebDriver driver) {
		String lastName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Maulik']//following-sibling::td[2]"))
				.getText();

		HashMap<String, String> empDetailsMap = new HashMap<String, String>();
		empDetailsMap.put("Last Name", lastName);
		empDetailsMap.put("Username", userName);

		return empDetailsMap;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[2]")).getText();

		HashMap<String, String> getDetails = getEmployeeDetails(name, driver);
		System.out.println("LastName and UserName of Maulik is " + getDetails);
		driver.close();
	}
}
