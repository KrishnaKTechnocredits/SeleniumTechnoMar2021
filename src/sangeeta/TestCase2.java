/*Test - 2

1. Launch a chrome
2. Open Google.com
3. Get page title name and verify with expected title
4. navigate to automationbykrishna.com
5. Get page title name and verify with expected title
6. navigate back in history
7. Get page title name and verify with expected title [google]
8. navigate forward in the history
9. Get page title name and verify with expected title [automationbykrishna]
10. refresh the page and verify the expected title [automationbykrishna]
11. Close the browser.*/

package sangeeta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		String expectedPageTitle = "Google";
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		if(pageTitle.equals(expectedPageTitle))
			System.out.println("Page title is correct");
		else
			System.out.println("Page title is not correct");
		driver.navigate().to("http://www.automationbykrishna.com");
		String expectedPageTitleABK = "Login Signup Demo";
		String pageTitleOfABK = driver.getTitle();
		if(pageTitleOfABK.equals(expectedPageTitleABK))
			System.out.println("Page title for ABK is correct");
		else
			System.out.println("Page title for ABK is not correct");
		driver.navigate().back();
		pageTitle = driver.getTitle();
		if(pageTitle.equals(expectedPageTitle))
			System.out.println("We have navigated back to Google");
		else
			System.out.println("We haven't navigated back to Google");
		driver.navigate().forward();
		pageTitleOfABK = driver.getTitle();
		if(pageTitleOfABK.equals(expectedPageTitleABK))
			System.out.println("Forword navigation is done");
		else
			System.out.println("Forword navigation is not done");
		driver.navigate().refresh();
		pageTitle = driver.getTitle();
		if(pageTitle.equals(expectedPageTitleABK))
			System.out.println("We are at Automation By Krishna");
		else
			System.out.println("We are not at expected URL");
		driver.quit();
	}

}
