package madhavi_Raut.Assignment_01_10.TestCase_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case - 2
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

public class Navigation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("------Navigating to Google------");
		if (driver.getTitle().equals("Google"))
			System.out.println("Page Title is correct: Google");
		else
			System.out.println("Page Title is incorrect.");

		System.out.println("------Navigating to automationByKrishna------");
		driver.get("http://automationbykrishna.com/");
		if (driver.getTitle().equals("Login Signup Demo"))
			System.out.println("Page Title is correct: automationbykrishna");
		else
			System.out.println("Page Title is incorrect.");

		System.out.println("------Navigating back to Google------");
		driver.navigate().back();
		if (driver.getTitle().equals("Google"))
			System.out.println("Page Title is correct: Google");
		else
			System.out.println("Page Title is incorrect.");

		System.out.println("------Navigating forward to automationbykrishna------");
		driver.navigate().forward();
		if (driver.getTitle().equals("Login Signup Demo"))
			System.out.println("Page Title is correct: automationbykrishna");
		else
			System.out.println("Page Title is incorrect.");

		System.out.println("------Refreshing the browser------");
		driver.navigate().refresh();
		if (driver.getTitle().equals("Login Signup Demo"))
			System.out.println("Page Title is correct: automationbykrishna");
		else
			System.out.println("Page Title is incorrect.");

		System.out.println("Browser closed");
		driver.close();
	}
}
