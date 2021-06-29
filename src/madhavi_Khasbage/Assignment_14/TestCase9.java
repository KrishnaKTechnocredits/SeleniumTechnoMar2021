package madhavi_Khasbage.Assignment_14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/* test case 9 >> verify username from table "EMPLOYEE BASIC INFORMATION"*/

public class TestCase9 {
	WebDriver driver;
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		String expectedURL = "http://automationbykrishna.com/";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step5: Close browser");
		driver.close();
	}

	@Test
	void verifyUserName() {
		System.out.println("STEP2: Click on demo table");

		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		System.out.println("STEP3: Find table");
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='table1']//tr"));

		int size = element.size();

		String fname, lname, uname;

		System.out.println("STEP4: Get FiesrName, LastName, UserName from table and verify");
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
	}

}
