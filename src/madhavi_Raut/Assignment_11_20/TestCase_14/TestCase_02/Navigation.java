package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Test case - 2
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
11. Close the browser.*/
public class Navigation {

	WebDriver driver;
	String sourceUrl;
	
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		sourceUrl = "https://www.google.com/";
		driver.get(sourceUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	public void verifyNavigation() {
		System.out.println("------Navigating to Google------");
		Assert.assertEquals(driver.getTitle(), "Google", "Page Title is incorrect.");
		System.out.println("------Navigating to automationByKrishna------");
		driver.get("http://automationbykrishna.com/");
		Assert.assertEquals(driver.getTitle(), "Login Signup Demo", "Page Title is incorrect.");
		System.out.println("------Navigating back to Google------");
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Google", "Page Title is incorrect.");
		System.out.println("------Navigating forward to automationbykrishna------");
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "Login Signup Demo", "Page Title is incorrect.");
		System.out.println("------Refreshing the browser------");
		driver.navigate().refresh();
		Assert.assertEquals(driver.getTitle(), "Login Signup Demo", "Page Title is incorrect.");
	}
}
