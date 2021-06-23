/*Test case - 1 [5th June 2021]

1. Launch a Chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.

*/

package vaibhav.TestCase_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {

		System.out.println("Step 1 : Launch a chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step 2 : Open Google.com");
		String url = "https://www.google.com/";
		driver.get(url);

		System.out.println("Step 3 : Get page title name and length and print on console");
		System.out.println("Current page title is : " + driver.getTitle());

		System.out.println("Step 4 : Get page URL and verify if it is a correct or not");
		String currentURL = driver.getCurrentUrl();
		if (url.equals(currentURL))
			System.out.println("Test Pass : Current url is same as expected url");
		else
			System.out.println("Test fail : Current url is differnt than expected url");

		System.out.println("Step 5 : Get page source and page source length and print on console");
		System.out.println("Current page source length is : " + driver.getPageSource().length());
	
		System.out.println("Step 6 : Close Browser");
		driver.close();

	}

}
