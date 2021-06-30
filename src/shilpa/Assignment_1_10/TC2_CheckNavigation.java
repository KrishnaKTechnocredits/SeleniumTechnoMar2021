package shilpa.Assignment_1_10;

/*TC-2
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
import org.openqa.selenium.WebDriver;

public class TC2_CheckNavigation {
	void verifyResult(String expectedTitle, String actualTitle) {
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");
	}

	void checkPageNavigation() {
		WebDriver driver = new LaunchBrowser().start("https://www.google.com/");

		System.out.println("Step3 - Get page title name and verify with expected title");
		verifyResult("Google", driver.getTitle());

		System.out.println("STEP4-Navigate to automationbkrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("STEP5-Get page title name and verify with expected title");
		verifyResult("Login Signup Demo", driver.getTitle());

		System.out.println("STEP6-navigate back in history");
		driver.navigate().back();

		System.out.println("STEP7-Get page title name and verify with expected title [google]");
		verifyResult("Google", driver.getTitle());

		System.out.println("STEP8-navigate forward in the history");
		driver.navigate().forward();

		System.out.println("STEP9-Get page title name and verify with expected title [automationbykrishna]");
		verifyResult("Login Signup Demo", driver.getTitle());

		System.out.println("STEP10-refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();
		verifyResult("Login Signup Demo", driver.getTitle());

		System.out.println("STEP11-Close the browser");
		driver.close();
	}

	public static void main(String[] args) {
		TC2_CheckNavigation checkNavigation = new TC2_CheckNavigation();
		checkNavigation.checkPageNavigation();
	}

}
