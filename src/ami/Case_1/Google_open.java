/*
 Test case - 1

1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.
 */

package ami.Case_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_open {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");

		// 1. Launch a chrome
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";

		// 2. Open Google.com
		driver.get(url);

		// 3. Get page title name and length and print on console
		String title = driver.getTitle();
		System.out.println("web page title : " + title);
		System.out.println("web page title length : " + title.length());

		// 4. Get page URL and verify if it is a correct or not.
		String currentUrl = driver.getCurrentUrl();
		if (url.equals(currentUrl)) {
			System.out.println("given url correct");
		} else {
			System.out.println("given url is not match with currenturl.");
		}

		// 5. Get page source and page source length and print on console
		String pageSource = driver.getPageSource();
		System.out.println("pageSource length  : " + pageSource.length());
		// System.out.println("pageSource : " + pageSource);

		// 6. Close the browser.
		driver.close();
	}

}
