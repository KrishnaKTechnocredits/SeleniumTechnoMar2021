import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case - 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/

public class LaunchBrowserExample1 {
	public static void main(String[] args) throws InterruptedException {
		String expectedURL = "https://www.google.com/";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String currentURL = driver.getCurrentUrl();
		if (expectedURL.equals(currentURL)) {
			String pageTitle = driver.getTitle();
			String pageSource = driver.getPageSource();
			Thread.sleep(2000);
			System.out.println("Correct URL");
			System.out.println("Page title:" + pageTitle + " Title length:" + pageTitle.length());
			//System.out.println("Page source:" + pageSource );
			System.out.println("Page source length :" + pageSource.length());
		}
		driver.close();
	}

}
