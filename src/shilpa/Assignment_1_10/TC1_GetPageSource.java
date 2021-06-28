package shilpa.Assignment_1_10;
/* TC-1
1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GetPageSource {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		String url = "http://automationbykrishna.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		String pageTitle=driver.getTitle();
		String pageSource=driver.getPageSource();
		if(url.equals(currentUrl)) {
			System.out.println("Current URL is opened");
		}else {
			System.out.println("URL is not correct");
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println("Page Title - "+pageTitle);
		System.out.println("Title Length - "+pageTitle.length());
		System.out.println("Page Source Length - "+pageSource.length());
		driver.close();
	}
}
