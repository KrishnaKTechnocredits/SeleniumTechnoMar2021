package madhavi_Khasbage.Assignment_14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import madhavi_Khasbage.base.PredefinedActions;

/* Test Case 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.
*/
public class TestCase1 {
	WebDriver driver;
	String expectedURL="";
	
	@BeforeMethod
	void setUp() {
		System.out.println("Step1: Launch browser");
	    expectedURL = "https://www.google.com/";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = PredefinedActions.setUp(expectedURL);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.urlContains(expectedURL));
	}
	
	@AfterMethod
	void tearDown() {		
		System.out.println("Step3: close browser");
		driver.close();
	}

	@Test
	public void verifyPageURL() {		
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, expectedURL,"Expected URL and current URL are same.");
		String pageTitle = driver.getTitle();
		String pageSource = driver.getPageSource();
		System.out.println("Page title:" + pageTitle + " Title length:" + pageTitle.length());
		System.out.println("Page source:" + pageSource.substring(0,50) );
		System.out.println("Page source length :" + pageSource.length());		
	}
}
