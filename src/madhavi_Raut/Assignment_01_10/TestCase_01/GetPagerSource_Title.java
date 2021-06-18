package madhavi_Raut.Assignment_01_10.TestCase_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case - 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/
public class GetPagerSource_Title {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String sourceUrl = "https://www.google.com/";
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String destinationUrl = driver.getCurrentUrl();
		// Verify if source and destination url are same.
		if (sourceUrl.equals(destinationUrl))
			System.out.println("Source and Destination Url are same.");
		else
			System.out.println("Source and Destination Url are different.");
		String title = driver.getTitle();
		System.out.println("Title: " + title + "\nTitle length: " + title.length());
		// Get page Source
		String pageSource = driver.getPageSource();
		System.out.println("Page Source: " + pageSource.substring(0,20) + " \nPage Source length: " + pageSource.length());
		driver.close();
	}
}
