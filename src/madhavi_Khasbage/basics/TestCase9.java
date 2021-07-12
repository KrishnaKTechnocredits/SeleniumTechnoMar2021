package madhavi_Khasbage.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.base.PredefinedActions;

/* test case 9 >> verify username from table "EMPLOYEE BASIC INFORMATION"*/

public class TestCase9 {

	static void verifyUserName() {
		System.out.println("STEP1: Open url on browser");
		String expectedURL = "http://automationbykrishna.com/";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		System.out.println("STEP2: Find table");
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='table1']//tr"));

		int size = element.size();

		String fname, lname, uname;

		System.out.println("STEP3: Get FiesrName, LastName, UserName from table and verify");
		for (int index = 1; index < size; index++) {

			fname = driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[2]")).getText();

			lname = driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[3]")).getText();

			uname = driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[4]")).getText();

			if (uname.equals((fname.charAt(0) + lname).toLowerCase())) {
				System.out.println(fname + " " + lname + "'s user name " + uname + " is correct.");
			} else {
				System.out.println(fname + " " + lname + "'s user name " + uname + " is incorrect.");
			}

		}
		System.out.println("STEP4: Close browser");
		driver.close();

	}

	public static void main(String[] args) {
		verifyUserName();
	}
}
