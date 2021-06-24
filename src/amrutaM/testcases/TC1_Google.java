package amrutaM.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import amrutaM.base.PredefinedActions;


/*Test case - 1

1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.
*/

public class TC1_Google {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "/SeleniumBasics/chromedriver.exe");
		String url = "https://www.google.com/";
		WebDriver driver = PredefinedActions.setUp(url);
		int titleLength = driver.getTitle().length();
		System.out.println("Page Title is: "+driver.getTitle());
		System.out.println("Page Title length is: "+titleLength);
		String currentURL = driver.getCurrentUrl();
		if(url.equals(currentURL)){
			System.out.println("Correct URL entered!!!");
		}else {
			System.out.println("Incorrect URL! Please check again.");
		}
		System.out.println("Page Source is: ---------> "+driver.getPageSource());	
		System.out.println("Page Source length is: "+driver.getPageSource().length());
		PredefinedActions.tearDown();
	}
}
