/*Test case - 1

1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/

package sangeeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		int lengthOfPageTitle = pageTitle.length();
		System.out.println("Page title of current URL is "+pageTitle);
		System.out.println("Length of page title is " +lengthOfPageTitle);
		String currentURL = driver.getCurrentUrl();
		if(url.equals(currentURL))
			System.out.println("Correct URL is opened");
		else
			System.out.println("Incorrect URL opened");
		
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		System.out.println("Length of page source is "+pageSourceLength);
		
		driver.close();
	}

}
