package simmi.TestCase_7to12;

import java.util.ArrayList;
import java.util.List;

/*Test case : 9

verify username from table "EMPLOYEE BASIC INFORMATION"*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase9 {

	static void getEmployeeDetails(WebDriver driver) {
		List<WebElement> fNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<WebElement> lNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		ArrayList<String> firstNameList = new ArrayList<String>();
		ArrayList<String> lName = new ArrayList<String>();
		for (WebElement firstName : fNameElement) {
			firstNameList.add(firstName.getText());
		}

		for (WebElement lastName : lNameElement) {
			lName.add(lastName.getText());
		}

		List<WebElement> userName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		ArrayList<String> actualUserName = new ArrayList<String>();
		for (WebElement uName : userName) {
			actualUserName.add(uName.getText());
		}
		ArrayList<String> expectedUsername = new ArrayList<String>();
		for (int index = 0; index < firstNameList.size(); index++) {
			expectedUsername.add(userName(firstNameList.get(index).toLowerCase(), lName.get(index)));
		}
		uNameComparision(expectedUsername, actualUserName);

	}

	static String userName(String fName, String lName) {
		String uName = "";
		uName = fName.charAt(0) + lName.toLowerCase();
		return uName;
	}

	static void uNameComparision(ArrayList<String> expectedUsername, ArrayList<String> actualUserName) {
		for (int index = 0; index < expectedUsername.size(); index++) {
			if (expectedUsername.get(index).equals(actualUserName.get(index)))
				System.out.println("Expected user name " + expectedUsername.get(index) + " is equal to "
						+ " actual user name " + actualUserName.get(index));
			else
				System.out.println("Expected user name " + expectedUsername.get(index) + " is not equal to "
						+ " actual user name " + actualUserName.get(index));
		}
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		getEmployeeDetails(driver);

		driver.close();
	}
}
