/*Test case : 10

Name -> "Maulik", print lastName and UserName*/

package simmi.TestCase14;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase10NG {

	static HashMap<String, String> getLastName(WebDriver driver) {
		String lastName = driver
				.findElement(By.xpath("//table[@class='table']/tbody//td[text()='Maulik']//following::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath("//table[@class='table']/tbody//td[text()='Maulik']//following::td[2]"))
				.getText();
		HashMap<String, String> dataMap = new HashMap<String, String>();
		dataMap.put(lastName, userName);
		return dataMap;
	}

	@Test
	public void operation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']")));

		HashMap<String, String> lastName = getLastName(driver);
		System.out.println(lastName);
		
		driver.close();
	}
}
