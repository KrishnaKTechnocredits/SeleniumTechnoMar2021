package madhavi_Khasbage.Assignment_14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import madhavi_Khasbage.base.PredefinedActions;

/* Test Case 2
1. Launch a chrome
2. Open Google.com
3. Get page title name and verify with expected title
4. navigate to automationbykrishna.com
5. Get page title name and verify with expected title
6. navigate back in history
7. Get page title name and verify with expected title [google]
8. navigate forward in the history
9. Get page title name and verify with expected title [automationbykrishna]
10. refresh the page and verify the expected title [automationbykrishna]
11. Close the browser.
*/
public class TestCase2 {
	WebDriver driver;
	String expectedPage1URL = "";

	@BeforeMethod
	void setUp() {
		System.out.println("Step1: Launch browser");
		expectedPage1URL = "https://www.google.com/";		
		driver = PredefinedActions.setUp(expectedPage1URL);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.urlContains(expectedPage1URL));
	}

	@AfterMethod
	void tearDown() {
		System.out.println("Step11: Close browser");
		driver.close();
	}

	@Test
	public void vetifyURLAndURLTitle() {
		String expectedPage2URL = "http://automationbykrishna.com/";
		String expectedPage1Title = "Google";
		String expectedPage2Title = "Login Signup Demo";

		Assert.assertEquals(driver.getCurrentUrl(), expectedPage1URL, "Expected URL and current URL are same.");

		System.out.println("STEP3:Get page title name and verify with expected title");
		Assert.assertEquals(driver.getTitle(), expectedPage1Title,
				"Expected pagetitle and current pagetitle are same.");

		System.out.println("STEP4:navigate to automationbykrishna.com");
		driver.navigate().to(expectedPage2URL);
		System.out.println("STEP5:Get page title name and verify with expected title");
		Assert.assertEquals(driver.getTitle(), expectedPage2Title,
				"Expected pagetitle and current pagetitle are same.");

		System.out.println("STEP6:Navigate back in history");
		driver.navigate().back();
		System.out.println("STEP7:Get page title name and verify with expected title [google]");

		Assert.assertEquals(driver.getTitle(), expectedPage1Title,
				"Expected pagetitle and current pagetitle are same.");

		System.out.println("STEP8:Navigate forward in the history");
		driver.navigate().forward();
		System.out.println("STEP9:Get page title name and verify with expected title");
		Assert.assertEquals(driver.getTitle(), expectedPage2Title,
				"Expected pagetitle and current pagetitle are same.");

		System.out.println("STEP10:Refresh the page and verify the expected title");

		Assert.assertEquals(driver.getTitle(), expectedPage2Title,
				"Expected pagetitle and current pagetitle are same.");
		driver.navigate().refresh();

		System.out.println(driver.getTitle());

	}
}
