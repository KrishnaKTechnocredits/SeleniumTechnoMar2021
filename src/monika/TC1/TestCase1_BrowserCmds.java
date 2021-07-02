package monika.TC1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*Test case - 1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/

public class TestCase1_BrowserCmds {
	
	@Test
	public static void main() throws InterruptedException {
		// 1. Launch a chrome
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// 2. Open Google.com
		String url = "http://google.com";
		driver.get(url);
		// 3. Get page title name and length and print on console
		String title = driver.getTitle();
		System.out.println("Title : "+title +", Length of title : "+ title.length());
		// 4. Get page URL and verify if it is a correct or not.
		String result = driver.getCurrentUrl();
		System.out.println("Current URL : " + result);
		// 5. Get page source and page source length and print on console
		String pagesource = driver.getPageSource();
		System.out.println("Length of PS : " + pagesource.length());
		System.out.println("END1");
		// 6. Close the browser.
		// driver.close();
		driver.quit();
		//System.out.println(driver.getTitle());
		System.out.println("END");
	}
}
