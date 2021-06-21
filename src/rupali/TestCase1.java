package rupali;
/*

 * Test case - 1

1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.

 */
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class TestCase1 {
	
	public void getTitlename() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		String str=driver.getTitle();
		System.out.println(str);
		String pgsource=driver.getPageSource();
		System.out.println(pgsource+pgsource.length());
		
	}
}
