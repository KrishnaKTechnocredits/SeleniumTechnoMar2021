/*Test case : 9

verify username from table "EMPLOYEE BASIC INFORMATION"*/

package simmi.TestCase14;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase9NG {

	static void getEmployeeDetails(WebDriver driver) {
		List<WebElement> firstName = driver.findElements(By.xpath("//table[@class='table']/tbody//td[2]"));
		List<WebElement> lastName = driver.findElements(By.xpath("//table[@class='table']/tbody//td[3]"));
		List<WebElement> userName = driver.findElements(By.xpath("//table[@class='table']/tbody//td[4]"));

		ArrayList<String> firstNameList = new ArrayList<String>();
		ArrayList<String> lastNameList = new ArrayList<String>();
		ArrayList<String> actualUserNameList = new ArrayList<String>();

		for (WebElement fName : firstName) {
			firstNameList.add(fName.getText());
		}

		for (WebElement lname : lastName) {
			lastNameList.add(lname.getText());
		}

		for (WebElement uname : userName) {
			actualUserNameList.add(uname.getText());
		}
		ArrayList<String> expectedUserName = new ArrayList<String>();
		for (int index = 0; index < firstNameList.size(); index++) {
			expectedUserName.add(userName(firstNameList.get(index).toLowerCase(), lastNameList.get(index)));
		}
		uNameComparision(expectedUserName, actualUserNameList);
	}

	static String userName(String fName, String lName) {
		String uName = "";
		uName = fName.charAt(0) + lName.toLowerCase();
		return uName;
	}

	static void uNameComparision(ArrayList<String> expectedUserName, ArrayList<String> actualUserNameList) {
		for (int index = 0; index < expectedUserName.size(); index++) {
			if (expectedUserName.get(index).equals(actualUserNameList.get(index))) {
				System.out.println("Expected user name " + expectedUserName.get(index) + " is equal to "
						+ " actual user name " + actualUserNameList.get(index));
			} else {
				System.out.println("Expected user name " + expectedUserName.get(index) + " is not equal to "
						+ " actual user name " + actualUserNameList.get(index));
			}
		}
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

		getEmployeeDetails(driver);
		
		driver.close();
	}
}
