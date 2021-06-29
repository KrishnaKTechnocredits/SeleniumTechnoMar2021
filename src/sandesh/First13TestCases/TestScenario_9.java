/*Test case : 9
verify username from table "EMPLOYEE BASIC INFORMATION"*/

package sandesh.First13TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_9 {

	private boolean verifyUsername() {
		boolean userNameValidated = true;
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[contains(text(),'Employee Basic')]")));
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		String fName = "";
		String lName = "";
		String actualUserName = "";
		String expectedUserName = "";
		char fNameFirstChar = ' ';

		for (int index = 1; index <= listOfRows.size(); index++) {
			fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText()
					.toLowerCase();
			lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText()
					.toLowerCase();
			expectedUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			fNameFirstChar = fName.charAt(0);
			actualUserName = fNameFirstChar + lName;
			if (!actualUserName.equals(expectedUserName)) {
				userNameValidated = false;
				break;
			}
		}
		return userNameValidated;
	}

	public static void main(String[] args) {
		// table[@id='table1']/tbody/tr/td[2]
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		boolean allEntriesValidated = new TestScenario_9().verifyUsername();
		if (allEntriesValidated)
			System.out.println("All entries are correct");
		else
			System.out.println("Some entries are INCORRECT");
	}
}
