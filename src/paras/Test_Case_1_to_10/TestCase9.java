/*
Test case : 9

verify username from table "EMPLOYEE BASIC INFORMATION"

firstName
lastName
expectedUsername = "mkanani";
actualUserName = firstName.charAt(0) + lastName;
actualUserName = actualUserName.toLowerCase();
 */
package paras.Test_Case_1_to_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase9 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String expectedUserName = firstName.substring(0, 1) + lastName;

			if (actualUserName.equals(expectedUserName.toLowerCase())) {
				System.out.println(firstName + " " + lastName + "" + " = " + expectedUserName + " :- " + "Test Pass");
			} else {
				System.out.println("Test Fail");
			}
		}
	}
}