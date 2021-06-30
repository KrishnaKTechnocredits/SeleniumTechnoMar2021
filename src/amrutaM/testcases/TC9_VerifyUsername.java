package amrutaM.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import amrutaM.base.PredefinedActions;

/*verify username from table "EMPLOYEE BASIC INFORMATION"
*/
public class TC9_VerifyUsername {

	static ArrayList<String> getActualUsername(WebDriver driver) {
		System.out.println("Fetching the complete data of the table ");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int totalRows = rows.size();
		ArrayList<String> actualUsername = new ArrayList<String>();
		for (int index = 1; index <= totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			String uname = firstName.charAt(0) + lastName;
			uname = uname.toLowerCase();
			actualUsername.add(uname);
		}
		return actualUsername;
	}

	static WebDriver driver;

	public static void main(String[] args) {
		System.out.println("STEP: Launching the browser");
		System.out.println("STEP: Navigating to automationbykrishna.com");
		driver = PredefinedActions.setUp();
		System.out.println("Clicking on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("STEP: Waiting for page to load");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='empbasic']")));
		ArrayList<String> actualUsername = getActualUsername(driver);
		System.out.println("Usernames are  " + actualUsername);
		ArrayList<String> expectedUsername = new ArrayList<String>(
				Arrays.asList("mkanani", "kkanani", "dboda", "asharma", "ppatro"));
		System.out.println("Comparing usernames ");
		Assert.assertEquals(actualUsername, expectedUsername, "Username did not match");
		System.out.println("STEP : Username matched! so closing the browser");
		PredefinedActions.tearDown();
	}
}
