/*
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
11. Close the browser.
 */
package paras.Test_Case_1_to_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open Google.com
		driver.get("https://www.google.com");
		// Expected Google Page Title
		String googleTitle = "Google";
		// Expected automationByKrishnaTitle Page Title
		String automationByKrishnaTitle = "Login Signup Demo";
		// Get Google Page Title
		String googlepageTitle = driver.getTitle();
		// Comparing Actual Google page title with Expected one.
		if (googlepageTitle.equals(googleTitle)) {
			System.out.println("Google Title Test Pass");
		} else {
			System.out.println("Google Title Test Fail");
		}
		// Navigate to automationbykrishna.com
		driver.navigate().to("http://automationbykrishna.com/");
		Thread.sleep(2000);
		// Get automationByKrishna Page Title
		String automationByKrishnapageTitle = driver.getTitle();
		// Comparing Actual automationByKrishna page title with Expected one.
		if (automationByKrishnapageTitle.equals(automationByKrishnaTitle)) {
			System.out.println("automationByKrishna Title Test Pass");
		} else {
			System.out.println("automationByKrishna Title Test Fail");
		}
		Thread.sleep(2000);
		// navigate back in history
		driver.navigate().back();
		// Comparing Actual Google page title with Expected one.
		if (googlepageTitle.equals(googleTitle)) {
			System.out.println("Google Title Test Pass");
		} else {
			System.out.println("Google Title Test Fail");
		}
		Thread.sleep(2000);
		// navigate forward in the history
		driver.navigate().forward();
		// Comparing Actual automationByKrishna page title with Expected one.
		if (automationByKrishnapageTitle.equals(automationByKrishnaTitle)) {
			System.out.println("automationByKrishna Title Test Pass");
		} else {
			System.out.println("automationByKrishna Title Test Fail");
		}
		Thread.sleep(2000);
		// refresh the page
		driver.navigate().refresh();
		// Comparing Actual automationByKrishna page title with Expected one.
		if (automationByKrishnapageTitle.equals(automationByKrishnaTitle)) {
			System.out.println("automationByKrishna Title Test Pass");
		} else {
			System.out.println("automationByKrishna Title Test Fail");
		}
		Thread.sleep(2000);
		// Close the browser
		driver.close();
	}
}