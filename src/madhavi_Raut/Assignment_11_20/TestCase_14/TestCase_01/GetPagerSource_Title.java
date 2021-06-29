package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*Test case - 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/
public class GetPagerSource_Title {
	WebDriver driver;
	String sourceUrl;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver  = new ChromeDriver();
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
	public void verifyUrl() {
		String destinationUrl = driver.getCurrentUrl();
		// Verify if source and destination url are same.
		Assert.assertEquals(sourceUrl, destinationUrl, "Source and Destination Url are same.");
		String title = driver.getTitle();
		System.out.println("Title: " + title + "\nTitle length: " + title.length());
		// Get page Source
		String pageSource = driver.getPageSource();
		System.out.println("Page Source: " + pageSource.substring(0,20) + " \nPage Source length: " + pageSource.length());
		}
}
