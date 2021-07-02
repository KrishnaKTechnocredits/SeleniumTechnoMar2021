package madhavi_Khasbage.Assignment_14;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import madhavi_Khasbage.base.PredefinedActions;

/*Name -> "Maulik", print lastName and UserName*/

public class TestCase10 {
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
	void printName() {
		String name = "Maulik";
		System.out.println("STEP2: Click on demotable");
		driver.findElement(By.id("demotable")).click();

		// WebDriverWait wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP3: Find table");
		int size = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();

		System.out.println("STEP4: Find " + name + " Firstname and Username");
		try {
			for (int index = 1; index <= size; index++) {
				String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
						.getText();

				Assert.assertEquals(firstName, name);

				String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
						.getText();

				String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();

				System.out.println("Maulik's Last name= " + lastName + " and User name = " + userName);

			}
		} catch (AssertionError err) {
		}

	}
}
